import java.util.ArrayList;
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
				
			}
		}
	}
	
	
	private void newKey() {
		
	}
	//retrieve key
	private void getKey() {
		
	}
	
	//encrypt plain text
	private void encrypt() {
		
	}
	
	//decrypt the msg back to plain text
	private void decrypt() {
		
	}
	
	private void quit() {
		
	}
	
}
