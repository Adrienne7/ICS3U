package com.bayviewglen.blackjack;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
/*saba
 * 
 * Adrienne Klein
 * ISC3U
 * BlackJack Assignment
 * December 18, 2014
 */
public final class BlackJack {
    public static void main(String[] args) {
        int ZERO = 0;
        int ONE = 1;
        int TWO = 2;
        int THREE = 3;
        int ELEVEN = 11;
        int SEVENTEEN = 17;
        int TWENTY_ONE = 21;
        Scanner keyboard = new Scanner(System.in);
        boolean quitGame = true;
        int number = 0;
        boolean validInput = true;
        String play = "no";
        String player = "";
        double money = 500;
        //gets player name.
        while (quitGame && validInput) {
            while (play.equals("no") && validInput) {
                System.out.print("Please enter your name: ");
                String name = keyboard.nextLine();
                player = nameToLower(name);
                validInput = false;
            }
            //gets player locale.
            while (!player.equals("quit") && !validInput && play.equals("no")) {
                System.out.println("1. Canada");
                System.out.println("2. French Canada");
                System.out.println("3. China");
                System.out.println("4. France");
                System.out.println("5. Germany");
                System.out.println("6. Italy");
                System.out.println("7. Japan");
                System.out.println("8. Korea");
                System.out.println("9. Taiwan");
                System.out.println("10. United Kingdom");
                System.out.println("11. United States");
                System.out.println("Please enter the number that corresponds to the currency you would like to play with: ");
                String place = keyboard.nextLine();
                try {
                    number = Integer.parseInt(place);
                    validInput = true;
                    if (number > ELEVEN || number < ONE) {
                        validInput = false;
                    }
                } catch (NumberFormatException ex) {
                    validInput = false;
                }
                String locale = locale(number);
            }
            play = "yes";
            double betNumber = ONE;
            boolean validBet = false;
            //game starts.
            while (play.equals("yes") && !validBet && !player.equals("quit")) {
                String moneyToStart = currencyFormat(number, money);
                while (!validBet) {
                    System.out.println("You have " + moneyToStart + " in your bank account. Please enter your bet: ");
                    String bet = keyboard.nextLine();
                    try {
                        betNumber = Double.parseDouble(bet);
                        validBet = true;
                        if (betNumber > money){
                        	validBet = false;
                        	System.out.println("You do not have that much money!");
                        }else if (betNumber < ONE){
                        	validBet = false;
                        		System.out.println("You may not make a bet that small!");
                        	}
                    } catch (NumberFormatException ex) {
                        validBet = false;
                        System.out.println("That is not a number!");
                    }
                }

                int sumOfPlayer = ZERO;
                int sumOfDealer = ZERO;
                String cardValueOne = "", suitValueOne = "", cardValueTwo = "", suitValueTwo = "", cardValueThree = "", cardValueFour = "", suitValueThree = "", playerHand = "", dealerHand = "";
                int numOfAcesPlayer = ZERO;
                int numOfAcesDealer = ZERO;
                //generates first dealer card and first two player cards
                while (sumOfPlayer == ZERO && sumOfDealer == ZERO && play.equals("yes") && money > ZERO && !player.equals("quit")) {

                    cardValueOne = firstCardValueGenerator();
                    suitValueOne = secondCardValueGenerator();
                    cardValueTwo = firstCardValueGenerator();
                    suitValueTwo = secondCardValueGenerator();
                    cardValueThree = firstCardValueGenerator();
                    suitValueThree = secondCardValueGenerator();
                    String cardOneDealer = cardValueOne + suitValueOne;
                    String cardOnePlayer = cardValueTwo + suitValueTwo;
                    String cardTwoPlayer = cardValueThree + suitValueThree;
                    System.out.println("Dealer: " + cardValueOne + suitValueOne + "   XX");
                    System.out.println("Player: " + cardValueTwo + suitValueTwo + "   " + cardValueThree + suitValueThree);
                    int firstPlayerCard = cardToNumber(cardValueTwo);
                    int secondPlayerCard = cardToNumber(cardValueThree);
                    int firstDealerCard = cardToNumber(cardValueOne);
                    sumOfPlayer = firstPlayerCard + secondPlayerCard;
                    sumOfDealer = firstDealerCard;
                    playerHand = cardOnePlayer + "    " + cardTwoPlayer;
                    dealerHand = cardOneDealer;
                    // counts the number of current aces for both the dealer and the player.
                    if (cardValueTwo.equals("A") || cardValueThree.equals("A")) {
                        numOfAcesPlayer++;
                    } else if (cardValueTwo.equals("A") && cardValueThree.equals("A")) {
                        numOfAcesPlayer += TWO;
                    }
                    if (cardValueOne.equals("A")) {
                        numOfAcesDealer++;
                    }
                }
                int choice = ZERO;
                int time = ZERO;
                boolean validChoice = false;
                // asks user what they would like to do. If they choose hit or double down, gives player another card. If the player does not bust asks them again.
                while (sumOfPlayer <= TWENTY_ONE && sumOfDealer <= TWENTY_ONE && choice != TWO && !player.equals("quit")) {
                    while (!validChoice) {
                        if (betNumber * TWO <= money && time == ZERO) {
                            System.out.println("Would you like to 1. Hit 2. Stay 3. Double Down?");
                        } else {
                            System.out.println("Would you like to 1. Hit 2. Stay?");
                        }
                        String getChoice = keyboard.nextLine();
                        try {
                            choice = Integer.parseInt(getChoice);
                            validChoice = true;
                            if (choice < ONE || ((time == ZERO && choice > THREE) || (time > ZERO && choice > TWO)) || (betNumber * TWO > money && choice > TWO)) {
                                validChoice = false;
                                System.out.println("That is not a valid choice!");
                            }
                        } catch (NumberFormatException e) {
                            validChoice = false;
                            System.out.println("That is not a valid choice!");
                        }
                    }
                    int thirdPlayerCard = ZERO;
                    double doubleDownBet = ZERO;
                    if (choice == ONE) {
                        cardValueFour = firstCardValueGenerator();
                        String suitValueFour = secondCardValueGenerator();
                        String cardThreePlayer = cardValueFour + suitValueFour;
                        playerHand = playerHand + "    " + cardThreePlayer;
                        System.out.println("Dealer: " + dealerHand + "    XX");
                        System.out.println("Player: " + playerHand);
                        thirdPlayerCard = cardToNumber(cardValueFour);
                        if (cardValueFour.equals("A")) {
                            numOfAcesPlayer++;
                        }
                    } else if (choice == THREE) {
                        cardValueFour = firstCardValueGenerator();
                        String suitValueFour = secondCardValueGenerator();
                        String cardThreePlayer = cardValueFour + suitValueFour;
                        playerHand = playerHand + "    " + cardThreePlayer;
                        System.out.println("Dealer: " + dealerHand + "     XX");
                        System.out.println("Player: " + playerHand);
                        thirdPlayerCard = cardToNumber(cardValueFour);
                        doubleDownBet = betNumber * TWO;
                        betNumber = doubleDownBet;
                    }
                    sumOfPlayer += thirdPlayerCard;
                    validChoice = false;
                    time++;
                }
                sumOfPlayer = updateSum(numOfAcesPlayer, sumOfPlayer);
                String cardValueFive = "";
                //gives dealer their cards.
                while (sumOfPlayer <= TWENTY_ONE && sumOfDealer < SEVENTEEN) {
                    int secondDealerCard = ZERO;
                    int seventeen = SEVENTEEN;
                    while (sumOfDealer < seventeen && !player.equals("quit")) {
                        cardValueFive = firstCardValueGenerator();
                        String suitValueFive = secondCardValueGenerator();
                        String cardTwoDealer = cardValueFive + suitValueFive;
                        dealerHand = dealerHand + "    " + cardTwoDealer;
                        secondDealerCard = cardToNumber(cardValueFive);
                        sumOfDealer = sumOfDealer + secondDealerCard;
                        if (cardValueFive.equals("A")) {
                            numOfAcesDealer++;
                        }
                        sumOfDealer = updateSum(numOfAcesDealer, sumOfDealer);
                    }
                }
                System.out.println("");
                System.out.println("Player: " + playerHand + "    ..." + sumOfPlayer);
                System.out.println("Dealer: " + dealerHand + "    ..." + sumOfDealer);
                int once = ZERO;
                //finds the winner and prints it to the console.
                while (once == ZERO) {
                    if (sumOfPlayer > sumOfDealer && sumOfPlayer <= TWENTY_ONE) {
                        System.out.println("Player wins!");
                        money = money + betNumber;
                    } else if (sumOfPlayer < sumOfDealer && sumOfDealer > TWENTY_ONE) {
                        System.out.println("Player wins!");
                        money = money + betNumber;
                    } else if (sumOfPlayer < sumOfDealer && sumOfDealer <= TWENTY_ONE) {
                        System.out.println("Dealer wins!");
                        money = money - betNumber;
                    } else if (sumOfPlayer > sumOfDealer && sumOfPlayer > TWENTY_ONE) {
                        System.out.println("Dealer wins!");
                        money = money - betNumber;
                    }
                    once++;
                }
                sumOfPlayer = ZERO;
                sumOfDealer = ZERO;
                boolean playAgain = true;
                //asks the user if they would like to play again.
                while (playAgain && money > ZERO && !player.equals("quit")) {
                    System.out.println("Would you like to play again (yes/no)?");
                    play = keyboard.nextLine();
                    if (play.equalsIgnoreCase("yes")) {
                        playAgain = false;
                    } else if (play.equalsIgnoreCase("no")) {
                        playAgain = false;
                        money = 500;
                    } else {
                        playAgain = true;
                    }
                }
                if (money == ZERO) {
                    play = "no";
                    money = 500;
                }
                //quits the game if the player enters quit as their name.
                while (player.equals("quit")) {
                    quitGame = false;
                }
            }
        }
    }
    //turns the players name to lowercase letters.
    public static String nameToLower(String name) {
        String player = name.toLowerCase();
        return player;
    }
    //formats the players money to their chosen locale.
    public static String currencyFormat(int country, double money) {
        int ONE = 1;
        int TWO = 2;
        int THREE = 3;
        int FOUR = 4;
        int FIVE = 5;
        int SIX = 6;
        int SEVEN = 7;
        int EIGHT = 8;
        int NINE = 9;
        int TEN = 10;
        int ELEVEN = 11;
        if (country == ONE) {
            Locale canada = Locale.CANADA;
            String canadaCurrency = NumberFormat.getCurrencyInstance(canada).format(money);
            return canadaCurrency;
        } else if (country == TWO) {
            Locale frenchCanada = Locale.CANADA_FRENCH;
            String frenchCanadaCurrency = NumberFormat.getCurrencyInstance(frenchCanada).format(money);
            return frenchCanadaCurrency;
        } else if (country == THREE) {
            Locale china = Locale.CHINA;
            String chinaCurrency = NumberFormat.getCurrencyInstance(china).format(money);
            return chinaCurrency;
        } else if (country == FOUR) {
            Locale france = Locale.FRANCE;
            String franceCurrency = NumberFormat.getCurrencyInstance(france).format(money);
            return franceCurrency;
        } else if (country == FIVE) {
            Locale germany = Locale.GERMANY;
            String germanyCurrency = NumberFormat.getCurrencyInstance(germany).format(money);
            return germanyCurrency;
        } else if (country == SIX) {
            Locale italy = Locale.ITALY;
            String italyCurrency = NumberFormat.getCurrencyInstance(italy).format(money);
            return italyCurrency;
        } else if (country == SEVEN) {
            Locale japan = Locale.JAPAN;
            String japanCurrency = NumberFormat.getCurrencyInstance(japan).format(money);
            return japanCurrency;
        } else if (country == EIGHT) {
            Locale korea = Locale.KOREA;
            String koreaCurrency = NumberFormat.getCurrencyInstance(korea).format(money);
            return koreaCurrency;
        } else if (country == NINE) {
            Locale taiwan = Locale.TAIWAN;
            String taiwanCurrency = NumberFormat.getCurrencyInstance(taiwan).format(money);
            return taiwanCurrency;
        } else if (country == TEN) {
            Locale uk = Locale.UK;
            String ukCurrency = NumberFormat.getCurrencyInstance(uk).format(money);
            return ukCurrency;
        } else if (country == ELEVEN) {
            Locale us = Locale.US;
            String usCurrency = NumberFormat.getCurrencyInstance(us).format(money);
            return usCurrency;
        } else {
            String notValid = "Not valid input.";
            return notValid;
        }
    }
    //displays their chosen local to the screen.
    public static String locale(int number) {
        int ONE = 1;
        int TWO = 2;
        int THREE = 3;
        int FOUR = 4;
        int FIVE = 5;
        int SIX = 6;
        int SEVEN = 7;
        int EIGHT = 8;
        int NINE = 9;
        int TEN = 10;
        int ELEVEN = 11;
        if (number == ONE) {
            String canada = "You have selected the Canada locale.";
            System.out.println(canada);
            return canada;
        } else if (number == TWO) {
            String frenchCanada = "You have selected the French Canada locale.";
            System.out.println(frenchCanada);
            return frenchCanada;
        } else if (number == THREE) {
            String china = "You have selected the China locale.";
            System.out.println(china);
            return china;
        } else if (number == FOUR) {
            String france = "You have selected the France locale.";
            System.out.println(france);
            return france;
        } else if (number == FIVE) {
            String germany = "You have selected the Germany locale.";
            System.out.println(germany);
            return germany;
        } else if (number == SIX) {
            String italy = "You have selected the Italy locale.";
            System.out.println(italy);
            return italy;
        } else if (number == SEVEN) {
            String japan = "You have selected the Japan locale";
            System.out.println(japan);
            return japan;
        } else if (number == EIGHT) {
            String korea = "You have selected the Korea locale.";
            System.out.println(korea);
            return korea;
        } else if (number == NINE) {
            String taiwan = "You have selected the Taiwan locale.";
            System.out.println(taiwan);
            return taiwan;
        } else if (number == TEN) {
            String uk = "You have selected the UK locale.";
            System.out.println(uk);
            return uk;
        } else if (number == ELEVEN) {
            String us = "You have selected the US locale. ";
            System.out.println(us);
            return us;
        } else {
            String notInput = "That is not a valid input!";
            System.out.println(notInput);
            return notInput;
        }
    }
    //generates the first part of a card as a string, for example: it would generate "10" for the card "10H", or "A" for the card "AD".
    public static String firstCardValueGenerator() {
        int ONE = 1;
        int ELEVEN = 11;
        int TWELVE = 12;
        int THIRTEEN = 13;
        int card = (int)(Math.random() * THIRTEEN) + ONE;
        if (card == ONE) {
            return "A";
        } else if (card == ELEVEN) {
            return "J";
        } else if (card == TWELVE) {
            String cardValue = "Q";
            return cardValue;
        } else if (card == THIRTEEN) {
            String cardValue = "K";
            return cardValue;
        } else {
            String cardValue = String.valueOf(card);
            return cardValue;
        }
    }
    //generates the second part of a card, for example the "H" in "10H" or the "D" in "AD".
    public static String secondCardValueGenerator() {
        int ONE = 1;
        int TWO = 2;
        int THREE = 3;
        int FOUR = 4;
        int suit = (int)(Math.random() * FOUR) + ONE;
        if (suit == ONE) {
            return "H";
        } else if (suit == TWO) {
            return "S";
        } else if (suit == THREE) {
            return "C";
        } else {
            return "D";
        }
    }
    //converts the first part of the card to a number, for example the "J" in "JD" would be converted to 10, and the string "9" in "9C" would be converted to the integer 9.
    public static int cardToNumber(String card) {
        int ZERO = 0;
        int ONE = 1;
        int TWO = 2;
        int TEN = 10;
        int length = card.length();
        String firstCharacter = "";
        if (length == ONE) {
            firstCharacter = card.substring(ZERO, ONE);
        } else if (length == TWO) {
            firstCharacter = card.substring(ZERO, TWO);
        }
        if (firstCharacter.equals("J") || firstCharacter.equals("Q") || firstCharacter.equals("K")) {
            return TEN;
        } else if (firstCharacter.equals("A")) {
            return ONE;
        } else {
            int number = Integer.parseInt(firstCharacter);
            return number;
        }

    }
    //updates the sum of the player or dealer based on the number of aces they have drawn.
    private static int updateSum(int numAces, int currentTotal) {
        int TEN = 10;
        int TWENTY_ONE = 21;
        int score = currentTotal;
        for (int i = 0; i < numAces; ++i) {
            if (score + TEN <= TWENTY_ONE)
                score += TEN;
        }
        return score;
    }
}