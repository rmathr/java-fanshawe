/**
 * Program: MR_StreetNames.java
 * Purpose:
 * Author: Matheus Rodrigues
 * Date: 19 de abr. de 2023
 */

public class MR_StreetNames {

	public static void main(String[] args) {
		String streetsArray[] = {"Oxford", "Dundas", "Cheapside", "Highbury", "Clarke", "Richmond"};
		int trafficLights [] = {21, 23, 7, 10, 5, 19};
		
		for(int i = 0; i < streetsArray.length; i ++) {
			System.out.print(streetsArray[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < trafficLights.length; i ++) {
			System.out.print(trafficLights[i] + " ");
		}
		sortArrayAlpabhetically(streetsArray, trafficLights);
		System.out.println();
		for(int i = 0; i < streetsArray.length; i ++) {
			System.out.print(streetsArray[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < trafficLights.length; i ++) {
			System.out.print(trafficLights[i] + " ");
		}
		sortArrayNumerically(streetsArray, trafficLights);
		System.out.println();
		for(int i = 0; i < streetsArray.length; i ++) {
			System.out.print(streetsArray[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < trafficLights.length; i ++) {
			System.out.print(trafficLights[i] + " ");
		}

	}
	public static void sortArrayAlpabhetically(String streets [], int trafficLights []) {
		String sortedStreets [];
		int sortedTrafficLights [];
		
		for (int i = 0; i < streets.length; i++) {
	        for (int j = i + 1; j < streets.length; j++) {
	            String tmp1 = "";
	            int temp2 = 0;
	            if (streets[i].compareTo(streets[j]) > 0 ) {
	                tmp1 = streets[i];
	                temp2 = trafficLights[i];
	                streets[i] = streets[j];
	                trafficLights[i] = trafficLights[j];
	                streets[j] = tmp1;
	                trafficLights[j] = temp2;
	            }
	        }
	    }
		
	}
	
	public static void sortArrayNumerically(String streets [], int trafficLights []) {
		for (int i = 0; i < trafficLights.length; i++) {
	        for (int j = i + 1; j < trafficLights.length; j++) {
	            String tmp1 = "";
	            int temp2 = 0;
	            if (trafficLights[i] < trafficLights[j] ) {
	                tmp1 = streets[i];
	                temp2 = trafficLights[i];
	                streets[i] = streets[j];
	                trafficLights[i] = trafficLights[j];
	                streets[j] = tmp1;
	                trafficLights[j] = temp2;
	            }
	        }
	    }
		
	}
	
	
	// end main
}
