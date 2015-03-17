package RockPaperScissors;

import java.util.Scanner;

public class Main {
	/*
	 * This is a program to play Rock Paper Scissors with the computer. First, the player is asked how many games are to be played.
	 * It asks the player to play, and then the computer chooses a random one to play. The output is then checked, and whoever won gets a point.
	 */
	
	//initialize scanner
	static Scanner in = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		//declare variables
		int numOfGamesToPlay;
		int numOfGamesPlayed;
		int playerWins = 0;
		int computerWins = 0;
		

		
		//get game settings
		System.out.print("How many games do you want to play? \nIt is suggested that you do an odd number so someone wins: ");
		numOfGamesToPlay = in.nextInt();
		
		//play
		for (numOfGamesPlayed = 0; numOfGamesPlayed < numOfGamesToPlay; numOfGamesPlayed++) {
			
			switch (playTurn()) {
			case 1:
				playerWins++;
				break;
			case 2:
				computerWins++;
				break;
			default:
				System.out.println("Oh darn, a tie.");
				break;
			}
			
			if (computerWins > playerWins) {
				System.out.println("Sorry, the computer beat you on this one.");
			} else if (playerWins > computerWins) {
				System.out.println("Good job, you beat the computer.");
			} else {
				System.out.println("It looks like you tied, try agian next time.");
			}
			
		}
		
		//wait until player hits enter to exit
		in.next();
	}

	/*
	 * This plays a turn and returns 1, 2, or 3. 1 means the player won, 2 means the computer won, and 3 means that there was a tie.
	 */
	public static int playTurn() {
		//initialize variables
		String playersPlayString;
		int playersPlay;
		int computersPlay;
		
		//get player's play
		System.out.print("Enter what you want to play: 'rock', 'paper', or 'scissors': ");
		playersPlayString = in.next();
		
		switch (playersPlayString) {
		case "rock":
			playersPlay = 1;
			break;
		case "paper":
			playersPlay = 2;
			break;
		case "scissors":
			playersPlay = 3;
			break;
		default:
			System.out.println("You are stupid. You entered the input wrong. You deserve to lose.");
			return 2;
		}
		
		if (Math.random() <= 0.33) {
			computersPlay = 1;
		} else if (Math.random() <= 0.66) {
			computersPlay = 2;
		} else {
			computersPlay = 3;
		}
		
		switch (computersPlay) {
		case 1:
			if (playersPlay == 3) {
				return 2;
			} else if (playersPlay == 2) {
				return 1;
			} else {
				return 3;
			}
		case 2:
			if (playersPlay == 1) {
				return 2;
			} else if (playersPlay == 3) {
				return 1;
			} else {
				return 3;
			}
			
		case 3:
			if (playersPlay == 2) {
				return 2;
			} else if (playersPlay == 1) {
				return 1;
			} else {
				return 3;
			}
		default:
			return 3;
		}
	}
}

