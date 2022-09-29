import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class EncryptionProgram {
	
	private Scanner scanner;
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String line;
	private char[] letters;
	private char[] secretLetters;
 	

	EncryptionProgram(){
		scanner = new Scanner(System.in);
		random = new Random();
		list = new ArrayList();
	    shuffledList = new ArrayList();
		character = ' ';

		askQuestion();
	}
	
	//ask the user what they want to do
	//gen new key | use current key | encrypt msg | decrypt msg | quit
	private void askQuestion() {
		while(true) {
			System.out.println("\n********************************************\n");
			System.out.println("Welcome to the Encryption Program!\n");
			System.out.println("What you want to do?");
			System.out.println("(N)ewKey **Old KEYS will be erased**\n(G)etKey\n(E)ncrypt\n(D)ecrypt\n(Q)uit");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch(response) {
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':	
				quit();
				break;
			default:
				System.out.println("Not a valid answer.");
				
			}
		}
	}
	
	
	private void newKey() {
		character = ' '; //ASCII space value 32
		list.clear();
		shuffledList.clear();
		
		for(int i=32; i<127; i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		
		shuffledList = new ArrayList(list); 
		Collections.shuffle(shuffledList);
		System.out.println("A encrypted sequence key has being generated! \n**Old one will not work anymore!**");
		
	}
	//get key -> transforms into ASCII them shuffle those values for this key, another key will have a different shuffle
	//the key will set the structure of this shuffle value so it can be decripted later
	private void getKey() {
		System.out.println("** This shows the encryption generated ** \n Key: \n" );
		
		//will print 1st row with arraylist list that has all the ASCII characters
		//with their associate integer values
		for(Character x : list) {
			System.out.print(x);
		}
		//shuffedlist took all of these characters from list, made a copy of them and shuffled them 
		System.out.println();
		for(Character x : shuffledList ) {
			System.out.print(x);
		}
		System.out.println();
	}
	
	//encrypt plain text
	private void encrypt() {
		newKey();
		System.out.println("Enter a message to be encrypted:");
		String message = scanner.nextLine();
		
		letters = message.toCharArray(); //this method will break the msg into a array of chars
		
		//it will be looking throw the list to search for a matching letter to the current letter that is within our array
		//if there is a match it is going to retrieve the corresponding letter at the same index in the shuffledlist
		for(int i=0;i<letters.length; i++) {
			for(int j=0;j<list.size();j++) {
				if(letters[i]==list.get(j)) {
					letters[i] = shuffledList.get(j);
					break;
				}
			}
		}
		System.out.println("Encripted: ");
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
		
	}
	
	//decrypt the msg back to plain text
	private void decrypt() {
		System.out.println("Enter a message to be decrypted: (COPY from encrypt)");
		String message = scanner.nextLine();
		
		letters = message.toCharArray(); //this method will break the msg into a array of chars
		
		//Basically the reverse from the encrypt method
		//if letters are equal to the shuffledList, assign to the array letters to the list at index j
		for(int i=0;i<letters.length; i++) {
			
			for(int j=0;j<shuffledList.size();j++) {
				if(letters[i]==shuffledList.get(j)) {
					letters[i] = list.get(j);
					break;
				}
			}
		}
		System.out.println("Decripted: ");
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
		
		
	}
	
	private void quit() {
		System.out.println("Closing the program.\nGOOD BYE!");
		System.exit(0);
	}
	
}
