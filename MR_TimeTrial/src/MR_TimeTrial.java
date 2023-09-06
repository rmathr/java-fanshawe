/**
 * Program: MR_TimeTrial.java
 * Purpose:
 * Author: Matheus Rodrigues
 * Date: 19 de abr. de 2023
 */
import java.util.Scanner;
public class MR_TimeTrial {

	public static void main(String[] args) {
		System.out.println("Time-Trial Statistics Program\n");
		System.out.println("This program will ask you to input split-times for each lap or length of a race. The "
				+ "\nprogram will then calculate some basic statistics from the split-times.");
		
		System.out.print("\nEnter the number of laps or lengths in the race: ");
		
		Scanner input = new Scanner(System.in);
		int userInput;
		userInput = input.nextInt();
		
		System.out.print("\nNow input the elapsed time (split time) in seconds for each lap/length of the race.\n");
		double timesArray [] = new double[userInput];
		
		
		
		for(int i = 0; i < timesArray.length; i++) {
		    System.out.printf("Time for lap or length #%d: ", i+1);
			timesArray[i] = input.nextDouble();
			while(timesArray[i] < 0 || timesArray[i] > 60) {
				System.out.println("Invalid input! Time must be between 0 and 60.");
				System.out.printf("Time for lap or length #%d: ", i+1);
				timesArray[i] = input.nextDouble();
			}
		}
		
		System.out.println();
		System.out.printf("The fastest split time was %.2f seconds.", getFastestSplit(timesArray));
		System.out.println();
		System.out.printf("The slowest split time was %.2f seconds.", getSlowestSplit(timesArray));
		System.out.println();
		System.out.printf("The average split time was %.2f seconds.", getAverageSplit(timesArray));
		System.out.println();
		System.out.printf("Total race time was %.2f seconds.", getRaceTime(timesArray));
		
		System.out.println();
		System.out.println("Here are the split-times and deviations for each lap/length:");
		System.out.println();
		double deviationArray [] = new double[timesArray.length];
		deviationArray = getDeviationsArray(timesArray);
		for(int i = 0; i < timesArray.length; i++) {
			System.out.printf("\nLap or length #%d: %.2f seconds (%.2f)", i+1, timesArray[i], deviationArray[i]);
		}
		
		
		
	}
	
	public static double getFastestSplit(double array[]) {
		double min = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		return min;
	} 
	
	public static double getSlowestSplit(double array[]) {
		double max = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	} 
	
	public static double getAverageSplit(double array[]) {
		double average;
		double sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		average = sum/array.length;
		return average;
	}
	
	public static double getRaceTime(double array[]) {
		double sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
	
	public static double[] getDeviationsArray(double array[]) {
		double average = getAverageSplit(array);
		double deviationsArray [] = new double [array.length];
		for(int i = 0; i < array.length; i++) {
			deviationsArray[i] = array[i] - average;
		}
		return deviationsArray;
	}
	// end main
}
