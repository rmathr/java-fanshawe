/**
 * Program: MR_CarWash.java
 * Purpose: The purpose of this program is to calculate the number of car washes earned based on your gas purchases.
 * Author: Matheus Rodrigues
 * Date: 27 jan. 2023
 */
import java.util.Scanner;

public class MR_CarWash {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		//1. Prints an explanation of the purpose of the program.
		System.out.println("Calculating the number of car washes earned based on your gas purchases...\n");
		/*
		2. Asks the user to enter the number of liters of regular gasoline purchased as well as the number of litres of premium gasoline purchased. 
		Each of these two values should be assigned to a variable of an appropriate type given that it will be used in calculations. 
		Since no credit is given for part of a liter you can assume that no decimal places will be required.
		*/
		System.out.println("Enter the litres of regular gas purchased:");
		int regularGasL;
		regularGasL = userInput.nextInt();
		
		System.out.println("Enter the litres of premium gas purchased:");
		int premiumGasL;
		premiumGasL = userInput.nextInt();
		//3. Asks the user a price for a regular car wash and a second price for a deluxe car wash.
		System.out.println("Enter the price of a regular car wash:");
		double regularCarWashPrice;
		regularCarWashPrice = userInput.nextDouble();
		
		System.out.println("Enter the price of a deluxe car wash:");
		double deluxeCarWashPrice;
		deluxeCarWashPrice = userInput.nextDouble();
		
		userInput.nextLine(); //flush scan.
		
		//4. Asks the user to enter the model of the customer's vehicle (e.g. "2012 Toyota RAV4") and assigns this to an appropriate variable.
		System.out.println("Enter the model of your vehicle:");
		String vehicleModel;
		vehicleModel = userInput.nextLine();
		/*
		5. Declares a pair of constants of a suitable type called CREDIT_FOR_REGULAR which is assigned the value 0.05 and CREDIT_FOR_PREMIUM which is assigned the value 0.06. 
		This is the credit in dollars awarded to the customer for each litre of fuel purchased.     
		 */
		final double CREDIT_FOR_REGULAR = 0.05;
		final double CREDIT_FOR_PREMIUM = 0.06;
		/*
		 6. Declares a suitable variable to store the total credit earned towards car washes and assigns it a value calculated using the following formula: 
	
		 total credit = regular_litres X CREDIT_FOR_REGULAR + premium_litres X CREDIT_FOR_PREMIUM
		 */
		double totalCredit;
		totalCredit = regularGasL * CREDIT_FOR_REGULAR + premiumGasL * CREDIT_FOR_PREMIUM;
		/*
		 7. ("Hot" Requirements)
		 Modify your program so that the user can enter a price for a regular car wash and a second price for a deluxe car wash. 
		 Calculate the number of regular and deluxe washes assuming that the credit will pay for as many deluxe washes as possible 
		 and then for regular washes with what's left. 
		 */
		int regularCarWashesEarned;
		int deluxeCarWashesEarned;
		deluxeCarWashesEarned = (int)(totalCredit / deluxeCarWashPrice);
		regularCarWashesEarned = (int)(totalCredit % deluxeCarWashPrice / regularCarWashPrice);
		/*
		 8. Declares yet another suitable variable to store the extra credit earned in excess of the complete car washes earned and assigns 
		 to it this calculated amount. For example, if a customer has earned a total credit of $23.05 and 
		 a car wash is $10.99 then 2 washes have been earned and there will be $23.05 – 2 x $10.99 = $1.07 of credit remaining (leftover). 
		 */
		double leftover;
		leftover = totalCredit - (regularCarWashesEarned * regularCarWashPrice + deluxeCarWashesEarned * deluxeCarWashPrice);
		/*
		 9. Outputs the total credit, the number of washes, the extra credit and the vehicle model using the format shown in the sample output below. 
		 For the extra credit earned, TRUNCATE ANY DECIMALS BEYOND TWO PLACES so that it reads as a proper dollar and cents amount. 
		 */
		System.out.printf("Your total credit earned is $%.2f.", totalCredit);
		System.out.printf("\nYou've earned %d deluxe car wash(es) for your %s.", deluxeCarWashesEarned, vehicleModel);
		System.out.printf("\nYou've also earned %d regular car wash(es).", regularCarWashesEarned);
		System.out.printf("\nThe extra credit earned is $%.2f.", leftover);
		
		userInput.close(); //close input
	}
	// end main
}
