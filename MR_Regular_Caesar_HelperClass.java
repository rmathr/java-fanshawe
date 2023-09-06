import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Program: MR_Regular_Caesar_HelperClass.java
 * Purpose: Define all methods used in the main class.
 * Author: Matheus Rodrigues
 * Date: 06 april 2023
 */

public class MR_Regular_Caesar_HelperClass {
	
	
	/**
	Method Name: handleEncipher
	Purpose: Execute the encipher logic
	Accepts: no arguments
	Returns: void type
	Date: 06 april 2023
	*/
	
	public static void handleEncipher()throws IOException {
		Scanner input = new Scanner(System.in);
		String userKey; 
		String userMessage;
		String validatedString; 
		String encipherMessage;
		String userFile;
		System.out.print("\nEnter the plaintext message you wish to encipher: ");
		userMessage = input.nextLine().toUpperCase();
		System.out.print("Enter a keyword of only letters, with no digits, spaces, or punctuation marks: ");
		userKey = input.nextLine().toUpperCase();
		validatedString = userKeyValidation(userKey);
		String upperUserKey = validatedString.toUpperCase();
		int shiftValue;
		shiftValue = defineShiftValue(upperUserKey);
		encipherMessage = encipherText(userMessage, shiftValue);
		
		System.out.println("");
		System.out.println("The plaintext and enciphered text are as follows:");
		System.out.println(userMessage);
		System.out.println(encipherMessage);
		
		System.out.print("\nEnciphered text will now be written to a text file.");
		System.out.print("Enter a file name followed by the extension '.txt' (example: secret.txt): ");
		userFile = input.nextLine();
		saveToFile(encipherMessage, userFile);
		System.out.print("Ciphertext has been written to local directory as secret.txt");
	}
	
	/**
	Method Name: handleDecipher
	Purpose: Execute the decipher logic
	Accepts: no arguments
	Returns: void type
	Date: 06 april 2023
	*/
	public static void handleDecipher()throws IOException{
		Scanner input = new Scanner(System.in);
		int userOption;
		String userKey; 
		String userMessage;
		String validatedString; 
		String decipheredMessage;
		String userFile;
		System.out.print("We will be deciphering a message.");
		System.out.println("");
		System.out.println("\nIf ciphertext will be entered via keyboard, enter 1.");
		System.out.println("If ciphertext will be entered from a file, enter 2.");
		System.out.print("Enter 1 or 2: ");
		userOption = input.nextInt();
		input.nextLine();
		if(userOption == 1) {
			System.out.print("Enter the ciphertext message you wish to decipher: ");
			userMessage = input.nextLine().toUpperCase();
			System.out.print("Enter a keyword of only letters, with no digits, spaces, or punctuation marks: ");
			userKey = input.nextLine().toUpperCase();
			validatedString = userKeyValidation(userKey);
			String upperUserKey = validatedString.toUpperCase();
			int shiftValue;
			shiftValue = defineShiftValue(upperUserKey);
			
			decipheredMessage = decipherText(userMessage, shiftValue);
			
			System.out.println("");
			System.out.println("The ciphertext and deciphered plaintext are as follows:");
			System.out.println(userMessage);
			System.out.println(decipheredMessage);
		} else if(userOption ==2) {
			System.out.print("Enter the name of the file containing the ciphertext: ");
			userFile = input.nextLine();
			userMessage = readFromFile(userFile);
			System.out.print("Enter a keyword of only letters, with no digits, spaces, or punctuation marks: ");
			userKey = input.nextLine().toUpperCase();
			validatedString = userKeyValidation(userKey);
			String upperUserKey = validatedString.toUpperCase();
			int shiftValue;
			shiftValue = defineShiftValue(upperUserKey);
			
			decipheredMessage = decipherText(userMessage, shiftValue);
			
			System.out.println("");
			System.out.println("The ciphertext and deciphered plaintext are as follows:");
			System.out.println(userMessage);
			System.out.println(decipheredMessage);
		}
	}

	/**
	Method Name: saveToFile
	Purpose: Execute the save to file logic
	Accepts: no arguments
	Returns: void type
	Date: 06 april 2023
	*/
	public static void saveToFile(String encipheredMessage, String userFileName)throws IOException {
		
		FileWriter writer = new FileWriter(userFileName);
		writer.write(encipheredMessage);
		writer.close();
	}
	
	/**
	Method Name: readFromFile
	Purpose: Execute the reading from file logic
	Accepts: no arguments
	Returns: void type
	Date: 06 april 2023
	*/
	public static String readFromFile(String fileName)throws IOException {
		File myFile = new File(fileName);
		Scanner input = new Scanner(myFile);
		String encipheredMessage = input.nextLine();
		return encipheredMessage;	
	}
	
	/**
	Method Name: defineShiftValue
	Purpose: calculates the shift value which will be used to encipher or decipher the message
	Accepts: string
	Returns: int
	Date: 06 april 2023
	*/
	public static int defineShiftValue (String key) {
		int sum = 0;
		for(int i = 0; i < key.length(); i++) {
			sum += (int) key.charAt(i);
		}
		if(sum % 26 == 0) {
			return 1;
		}
		return sum % 26;
	}
	
	/**
	Method Name: userKeyValidation
	Purpose: validate the key used to enchipher or decipher the message. Ensures the key contain only letters.
	Accepts: string
	Returns: string
	Date: 06 april 2023
	*/
	public static String userKeyValidation(String userKey) {
		Scanner input = new Scanner(System.in);
			for(int i = 0; i < userKey.length(); i++) {
				if(!(Character.isLetter(userKey.charAt(i)))) {
					System.out.print("Enter a work without symbols or spaces: ");
					userKey = input.nextLine().toUpperCase();
					return userKeyValidation(userKey);
				}
		}
		return userKey;
	}
	
	/**
	Method Name: encipherText
	Purpose: enchipher the message using the user message and the shiftvalue.
	Accepts: string and int values
	Returns: string
	Date: 06 april 2023
	*/
	public static String encipherText (String userMessage, int shiftValue) {
		String encipheredMessage ="";
		int asciiValue;
		for(int i = 0; i < userMessage.length(); i++) {
			if(!(Character.isLetter(userMessage.charAt(i)))){
				asciiValue = (int) userMessage.charAt(i);
			} else {
				asciiValue = ((int) userMessage.charAt(i)) + shiftValue;
				if(asciiValue > 90) {
					asciiValue = asciiValue - 26;
				}
			}
			encipheredMessage += (char) asciiValue;
		}
		return encipheredMessage;
	}
	
	/**
	Method Name: decipherText
	Purpose: dechipher the message using the enciphered message and the shiftvalue.
	Accepts: string and int values
	Returns: string
	Date: 06 april 2023
	*/
	public static String decipherText(String enchiperedMessage, int shiftValue) {
		String decipheredMessage = "";
		int asciiValue;
		for(int i = 0; i < enchiperedMessage.length(); i++) {
			if(!(Character.isLetter(enchiperedMessage.charAt(i)))){
				asciiValue = (int) enchiperedMessage.charAt(i);
			} else {
				asciiValue = ((int) enchiperedMessage.charAt(i)) - shiftValue;
				if(asciiValue < 65) {
					asciiValue = asciiValue + 26;
				}
			}
			decipheredMessage += (char) asciiValue;
		}
		return decipheredMessage;
	}
}
