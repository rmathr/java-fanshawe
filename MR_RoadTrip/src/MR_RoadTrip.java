/**
 * Program: MR_RoadTrip.java
 * Purpose: The purpose of this program is to estimate the time required to complete a road trip.
 * Author: Matheus Rodrigues
 * Date: 19 April 2023
 */
import java.util.Scanner;

public class MR_RoadTrip {

	public static void main(String[] args) {
		//Step 1: Display a title and explanation
		System.out.println("Road Trip Time Estimator\n");
		System.out.println("This program will estimate the time required to complete a road trip.\n");
		
		
		//Step 2: Ask the user to enter the number of legs that there are in the trip and store this to a variable.
		Scanner input = new Scanner(System.in);
		int numLegs;
		System.out.print("Enter the number of 'legs' for your road trip: ");
		numLegs = input.nextInt();
		
		//Step 3: Create and define three arrays as follows:
		//One array called distancesArray to store the distances in km entered by the user km for each leg of the trip. 
		//Assume the distances can be numbers with decimal places.
		double distancesArray [] = new double[numLegs];
		
		//A second array called speedsArray to store the speed limits in km/h entered by the user for each leg of the trip. 
		//You can assume the speed limits will be integers.
		int speedsArray [] = new int[numLegs];
		
		//A third array called timesArray to store the calculated times to complete each of the legs. 
		//This array should be able to store numbers with decimal places.
		double timesArray [] = new double[numLegs];
		
		//Step 4: Use a loop that will iterate through all the legs of the trip and prompt the user to enter the distance 
		//and speed for the current leg and save these in the distancesArray and speedsArray.
		
		//You will then use the distance and speed information to calculate the expected time required to complete each 
		//leg and save this in the timesArray. You can use the formula:
		for(int i = 0; i < numLegs; i++) {
			System.out.printf("\nEnter the distance in km for leg %d: ", i+1);
			distancesArray[i] = input.nextDouble();
			System.out.printf("Enter the speed limit in km/h for leg %d: ", i+1);
			speedsArray[i] = input.nextInt();
			while(speedsArray[i] < 0 || speedsArray[i] > 110) {
				System.out.print("Invalid speed. Please enter a number between 0 and 110.");
				System.out.printf("\nEnter the speed limit in km/h for leg %d: ", i+1);
				speedsArray[i] = input.nextInt();
			}
			timesArray[i] = distancesArray[i] / speedsArray[i];
		}
		
		//Step 5: Use another loop that will iterate through all the legs of the trip again, this time to report the following details:
		for(int i = 0; i < numLegs; i++) {
			System.out.printf("\nLeg %d: %.1f km at %d km/h will take %s", i+1, distancesArray[i], speedsArray[i], formatTime(timesArray[i]));
		}
		
		//Step 6: After the above loop, call another class method called getArrayTotal() that you will also write elsewhere in your class and which 
		//will add-up all the numbers in an array and return the total. The method should accept an array of the same type used for your 
		//distancesArray and timesArray. Your main method should call the getArrayTotal() method twice: first to calculate the total trip 
		//distance from the distancesArray and a second time to calculate the total trip time from the timesArray. 
		//The values returned should be stored in a pair of new variables called totalDistance and totalTime.
		double totalDistance = getArrayTotal(distancesArray);
		double totalTime = getArrayTotal(timesArray);
		
		//Step 7: Finally, report the total trip distance and the total time for the trip formatted in hours and minutes. Once again you can obtain the 
		//formatted total trip time by first summing all the times and then calling the formatTime() method from Step 5.
		System.out.printf("\n\nThe entire journey of %.1f km will take %s.", totalDistance, formatTime(totalTime));
		
		input.close(); //close scanner
	}
	/**
	Method Name: formatTime
	Purpose: format a given time in hours to a string of hours + minutes
	Accepts: double
	Returns: string
	Date: 19 april 2023
	*/
	public static String formatTime(double totalHours) {
		int numHours = (int) totalHours;
		int numMinutes = (int) ((totalHours - numHours) * 60);
		String result = "" + numHours + " hours and " + numMinutes + " minutes";
		return result;
	}
	/**
	Method Name: getArrayTotal
	Purpose: returns the sum of all elements of a given array
	Accepts: double array
	Returns: double
	Date: 19 april 2023
	*/
	public static double getArrayTotal(double array[]) {
		double sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
	// end main
}
