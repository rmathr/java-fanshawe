/**
 * Program: MR_DiceGame.java
 * Purpose:
 * Author: Matheus Rodrigues
 * Date: 19 de abr. de 2023
 */
import java.util.Random; 


public class MR_DiceGame {

	public static void main(String[] args) {
		int diceRolls [] = new int[10];
		for(int i = 0; i < diceRolls.length; i++) {
			diceRolls[i] = rollDice();
		}
		int player1 = rollDice();
		int player2 = rollDice();
		
		System.out.print("The 10 rolls of the dice: ");
		for(int i = 0; i < diceRolls.length; i++) {
			System.out.print(diceRolls[i] + " ");
		}
		System.out.println();
		System.out.println();
		System.out.printf("Player 1 rolls %d which came-up %d times.", player1, getNumberOfMatches(player1, diceRolls) );
		System.out.println();
		System.out.println();
		System.out.printf("Player 2 rolls %d which came-up %d times.", player2, getNumberOfMatches(player2, diceRolls) );		
		System.out.println();
		System.out.println();
		System.out.println(getNumberOfMatches(player1, diceRolls) > getNumberOfMatches(player2, diceRolls) ? "Player 1 wins!" : 
			getNumberOfMatches(player1, diceRolls) == getNumberOfMatches(player2, diceRolls) ? "It's a draw!" : "Player 2 wins!");
		
	}
	
	public static int rollDice() {
		int sum = 0;
		Random rand = new Random();
		int random1;
		int random2;
		random1 = rand.nextInt(1,6);
		random2 = rand.nextInt(1,6);
		sum = random1 + random2;
		return sum;
	}
	
	public static int getNumberOfMatches(int playerValue, int diceRolls[]) {
		int count = 0;
		for(int i = 0; i < diceRolls.length; i++) {
			if(playerValue == diceRolls[i]) {
				count++;
			}
		}
		return count;
		
	}
	// end main
}
