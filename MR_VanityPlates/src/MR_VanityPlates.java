/**
 * Program: MR_VanityPlates.java
 * Purpose:
 * Author: Matheus Rodrigues
 * Date: 22 de mar. de 2023
 */
import java.util.Scanner;
import java.util.Random;

public class MR_VanityPlates {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("This is Matheus Rodrigues' Vanity Plate Generator");
		System.out.print("Enter the number of vanity plates to be generated: ");
		
		int numPlates = input.nextInt();
		
		String nounArray[] = {"4X4S", "CPAS", "CTNS", "IWDS", "CTYS", "CPUS", "GPUS", "MACS", "PCS", "PP"};
		String adjectiveArray[] = {"DVS", "QT", "TNT", "FUN", "4FN", "OK", "PRFXN", "2DIE4", "HOT", "2HOT"};
		String platesArray[] = new String[numPlates];
		int random1;
		int random2;
		String nounPicked;
		String adjectivePicked;
		String plateGenerated;
		
		
		
		platesArray = generatePlates(nounArray, adjectiveArray, numPlates);
		
		int repeatCount = 0;
		String repeatedWord = platesArray[0];
		
		while(repeatCount == 0) {
			for(int i = 1; i < platesArray.length; i++) {
				if(platesArray[i].equals(repeatedWord)) {
					platesArray = generatePlates(nounArray, adjectiveArray, numPlates);
					break;
				} else {
					repeatedWord = platesArray[i];
				}
			}
			repeatCount++;
		}
		
		System.out.printf("\nYour %d randomly generated vanity plates are...\n", numPlates);
		System.out.println();
		for(int i = 0; i < numPlates; i++) {
			System.out.println(i+1 +". "+platesArray[i]);
		}
		input.close();
	}
	
	
	public static String[] generatePlates(String []array1, String[]array2, int numPlates) {
		String platesArray[] = new String[numPlates];
		Random rand = new Random();
		int random1;
		int random2;
		String nounPicked;
		String adjectivePicked;
		String plateGenerated;
		for(int i = 0; i < numPlates; i++) {
			random1 = rand.nextInt(10);
			random2 = rand.nextInt(10);
			nounPicked = array1[random1];
			adjectivePicked = array2[random2];
			plateGenerated = nounPicked + "R" + adjectivePicked;
			
			while(plateGenerated.length() > 8) {
				random1 = rand.nextInt(10);
				random2 = rand.nextInt(10);
				nounPicked = array1[random1];
				adjectivePicked = array2[random2];
				plateGenerated = nounPicked + "R" + adjectivePicked;
			}
			platesArray[i] = plateGenerated;
		}
		return platesArray;
	}
	// end main
}
