/**
 * Program: MR_Movie_Tickets.java
 * Purpose: The purpose of this program is to calculate the total admission price to a movie theater for a group of people.
 * Author: Matheus Rodrigues
 * Date: 6 mar. 2023
 */
import java.util.Scanner;


public class MR_Movie_Tickets {

	public static void main(String[] args) {
		System.out.println("Movie Theatre Admission");
		System.out.println("-----------------------\n");
		
//		1. Have your program print a short sentence explaining that it will calculate the total admission charge for a group attending a movie.
		System.out.println("This program will calculate the total admission price to a movie theatre for a group.");
		
//		2. Your program will then ask the user to enter the total number of people in the group.
		Scanner input = new Scanner(System.in);
		System.out.print("How many people are in your group? ");
		int numOfPeople = input.nextInt();
		
//		3. Now you should declare and initialize three counter variables to keep track of 
//		the number of people in each age category (children, adults, seniors).
		int numChildren = 0; 
		int numAdults = 0; 
		int numSeniors = 0;
		
//		4. Next use some kind of loop (while, do-while or for loop) to iterate the same number 
//		of times as there are people in the group (so if there are 5 people the loop should repeat 5 times).
		int counter = 1;
		char ageCategory;
		while(counter <= numOfPeople ) {
			System.out.printf("Enter age category for person %d (C for child, A for adult, S for senior): ", counter);
			ageCategory = input.next().charAt(0);
//		5. Inside the loop ask the user to input the age category for the next person, either C (for child), A (for adult) or S (for senior). 
//		Use a selection structure to determine which age range this person belongs to and increment (add 1 to) the corresponding counter.
//		ALSO, do some data validation on the user input so that if the user enters a letter other than A, C or S an error message will be displayed.
			switch(ageCategory) {
			case 'C':
				numChildren++;
				counter++;
				break;
			case 'A':
				numAdults++;
				counter++;
				break;
			case 'S':
				numSeniors++;
				counter++;
				break;
			default:
				System.out.println("Invalid age category. Please enter C for child, A for adult or S for senior.");
				break;
			}
			
		}
		
//		6. Now calculate the total price of admission for the group as follows:
//		total price = # of children x childPrice +  # of adults x adultPrice +  # of seniors x seniorPrice.
		final double childrenPrice = 6.50;
		final double adultPrice = 11.75;
		final double seniorPrice = 7.75;
		double totalPrice;
		
		totalPrice = numChildren * childrenPrice + numAdults * adultPrice + numSeniors * seniorPrice;
	
//      7. Finally, display the number of people in each age category and the total price of admission for the group.
		System.out.printf("\nYour group consists of %d child(ren), %d adult(s) and %d senior(s).", numChildren, numAdults, numSeniors);
		System.out.printf("\nThe total admission charge for your group is $%.2f", totalPrice);
		
		
//		Challenge
		double discount = 0.00;
		if(numChildren > 2) {
			discount += childrenPrice;
		} 
		if (numSeniors > 3) {
			discount += seniorPrice;
		}
		
		if (discount > 1.0) {
			System.out.printf("\nThe total basic admission charge for your group is $%.2f", totalPrice);
			double finalPrice = totalPrice - discount;
			System.out.printf("\nYou qualify for a discount of $%.2f", discount);
			System.out.printf("\nThe total discounted admission charge for your group is $%.2f", finalPrice);
		}
		
		
		input.close(); //closing scanner
	}
	// end main
}
