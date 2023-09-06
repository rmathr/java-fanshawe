/**
 * Program: MR_SchoolFundraiser.java
 * Purpose: This program will calculate how many computers may be purchased for
a school from money raised by the school community.
 * Author: Matheus Rodrigues
 * Date: 26 de jan. de 2023
 */
import java.util.Scanner;

public class MR_SchoolFundraiser {

	public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);
	double moneyRaised;
	double computerBeforeTaxPrice;
	double computerAfterTaxPrice;
	int totalComputers;
	double totalCost;
	double leftover;
	
	final double HST_RATE = 0.13;
	
	
	
	//program description
	System.out.println("This program will calculate how many computers may be purchased for\r\na school from money raised by the school community.\r\n");
	//program description
	
	System.out.println("Enter the total amount of money raised:");
	moneyRaised = userInput.nextDouble();
	
	
	System.out.println("Enter the purchase price of each computer before tax:");
	computerBeforeTaxPrice = userInput.nextDouble();
			
	computerAfterTaxPrice = computerBeforeTaxPrice * (1 + HST_RATE);
	
	totalComputers = (int)(moneyRaised / computerAfterTaxPrice);
	
	
	totalCost = totalComputers * computerAfterTaxPrice;
	leftover = moneyRaised - totalCost;
	
	System.out.printf("With the total funds raised of $%.2f the school can buy\n", moneyRaised);
	System.out.printf("%d computers at $%.2f each (including 13%% HST) for a total of\n", totalComputers, computerAfterTaxPrice);
	System.out.printf("$%.2f. There would still be $%.2f leftover", totalCost, leftover);		
	
	userInput.close();
	}
	// end main
}
