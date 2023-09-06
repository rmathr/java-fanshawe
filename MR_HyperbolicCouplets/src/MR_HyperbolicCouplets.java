import java.util.Random;
import java.util.Scanner;

/**
 * Program: MR_HyperbolicCouplets.java
 * Purpose: The purpose of this program is to randomly generate combinations of an adverb and 
 * an adjective that will be presented as possible hyperbolic couplets for a new advertising campaign.
 * Author: Matheus Rodrigues
 * Date: 24 mar. 2023
 */
import java.util.Scanner;

public class MR_HyperbolicCouplets {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//1) Print a line that states "This is your_name_here's Hyperbole Couplets program".
		System.out.println("This is Matheus Rodrigues' Hyperbole Couplets program!");
		
		
		/*2) First create your two String arrays using the shortcut, or direct instantiation method. 
		 One array will hold the adverbs and the other array will hold the adjectives. 
		 Give each array an appropriate name and make sure each one has the specified number of values...*/
		String adverbsArray[] = {"bewitchingly", "brilliantly", "charmingly", "dazzlingly", "cheerfully", "devilishly",  "flashily", "glowingly", "flamboyantly", "gleamingly"};
		String adjectivesArray[] = {"cuddly", "cute", "delectable", "delightful", "divine", "enjoyable", "enticing", "exquisite", "favorable", "good", "gratifying", "imaginative"};
	
		/*3)Ask the user how many couplets they would like to see. User should enter a number from 1 to 30 inclusive for this
		 * , so do some data validation here.Use their input to create and size a  third String array called coupletsArray. 
		 * This array will hold the set of complete hyperbolic couplets, which will consist of one of the randomly chosen 
		 * adverbs and one of the randomly chosen adjectives that have been concatenated together. */
		System.out.print("How many couplets would you like to see? ");
		int numCouplets; 
		numCouplets = input.nextInt();
		while(numCouplets < 1 || numCouplets > 30) {
			System.out.println("Invalid input. The number of couplets must be between 1 and 30.");
			System.out.print("How many couplets would you like to see? ");
			numCouplets = input.nextInt();
		}
		String coupletsArray[] = new String[numCouplets];
		
		/*4) Set up a loop to completely fill the coupletsArray with your random couplets. */
		coupletsArray = generateCouplets(adverbsArray, adjectivesArray, numCouplets);
		
		
		
		/*5) After the coupletsArray has been filled print a heading (as shown below) 
		 * and set up a second for loop to print out the contents of this array to the screen as a numbered list.  
		 * (Or, use the same loop as above if you prefer…)*/
		
		System.out.printf("\nYour %d randomly generated hyperbolic couplets candidates are:\n", numCouplets);
		System.out.println();
		for(int i = 0; i < numCouplets; i++) {
			System.out.println(i+1 +". "+coupletsArray[i]);
		}
		
		
		/*The code above is just to make sure that there is not repeated values on the generated array.*/
		int repeatCount = 0;
		String repeatedCouplet = coupletsArray[0];
		
		while(repeatCount == 0) {
			for(int i = 1; i < coupletsArray.length; i++) {
				if(coupletsArray[i].equals(repeatedCouplet)) {
					coupletsArray = generateCouplets(adverbsArray, adjectivesArray, numCouplets);
					break;
				} else {
					repeatedCouplet = coupletsArray[i];
				}
			}
			repeatCount++;
		}
		
		
	
		input.close(); //close scanner
	}
	
	/*4) Set up a loop to completely fill the coupletsArray with your random couplets. */
	
	/*
	Method Name: generateCouplets
	Purpose: Generate a random combination of two array of strings
	Accepts: two string arrays and one int number
	Returns: string array
	Date: 24 mar.2023
	*/
	
	public static String[] generateCouplets(String adverb[], String adjective[], int numCouplets) {
		String generatedArray[] = new String[numCouplets];
		Random rand = new Random();
		int random1;
		int random2;
		String adverbPicked;
		String adjectivePicked;
		String coupletGenerated;
		for(int i = 0; i < numCouplets; i++) {
			random1 = rand.nextInt(10);
			random2 = rand.nextInt(12);
			adverbPicked = adverb[random1];
			adjectivePicked = adjective[random2];
			coupletGenerated = adverbPicked + " " + adjectivePicked;
			generatedArray[i] = coupletGenerated;
		}
		return generatedArray;
	}
	// end main
}
