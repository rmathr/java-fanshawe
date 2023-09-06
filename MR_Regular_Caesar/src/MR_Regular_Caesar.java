/**
 * Program: MR_Regular_Caesar.java
 * Purpose: This program has the purpose of encipher or decipher a message using the Caesar Shift Application.
 * Author: Matheus Rodrigues
 * Date: 06 april 2023
 */
import java.util.Scanner;
import java.io.*;

public class MR_Regular_Caesar {

	
	public static void main(String[] args)throws IOException {
		Scanner input = new Scanner(System.in);
		int userOption;
		
		System.out.println("This program will help you encipher a message or decipher a coded message.");
		System.out.println("\nIf enciphering, enter 1 and press ENTER:");
		System.out.println("If deciphering, enter 2 and press ENTER:");
		System.out.print("Enter 1 or 2: ");
		userOption = input.nextInt();
		
		
		while(userOption < 1 || userOption >2) {
			System.out.print("Please, enter 1 or 2: ");
			userOption = input.nextInt();
		}
		
		
		if(userOption == 1) {
			MR_Regular_Caesar_HelperClass.handleEncipher();
		} else if (userOption == 2) {
			MR_Regular_Caesar_HelperClass.handleDecipher();
		}
			
		input.close();
	}
	
}
