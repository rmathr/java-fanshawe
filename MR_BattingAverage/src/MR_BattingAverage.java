/**
 * Program: MR_BattingAverage.java
 * Purpose: The purpose of this program is to update a player's batting average based on the outcome of their latest trip to the plate.
 * Author: Matheus Rodrigues
 * Date: 10 feb. 2023
 */
import java.util.Scanner;

public class MR_BattingAverage {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//scanner init
		
		/*
		1) Prints a title that reads: "[your name here]'s Batting Average Calculator" and it 
		 should include a description of what the program does (See sample output below)
		*/
		System.out.println("Matheus' Batting Average Calculator\n");
		System.out.println("This program will update a player's batting average based on the outcome\r\n"
				+ "of their latest trip to the plate.\n");
		
		/*
		 2) Prompt the user to enter each of the following FOUR inputs and assign each 
		 to a variable of an appropriate type (note that you are not required to validate the user's inputs):
		 */
		System.out.print("Enter the player's previous batting average (between 0 and 1): ");
		double previousBattingAverage = input.nextDouble();
		
		System.out.print("Enter the number of 'at bats' this average is based on (0 or more): ");
		int atBatsNumber = input.nextInt();
		
		input.nextLine(); //buffer flush
		
		System.out.print("Enter the player's name: ");
		String playerName = input.nextLine();
		
		System.out.printf("What did %s do this time up ('H' = hit, 'W' = walk, 'O' = out)? ", playerName);
		char playerOutcome = input.next().charAt(0);
		
		/*
		 3) Calculate the number of hits this player already has this season. 
		 This can be done by multiplying the player's previous batting average 
		 by the number of times the player has been at bat. The result should be rounded to an integer. 
		 For example, if the player's batting average was 0.264 and they had 68 times at bat, 
		 then the number of hits is 0.264 x 68 = 17.952, which rounds to 18. 
		 */
		int numberOfHits;
		numberOfHits = (int) Math.round(previousBattingAverage * atBatsNumber);
	
		/*
		 4)Next use some logic to determine whether the player's latest time batting resulted in either a hit, an out or a walk. 
		 Use this logic to assign values to three new variables for: the updated number of at bats, the updated number of hits 
		 and also a descriptor that will be used later in the output. 
		 */
		String descriptor = "";
		
		switch(playerOutcome) {
		case 'H':
			numberOfHits++;
			atBatsNumber++;
			descriptor = "has improved to";
			break;
		case 'O':
			atBatsNumber++;
			descriptor = "has dropped to";
			break;
		case 'W':
			descriptor = "is unchanged at";
			break;
		}
		
		/*
		 5)Calculate the player's new batting average as the updated number of hits divided by the updated number of at bats. 
		 Type casting should be used to round this to three decimal places. For example, if the player got a hit and the number of hits is now 19 
		 and the number of at bats is now 69, then the new batting average is 19 / 69 = 0.275362 which rounds to 0.275. 
		 */
		double newBattingAverage = Math.round((double)numberOfHits/atBatsNumber*1000)/1000.0;
	
		/*
		 6) Finally, report all the following information: the player's name, the descriptor, the updated batting average, 
		 the updated number of hits and the updated number of at bats. The output should be formatted like this: 
		 [name]'s batting average [descriptor]  [updated batting average] with [updated hits] in [updated at bats] at bats. 
		 The batting average should always be displayed with three decimal places.
		 */
		System.out.printf("\n%s batting average %s %.3f with %d hits in %d at bats.\n", playerName, descriptor, newBattingAverage, numberOfHits, atBatsNumber);
		
		
		
		input.close(); //input close
	}
	// end main
}
