package com.bayviewglen.horseracingassignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.text.NumberFormatter;

import org.omg.CORBA.Current;

public class HorseRacingAssignment {
/*
 *Adrienne Klein
 * ISC3U
 * HorseRacing Assignment
 * February 12, 2015
 */
	private static final int FILL_ARRAY = -1, ONE = 1, TWO = 2,
			FOUR = 4, FIVE = 5, TEN = 10, RACE_LENGTH = 100;

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		boolean playAgain = true;
		while(playAgain){
		Scanner horses = new Scanner(new File("Input/horses"));
		Scanner players = new Scanner(new File("Input/players"));
		Scanner keyboard = new Scanner(System.in);
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.CANADA);
		
		String valueOfHorses = horses.nextLine();
		int numberOfHorses = Integer.parseInt(valueOfHorses);
		String[] allHorses = new String[numberOfHorses];
		int readHorses = 0;
		while (horses.hasNext()) {
			allHorses[readHorses] = horses.nextLine();
			readHorses++;
		}

		String valueOfPlayers = players.nextLine();
		int numberOfPlayers = Integer.parseInt(valueOfPlayers);
		String[] playersAndWallets = new String[numberOfPlayers];
		int readPlayers = 0;
		while (players.hasNext()) {
			playersAndWallets[readPlayers] = players.nextLine();
			readPlayers++;
		}
		// Displaying the horses in the race to the console.
		int[] horseNumbers = getHorseNumbers(numberOfHorses);
		String[] horsesInRace = horsesInRace(horseNumbers, allHorses);
		int raceHorses = horsesInRace.length;
		System.out.println("These are the horses in the current race: ");
		for (int y = 0; y < raceHorses; y++) {
			String horse = horsesInRace[y];
			int horseNumber = y + ONE;
			System.out.println(horseNumber + ". " + horse);
		}
		// Displaying the list of players and the money they have to the console.
		String[] betters = players(playersAndWallets, numberOfPlayers);
		double[] wallets = wallets(playersAndWallets, numberOfPlayers);
		System.out.println("This is a list of the players, and the money in their wallet: ");
		
		for (int i = 0; i < numberOfPlayers; i++) {
			String player = betters[i];
			int playerNumber = i + ONE;
			double walletsMoney = wallets[i];
			String walletFormat = formatter.format(walletsMoney);
			System.out.println(playerNumber + ". " + player + ", " + walletFormat);
		}
		// Asking the user whether they would like a player to bet on this race.
		int times = 1;
		boolean validInput = false;
		int willBet = 0;
		String betting = "";
		double[] bets = new double[numberOfPlayers];
		int[] playerOnHorse = new int[numberOfPlayers];
		for (int t = 0; t < playerOnHorse.length; t++) {
			playerOnHorse[t] = FILL_ARRAY;
		}
		int keepGoing = 0;
		while (!validInput && keepGoing <= numberOfPlayers) {
			while (!validInput && keepGoing < numberOfPlayers) {
				if (times == ONE) {
					System.out.print("Would a player like to bet on this race?(1. yes 2. no): ");
					betting = keyboard.nextLine();
				} else if (times > ONE) {
					System.out.print("Would another player like to bet on this race?(1. yes 2. no): ");
					betting = keyboard.nextLine();
				}
				try {
					willBet = Integer.parseInt(betting);
					validInput = true;
				} catch (NumberFormatException ex) {
					validInput = false;
				}
				if (willBet < ONE || willBet > TWO) {
					validInput = false;
				}
				if (!validInput) {
					System.out.println("That is not a valid input!");
				}
			}
			// If the user chooses to bet, asking the user which player it would like to place a bet for.
			boolean validPlayer = false;
			int player = 0;
			while (!validPlayer && willBet == ONE && keepGoing < numberOfPlayers) {
				System.out.print("Which player would you like to place a bet for? ");
				String playerValue = keyboard.nextLine();
				try {
					player = Integer.parseInt(playerValue);
					validPlayer = true;
				} catch (NumberFormatException ex) {
					validPlayer = false;
				}
				if (player > betters.length || player < ONE || playerOnHorse[player - ONE] != FILL_ARRAY || wallets[player - ONE] == 0) {
					validPlayer = false;
				}
				if (!validPlayer) {
					System.out.println("That is not a valid input!");
				}
				else if (validInput){
					keepGoing++;
				}
				
				player -= ONE;
			}
			// Once the user has chosen a player to bet on, asks the user which horse they would like that player to bet on.
			boolean validHorse = false;
			int horse = 0;
			while (!validHorse && willBet == ONE && keepGoing <= numberOfPlayers) {
				System.out.print("Which horse would you like to place a bet for? ");
				String horseValue = keyboard.nextLine();
				try {
					horse = Integer.parseInt(horseValue);
					validHorse = true;
				} catch (NumberFormatException ex) {
					validHorse = false;
				}
				if (horse > horsesInRace.length || horse < ONE) {
					validHorse = false;
				}
				if (!validHorse) {
					System.out.println("That is not a valid input!");
				}
				horse -= ONE;
				playerOnHorse = playerOnHorse(playerOnHorse, player, horse);
			}
			// Asks the user how much they would like that player to bet.
			boolean validBet = false;
			int bet = 0;
			String betValue = "";
			while (!validBet && willBet == ONE && keepGoing <= numberOfPlayers) {
				System.out.print("How much would you like to bet? ");
				betValue = keyboard.nextLine();
				try {
					bet = Integer.parseInt(betValue);
					validBet = true;
				} catch (NumberFormatException ex) {
					validBet = false;
				}
				validBet = validBet(wallets, bet, player, validBet);
				if (!validBet) {
					System.out.println("That is not a valid input!");
				} else if (validBet) {
					bets = bet(wallets, bets, bet, player);
				}
				validInput = false;
			}
			times++;
			if (keepGoing == FIVE){
			keepGoing++;
		}
		}
		// Displays the horses running on the track.
		int[] horseRace = new int[raceHorses];
		int position = 1;
		boolean race = false;
		while (!race) {
			for (int y = 0; y < raceHorses; y++) {
				int running = horseRace[y]+1;
				System.out.println("____________________________________________________________________________________________________");
				System.out.printf("%"+running+"d\n", y + 1);
				if (position >= RACE_LENGTH) {
					race = true;
				}
			}
			Thread.sleep(500);
			for (int j = 0; j < 6; j ++){
				System.out.println("");
			}
			int check = 0;
			race = true;
			while (position < RACE_LENGTH && race) {
				horseRace = racing(horseRace);
				race = false;
			}
			while (position < RACE_LENGTH && check < raceHorses) {
				position = horseRace[check];
				check++;
			}
		}
		// Finding which horse won the race and which horse came in second, then prints them to the console.
		int horseWinner = raceWinner(horseRace);
		int secondPlaceHorse = secondPlaceHorse(horseRace, horseWinner);

		System.out.println(horsesInRace[horseWinner] + " won!");
		System.out.println(horsesInRace[secondPlaceHorse] + " came in second!");
		// Finding which player won based on the horse that won.
		int[] playerWinner = playerWinners(playerOnHorse, horseWinner);
		for (int x = 0; x < playerWinner.length; x++) {
			System.out.println("The horse that " + betters[playerWinner[x]] + " bet on won!");
		}
		// Finding which player came in second based on the horse that came in second.
		int[] playerSecond = playerWinners(playerOnHorse, secondPlaceHorse);
		for (int z = 0; z < playerSecond.length; z++) {
			System.out.println("The horse that " + betters[playerSecond[z]] + " bet on came in second!");
		}
		// Updates the players wallet based on the outcome of the race.
		wallets = updateWinnerWallet(wallets, playerWinner, bets);
		wallets = updateSecondPlaceWallet(wallets, playerSecond, bets);
		PrintWriter writer = new PrintWriter(new File("Input/players"));
		//Updates the player file with the new player wallet values.
		writer.write(wallets.length + "\n");
		for (int w = 0; w < wallets.length; w++){
			writer.write(betters[w] + " "+ wallets[w] + "\n");
		}
		writer.close();
		// Asks the player if they would like to play again.
		boolean verifyPlayAgain = false;
		while (!verifyPlayAgain){
		System.out.print("Would you like to play again?(1. yes 2. no): ");
		String keepPlayingValue = keyboard.nextLine();
		int keepPlaying = 0;
		try {
			keepPlaying = Integer.parseInt(keepPlayingValue);
			verifyPlayAgain = true;
		} catch (NumberFormatException ex) {
			verifyPlayAgain = false;
		}
		if (keepPlaying > TWO || keepPlaying < ONE){
			verifyPlayAgain = false;
		}
		if (!verifyPlayAgain){
		System.out.println("That is not a valid input!");
		}
		if (keepPlaying == TWO){
			playAgain = false;
		}
		}
	}
	}
	// Get 5-8 numbers that correspond to random horses from the horse file.
	private static int[] getHorseNumbers(int numberOfHorses) {
		int amount = (int) (Math.random() * FOUR) + FIVE;
		int[] horseNumbers = new int[amount];
		for (int x = 0; x < amount; x++) {
			int randomHorses = (int) (Math.random() * numberOfHorses) + ONE;
			horseNumbers[x] = randomHorses;
		}
		int y = 0;
		while (y < amount) {
			for (int i = y + ONE; i < amount; i++) {
				if (horseNumbers[y] == horseNumbers[i]) {
					int randomHorsesFix = (int) (Math.random() * numberOfHorses)
							+ ONE;
					horseNumbers[y] = randomHorsesFix;
					y = 0;
				}
			}
			y++;
		}
		return horseNumbers;
	}
	// Get the horses from the horse file based on the random numbers generated in the getHorseNumbers method.
	private static String[] horsesInRace(int[] numberOfHorses, String[] allHorses) {
		String[] horsesInRace = new String[numberOfHorses.length];
		for (int x = 0; x < horsesInRace.length; x++) {
			horsesInRace[x] = allHorses[numberOfHorses[x]];
		}
		return horsesInRace;
	}
	// Creates a string array of all of the players.
	private static String[] players(String[] playersAndWallets, int numberOfPlayers) {
		String[] players = new String[numberOfPlayers];
		int y = 0;
		for (int x = 0; x < numberOfPlayers; x++) {
			y = playersAndWallets[x].indexOf(' ');
			players[x] = playersAndWallets[x].substring(0, y);
		}
		return players;
	}
	// Creates a double array of all the player's wallets.
	private static double[] wallets(String[] playersAndWallets, int numberOfPlayers) {
		String[] walletsValue = new String[numberOfPlayers];
		double[] wallets = new double[numberOfPlayers];
		int y = 0;
		for (int x = 0; x < numberOfPlayers; x++) {
			y = playersAndWallets[x].indexOf(' ');
			walletsValue[x] = playersAndWallets[x].substring(y + ONE);
		}
		for (int i = 0; i < numberOfPlayers; i++) {
			wallets[i] = Double.parseDouble(walletsValue[i]);
		}
		return wallets;
	}
	// Puts the player's bet in the spot corresponding to that player in the bet array.
	private static double[] bet(double[] wallets, double[] bets, int betAmount, int player) {
		bets[player] = betAmount;
		wallets[player] -= betAmount;
		return bets;
	}
	// Checks if the bet the player entered is valid.
	private static boolean validBet(double[] wallets, int betAmount, int player, boolean goodBet) {
		double playerMoney = wallets[player];
		if (betAmount > playerMoney) {
			goodBet = false;
		} else if (betAmount < playerMoney && !goodBet){
			goodBet = false;
		}
			else {
			goodBet = true;
		}
		return goodBet;
	}
	// Puts the player's number in the spot of the playerOnHorse array that corresponds to the horse they bet on.
	private static int[] playerOnHorse(int[] playerOnHorse, int playerNumber, int horseNumber) {
		playerOnHorse[playerNumber] = horseNumber;
		return playerOnHorse;
	}
	// Generates the horses' position on the track by adding a random number from 1-3 to each horses' position.
	private static int[] racing(int[] horsePosition) {
		for (int x = 0; x < horsePosition.length; x++) {
			int speed = (int) (Math.random() * 3) + 1;
			horsePosition[x] += speed;
		}
		for (int x = 0; x < horsePosition.length; x++) {
			for (int y = x + ONE; y < horsePosition.length; y++) {
				if (horsePosition[x] == horsePosition[y]
						&& horsePosition[x] >= 10)
					;
				int either = (int) (Math.random() * 2) + ONE;
				if (either == ONE) {
					horsePosition[x]++;
				} else if (either == TWO) {
					horsePosition[y]++;
				}
			}
		}
		return horsePosition;
	}
	// Finds the number that corresponds to the winning horse.
	private static int raceWinner(int[] raceResults) {
		int raceWinner = 0;
		int raceWinnerRecent = 0;
		for (int x = 0; x < raceResults.length; x++) {
			for (int y = x + ONE; y < raceResults.length; y++) {
				if (raceResults[x] >= TEN && raceResults[x] > raceResults[y]
						&& raceResults[x] > raceWinnerRecent) {
					raceWinner = x;
					raceWinnerRecent = raceResults[x];
				} else if (raceResults[y] >= TEN
						&& raceResults[y] > raceResults[x]
						&& raceResults[y] > raceWinnerRecent) {
					raceWinner = y;
					raceWinnerRecent = raceResults[y];
				}
			}
		}
		return raceWinner;
	}
	// Finds the number that corresponds to the horse that came in second.
	private static int secondPlaceHorse(int[] raceResults, int raceWinner) {
		int secondPlaceHorse = 0;
		int secondPlaceHorseRecent = 0;
		for (int x = 0; x < raceResults.length; x++) {
			for (int y = x + ONE; y < raceResults.length; y++) {
				if (raceResults[x] > raceResults[y]
						&& raceResults[x] > secondPlaceHorseRecent
						&& x != raceWinner) {
					secondPlaceHorse = x;
					secondPlaceHorseRecent = raceResults[x];
				} else if (raceResults[y] > raceResults[x]
						&& raceResults[y] > secondPlaceHorseRecent
						&& y != raceWinner) {
					secondPlaceHorse = y;
					secondPlaceHorseRecent = raceResults[y];
				}
			}
		}
		return secondPlaceHorse;
	}
	// Creates an array of the players that bet on the winning horse. Is also used to create an array of that players that bet on the second place horse.
	private static int[] playerWinners(int[] playerBets, int winningHorse) {
		String[] playerWinnersValue = new String[playerBets.length];
		int y = 0;
		for (int x = 0; x < playerBets.length; x++) {
			if (playerBets[x] == winningHorse) {
				playerWinnersValue[x] = "winner";
			} else {
				playerWinnersValue[x] = "";
			}
			if (playerWinnersValue[x].equals("winner")) {
				y++;
			}
		}
		int[] playerWinners = new int[y];
		int i = 0;
		for (int x = 0; x < playerBets.length; x++) {
			if (playerWinnersValue[x].equals("winner")) {
				playerWinners[i] = x;
				i++;
			}
		}
		return playerWinners;
	}
	// Updates the wallet of the players that bet on the winning horse.
	private static double[] updateWinnerWallet(double[] wallets, int[] playerWinners, double[] bets) {
		for (int x = 0; x < playerWinners.length; x++) {
			wallets[playerWinners[x]] += bets[playerWinners[x]] * TWO;
		}
		return wallets;
	}
	// updates the wallet of the players that bet on the second place horse.
	private static double[] updateSecondPlaceWallet(double[] wallets, int[] secondPlacePlayers, double[] bets) {
		double half = 0.5;
		for (int x = 0; x < secondPlacePlayers.length; x++) {
			wallets[secondPlacePlayers[x]] += bets[secondPlacePlayers[x]]
					+ bets[secondPlacePlayers[x]] * half;
		}
		return wallets;
	}
}
