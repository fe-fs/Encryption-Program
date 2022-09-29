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

		newKey();
		askQuestion();
	}
	
	//ask the user what they want to do
	//gen new key | use current key | encrypt msg | decrypt msg | quit
	private void askQuestion() {
		while(true) {
			System.out.println("********************************************");
			System.out.println("What you want to do?");
			System.out.println("(N)ewKey,(G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit");
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
		System.out.println("A new key has being generated!");
		
	}
	//get key -> transforms into ASCII them shuffle those values for this key, another key will have a different shuffle
	//the key will set the structure of this shuffle value so it can be decripted later
	private void getKey() {
		System.out.println("Key: ");
		
		//will print 1st row with arraylist list that has all the ASCII characters
		//with their associate integer values
		for(Character x : list) {
			System.out.print(x);
		}
		//shuffedlist took all of these characters from list, made a copy of them and shuffled them 
		System.out.println();
		for(Character x : shuffledList ) {
			System.out.println(x);
		}
		System.out.println();
	}
	
	//encrypt plain text
	private void encrypt() {
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
		
	}
	
	private void quit() {
		
	}
	
}
