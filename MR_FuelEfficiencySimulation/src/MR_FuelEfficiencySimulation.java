/**
 * Program: MR_FuelEfficiencySimulation.java
 * Purpose:
 * Author: Matheus Rodrigues
 * Date: 19 de abr. de 2023
 */
import java.util.Scanner; 
import java.util.Random;
public class MR_FuelEfficiencySimulation {

	public static void main(String[] args) {
		System.out.println("Fuel Efficiency Simulation");
		System.out.println("\nThis program will generate a simulated group of commuters assigning them "
				+ "\nrandom daily commutes. It will then calculate the fuel used daily and the "
				+ "\ncombined fuel efficiency achieved by the new extended range electric car. ");
		
		int comuters;
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter the number of commuters: ");
		comuters = input.nextInt();
		
		int distanceArray [] = new int[comuters];
		
		getRandomDistances(distanceArray);
		
		
		double fuelUsedArray [] = new double[comuters];
		double fuelEfficiencyArray [] = new double[comuters];
		
		
		
		for(int i = 0; i < fuelUsedArray.length; i++) {
			if(distanceArray[i] <= 55) {
				fuelUsedArray[i] = 0;
				fuelEfficiencyArray[i] = 0;
			} else {
				fuelUsedArray[i] = calculateFuelUsed(distanceArray[i]-55);
				fuelEfficiencyArray[i] = calculateEfficienty(fuelUsedArray[i], distanceArray[i]);
			}
		}
		
		
		
		reportDetails(distanceArray, fuelUsedArray, fuelEfficiencyArray);
		
		System.out.printf("\n\nThe average fuel used is %.2f L and the average efficiency achieved is %.2f L/100 km.", calculateAverage(fuelUsedArray), calculateAverage(fuelEfficiencyArray));
	}
	
	public static void getRandomDistances(int array[]) {
		Random rand = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10,150);
		}
	}
	
	
	public static double calculateFuelUsed(double distGasoline) {
		double fuelUsed;
		fuelUsed = distGasoline * 6.2 / 100;
		return fuelUsed;
	}
	
	public static double calculateEfficienty(double fuelUsed, int distance) {
		double efficiency;
		efficiency = fuelUsed * 100 / distance;
		return efficiency;
	}
	
	public static void reportDetails(int distance[], double fuel[], double efficiency[]) {
		System.out.println("\nHere are the group’s distance, fuel usage and fuel efficiency details...\n");
		for(int i = 0; i < distance.length; i++) {
			System.out.printf("\nCommuter %d:\t %d km, \t%.2f L, \t%.2f L/100 km", i+1, distance[i], fuel[i], efficiency[i]);
		}
	}
	
	public static double calculateAverage(double array[]) {
		double average;
		double sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		average = sum/array.length;
		return average;
	}
	// end main
}
