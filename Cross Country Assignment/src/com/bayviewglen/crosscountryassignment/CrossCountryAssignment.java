package com.bayviewglen.crosscountryassignment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountryAssignment {

	public static void main(String[] args) {
		final int ONE = 1; //* to add to colon character and space character to get everything after the colon and space
		final int SIXTY = 60; //* to convert minutes to seconds and back to minutes
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat formatter = new DecimalFormat("00.000");
		
		//* runner one
		
		 System.out.print("Please enter your first and last name: ");
		String nameOne = keyboard.nextLine();
		int spaceOne = nameOne.indexOf(' ');
		String firstNameOne = nameOne.substring(0, spaceOne);
		int afterSpaceOne = spaceOne + ONE;
		String lastNameOne = nameOne.substring(afterSpaceOne);
		
		System.out.print(firstNameOne + ", Please enter your mile one time(mm:ss.sss): ");
		String firstSplitOne = keyboard.nextLine();
		int firstColonOne = firstSplitOne.indexOf(':');
		int firstAftColonOne = firstColonOne + ONE;
		String firstSplitOneMinutes = firstSplitOne.substring(0, firstColonOne);
		String firstSplitOneSeconds = firstSplitOne.substring(firstAftColonOne);
		
		System.out.print(firstNameOne + ", Please enter your time to the end of the second mile(mm:ss.sss): ");
		String firstMileTwo = keyboard.nextLine();
		int firstColonTwo = firstMileTwo.indexOf(':');
		int firstAftColonTwo = firstColonTwo + ONE;
		String firstMileTwoMinutes = firstMileTwo.substring(0, firstColonTwo);
		String firstMileTwoSeconds = firstMileTwo.substring(firstAftColonTwo);
		
		System.out.print(firstNameOne + ", Please enter your time to the end of the 5 kilometers(mm:ss.sss): ");
		String firstFiveKm = keyboard.nextLine();
		int firstColonThree = firstFiveKm.indexOf(':');
		int firstAftColonThree = firstColonThree + ONE;
		String firstFiveKmMinutes = firstFiveKm.substring(0, firstColonThree);
		String firstFiveKmSeconds = firstFiveKm.substring(firstAftColonThree);		
		
		int firstSplitOneMins = Integer.parseInt(firstSplitOneMinutes);
		int firstMileTwoMins = Integer.parseInt(firstMileTwoMinutes);
		int firstFiveKmMins = Integer.parseInt(firstFiveKmMinutes);
		
		int firstSplitOneMinsToSecs = firstSplitOneMins*SIXTY;
		int firstMileTwoMinsToSecs = firstMileTwoMins*SIXTY;
		int firstFiveKmMinsToSecs = firstFiveKmMins*SIXTY;
		
		double firstSplitOneSecs = Double.parseDouble(firstSplitOneSeconds);
		double firstMileTwoSecs = Double.parseDouble(firstMileTwoSeconds);
		double firstFiveKmSecs = Double.parseDouble(firstFiveKmSeconds);
		
		double firstSplitOneTime = firstSplitOneMinsToSecs + firstSplitOneSecs;
		double firstMileTwoTime = firstMileTwoMinsToSecs + firstMileTwoSecs;
		double firstFiveKmTime = firstFiveKmMinsToSecs + firstFiveKmSecs;
		
		int firstSplitOneMin = (int)firstSplitOneTime/SIXTY;
		int firstSplitTwoMin = (int)(firstMileTwoTime - firstSplitOneTime)/SIXTY;
		int firstSplitThreeMin = (int)(firstFiveKmTime - firstMileTwoTime)/SIXTY;
		
		double firstSplitOneSec = firstSplitOneTime - firstSplitOneMin*SIXTY;
		double firstSplitTwoSec = (firstMileTwoTime - firstSplitOneTime) - firstSplitTwoMin*SIXTY;
		double firstSplitThreeSec = (firstFiveKmTime - firstMileTwoTime) - firstSplitThreeMin*SIXTY;
		
		String firstSplitOneSecsDec = formatter.format(firstSplitOneSec);
		String firstSplitTwoSecsDec = formatter.format(firstSplitTwoSec);
		String firstSplitThreeSecsDec = formatter.format(firstSplitThreeSec);
		String firstFiveKmSecsDec = formatter.format(firstFiveKmSecs);
		
		System.out.println(" ");
		System.out.println("Runner One Summary");
		System.out.println(" ");
		System.out.println("Runner: " + lastNameOne + ", " + firstNameOne);
		System.out.println("Split one time: " + firstSplitOneMin + ":" + firstSplitOneSecsDec);
		System.out.println("Split two time: " + firstSplitTwoMin + ":" + firstSplitTwoSecsDec);
		System.out.println("Split three time: " + firstSplitThreeMin + ":" + firstSplitThreeSecsDec);
		System.out.println("Total time: " + firstFiveKmMins + ":" + firstFiveKmSecsDec);
		System.out.println(" ");

		//* runner two
		
		System.out.print("Please enter your first and last name: ");
		String nameTwo = keyboard.nextLine();
		int spaceTwo = nameTwo.indexOf(' ');
		String firstNameTwo = nameTwo.substring(0, spaceTwo);
		int afterSpaceTwo = spaceTwo + ONE;
		String lastNameTwo = nameTwo.substring(afterSpaceTwo);
		
		System.out.print(firstNameTwo + ", Please enter your mile one time(mm:ss.sss): ");
		String secondSplitOne = keyboard.nextLine();
		int secondColonOne = secondSplitOne.indexOf(':');
		int secondAftColonOne = secondColonOne + ONE;
		String secondSplitOneMinutes = secondSplitOne.substring(0, secondColonOne);
		String secondSplitOneSeconds = secondSplitOne.substring(secondAftColonOne);
		
		System.out.print(firstNameTwo + ", Please enter your time to the end of the second mile(mm:ss.sss): ");
		String secondMileTwo = keyboard.nextLine();
		int secondColonTwo = secondMileTwo.indexOf(':');
		int secondAftColonTwo = secondColonTwo + ONE;
		String secondMileTwoMinutes = secondMileTwo.substring(0, secondColonTwo);
		String secondMileTwoSeconds = secondMileTwo.substring(secondAftColonTwo);
		
		System.out.print(firstNameTwo + ", Please enter your time to the end of the 5 kilometers(mm:ss.sss): ");
		String secondFiveKm = keyboard.nextLine();
		int secondColonThree = secondFiveKm.indexOf(':');
		int secondAftColonThree = secondColonThree + ONE;
		String secondFiveKmMinutes = secondFiveKm.substring(0, secondColonThree);
		String secondFiveKmSeconds = secondFiveKm.substring(secondAftColonThree);		
		
		int secondSplitOneMins = Integer.parseInt(secondSplitOneMinutes);
		int secondMileTwoMins = Integer.parseInt(secondMileTwoMinutes);
		int secondFiveKmMins = Integer.parseInt(secondFiveKmMinutes);
		
		int secondSplitOneMinsToSecs = secondSplitOneMins*SIXTY;
		int secondMileTwoMinsToSecs = secondMileTwoMins*SIXTY;
		int secondFiveKmMinsToSecs = secondFiveKmMins*SIXTY;
		
		double secondSplitOneSecs = Double.parseDouble(secondSplitOneSeconds);
		double secondMileTwoSecs = Double.parseDouble(secondMileTwoSeconds);
		double secondFiveKmSecs = Double.parseDouble(secondFiveKmSeconds);
		
		double secondSplitOneTime = secondSplitOneMinsToSecs + secondSplitOneSecs;
		double secondMileTwoTime = secondMileTwoMinsToSecs + secondMileTwoSecs;
		double secondFiveKmTime = secondFiveKmMinsToSecs + secondFiveKmSecs;
		
		int secondSplitOneMin = (int)secondSplitOneTime/SIXTY;
		int secondSplitTwoMin = (int)(secondMileTwoTime - secondSplitOneTime)/SIXTY;
		int secondSplitThreeMin = (int)(secondFiveKmTime - secondMileTwoTime)/SIXTY;
		
		double secondSplitOneSec = secondSplitOneTime - secondSplitOneMin*SIXTY;
		double secondSplitTwoSec = (secondMileTwoTime - secondSplitOneTime) - secondSplitTwoMin*SIXTY;
		double secondSplitThreeSec = (secondFiveKmTime - secondMileTwoTime) - secondSplitThreeMin*SIXTY;
		
		String secondSplitOneSecsDec = formatter.format(secondSplitOneSec);
		String secondSplitTwoSecsDec = formatter.format(secondSplitTwoSec);
		String secondSplitThreeSecsDec = formatter.format(secondSplitThreeSec);
		String secondFiveKmSecsDec = formatter.format(secondFiveKmSecs);
		
		System.out.println(" ");
		System.out.println("Runner Two Summary");
		System.out.println(" ");
		System.out.println("Runner: " + lastNameTwo + ", " + firstNameTwo);
		System.out.println("Split one time: " + secondSplitOneMin + ":" + secondSplitOneSecsDec);
		System.out.println("Split two time: " + secondSplitTwoMin + ":" + secondSplitTwoSecsDec);
		System.out.println("Split three time: " + secondSplitThreeMin + ":" + secondSplitThreeSecsDec);
		System.out.println("Total time: " + secondFiveKmMins + ":" + secondFiveKmSecsDec);
		System.out.println(" ");
		
		//* runner three
		
		System.out.print("Please enter your first and last name: ");
		String nameThree = keyboard.nextLine();
		int spaceThree = nameThree.indexOf(' ');
		String firstNameThree = nameThree.substring(0, spaceThree);
		int afterSpaceThree = spaceThree + ONE;
		String lastNameThree = nameThree.substring(afterSpaceThree);
		
		System.out.print(firstNameThree + ", Please enter your mile one time(mm:ss.sss): ");
		String thirdSplitOne = keyboard.nextLine();
		int thirdColonOne = thirdSplitOne.indexOf(':');
		int thirdAftColonOne = thirdColonOne + ONE;
		String thirdSplitOneMinutes = thirdSplitOne.substring(0, thirdColonOne);
		String thirdSplitOneSeconds = thirdSplitOne.substring(thirdAftColonOne);
		
		System.out.print(firstNameThree + ", Please enter your time to the end of the second mile(mm:ss.sss): ");
		String thirdMileTwo = keyboard.nextLine();
		int thirdColonTwo = thirdMileTwo.indexOf(':');
		int thirdAftColonTwo = thirdColonTwo + ONE;
		String thirdMileTwoMinutes = thirdMileTwo.substring(0, thirdColonTwo);
		String thirdMileTwoSeconds = thirdMileTwo.substring(thirdAftColonTwo);
		
		System.out.print(firstNameThree + ", Please enter your time to the end of the 5 kilometers(mm:ss.sss): ");
		String thirdFiveKm = keyboard.nextLine();
		int thirdColonThree = thirdFiveKm.indexOf(':');
		int thirdAftColonThree = thirdColonThree + ONE;
		String thirdFiveKmMinutes = thirdFiveKm.substring(0, thirdColonThree);
		String thirdFiveKmSeconds = thirdFiveKm.substring(thirdAftColonThree);		
		
		int thirdSplitOneMins = Integer.parseInt(thirdSplitOneMinutes);
		int thirdMileTwoMins = Integer.parseInt(thirdMileTwoMinutes);
		int thirdFiveKmMins = Integer.parseInt(thirdFiveKmMinutes);
		
		int thirdSplitOneMinsToSecs = thirdSplitOneMins*SIXTY;
		int thirdMileTwoMinsToSecs = thirdMileTwoMins*SIXTY;
		int thirdFiveKmMinsToSecs = thirdFiveKmMins*SIXTY;
		
		double thirdSplitOneSecs = Double.parseDouble(thirdSplitOneSeconds);
		double thirdMileTwoSecs = Double.parseDouble(thirdMileTwoSeconds);
		double thirdFiveKmSecs = Double.parseDouble(thirdFiveKmSeconds);
		
		double thirdSplitOneTime = thirdSplitOneMinsToSecs + thirdSplitOneSecs;
		double thirdMileTwoTime = thirdMileTwoMinsToSecs + thirdMileTwoSecs;
		double thirdFiveKmTime = thirdFiveKmMinsToSecs + thirdFiveKmSecs;
		
		int thirdSplitOneMin = (int)thirdSplitOneTime/SIXTY;
		int thirdSplitTwoMin = (int)(thirdMileTwoTime - thirdSplitOneTime)/SIXTY;
		int thirdSplitThreeMin = (int)(thirdFiveKmTime - thirdMileTwoTime)/SIXTY;
		
		double thirdSplitOneSec = thirdSplitOneTime - thirdSplitOneMin*SIXTY;
		double thirdSplitTwoSec = (thirdMileTwoTime - thirdSplitOneTime) - thirdSplitTwoMin*SIXTY;
		double thirdSplitThreeSec = (thirdFiveKmTime - thirdMileTwoTime) - thirdSplitThreeMin*SIXTY;
		
		String thirdSplitOneSecsDec = formatter.format(thirdSplitOneSec);
		String thirdSplitTwoSecsDec = formatter.format(thirdSplitTwoSec);
		String thirdSplitThreeSecsDec = formatter.format(thirdSplitThreeSec);
		String thirdFiveKmSecsDec = formatter.format(thirdFiveKmSecs);
		
		System.out.println(" ");
		System.out.println("Runner Three Summary");
		System.out.println(" ");
		System.out.println("Runner: " + lastNameThree + ", " + firstNameThree);
		System.out.println("Split one time: " + thirdSplitOneMin + ":" + thirdSplitOneSecsDec);
		System.out.println("Split two time: " + thirdSplitTwoMin + ":" + thirdSplitTwoSecsDec);
		System.out.println("Split three time: " + thirdSplitThreeMin + ":" + thirdSplitThreeSecsDec);
		System.out.println("Total time: " + thirdFiveKmMins + ":" + thirdFiveKmSecsDec);
		System.out.println(" ");
		
		//* runner four
		
		System.out.print("Please enter your first and last name: ");
		String nameFour = keyboard.nextLine();
		int spaceFour = nameFour.indexOf(' ');
		String firstNameFour = nameFour.substring(0, spaceFour);
		int afterSpaceFour = spaceFour + ONE;
		String lastNameFour = nameFour.substring(afterSpaceFour);
		
		System.out.print(firstNameFour + ", Please enter your mile one time(mm:ss.sss): ");
		String fourthSplitOne = keyboard.nextLine();
		int fourthColonOne = fourthSplitOne.indexOf(':');
		int fourthAftColonOne = fourthColonOne + ONE;
		String fourthSplitOneMinutes = fourthSplitOne.substring(0, fourthColonOne);
		String fourthSplitOneSeconds = fourthSplitOne.substring(fourthAftColonOne);
		
		System.out.print(firstNameFour + ", Please enter your time to the end of the second mile(mm:ss.sss): ");
		String fourthMileTwo = keyboard.nextLine();
		int fourthColonTwo = fourthMileTwo.indexOf(':');
		int fourthAftColonTwo = fourthColonTwo + ONE;
		String fourthMileTwoMinutes = fourthMileTwo.substring(0, fourthColonTwo);
		String fourthMileTwoSeconds = fourthMileTwo.substring(fourthAftColonTwo);
		
		System.out.print(firstNameFour + ", Please enter your time to the end of the 5 kilometers(mm:ss.sss): ");
		String fourthFiveKm = keyboard.nextLine();
		int fourthColonThree = fourthFiveKm.indexOf(':');
		int fourthAftColonThree = fourthColonThree + ONE;
		String fourthFiveKmMinutes = fourthFiveKm.substring(0, fourthColonThree);
		String fourthFiveKmSeconds = fourthFiveKm.substring(fourthAftColonThree);		
		
		int fourthSplitOneMins = Integer.parseInt(fourthSplitOneMinutes);
		int fourthMileTwoMins = Integer.parseInt(fourthMileTwoMinutes);
		int fourthFiveKmMins = Integer.parseInt(fourthFiveKmMinutes);
		
		int fourthSplitOneMinsToSecs = fourthSplitOneMins*SIXTY;
		int fourthMileTwoMinsToSecs = fourthMileTwoMins*SIXTY;
		int fourthFiveKmMinsToSecs = fourthFiveKmMins*SIXTY;
		
		double fourthSplitOneSecs = Double.parseDouble(fourthSplitOneSeconds);
		double fourthMileTwoSecs = Double.parseDouble(fourthMileTwoSeconds);
		double fourthFiveKmSecs = Double.parseDouble(fourthFiveKmSeconds);
		
		double fourthSplitOneTime = fourthSplitOneMinsToSecs + fourthSplitOneSecs;
		double fourthMileTwoTime = fourthMileTwoMinsToSecs + fourthMileTwoSecs;
		double fourthFiveKmTime = fourthFiveKmMinsToSecs + fourthFiveKmSecs;
		
		int fourthSplitOneMin = (int)fourthSplitOneTime/SIXTY;
		int fourthSplitTwoMin = (int)(fourthMileTwoTime - fourthSplitOneTime)/SIXTY;
		int fourthSplitThreeMin = (int)(fourthFiveKmTime - fourthMileTwoTime)/SIXTY;
		
		double fourthSplitOneSec = fourthSplitOneTime - fourthSplitOneMin*SIXTY;
		double fourthSplitTwoSec = (fourthMileTwoTime - fourthSplitOneTime) - fourthSplitTwoMin*SIXTY;
		double fourthSplitThreeSec = (fourthFiveKmTime - fourthMileTwoTime) - fourthSplitThreeMin*SIXTY;
		
		String fourthSplitOneSecsDec = formatter.format(fourthSplitOneSec);
		String fourthSplitTwoSecsDec = formatter.format(fourthSplitTwoSec);
		String fourthSplitThreeSecsDec = formatter.format(fourthSplitThreeSec);
		String fourthFiveKmSecsDec = formatter.format(fourthFiveKmSecs);
		
		System.out.println(" ");
		System.out.println("Runner Four Summary");
		System.out.println(" ");
		System.out.println("Runner: " + lastNameFour + ", " + firstNameFour);
		System.out.println("Split one time: " + fourthSplitOneMin + ":" + fourthSplitOneSecsDec);
		System.out.println("Split two time: " + fourthSplitTwoMin + ":" + fourthSplitTwoSecsDec);
		System.out.println("Split three time: " + fourthSplitThreeMin + ":" + fourthSplitThreeSecsDec);
		System.out.println("Total time: " + fourthFiveKmMins + ":" + fourthFiveKmSecsDec);
		System.out.println(" ");
		
		//* runner five
		
		System.out.print("Please enter your first and last name: ");
		String nameFive = keyboard.nextLine();
		int spaceFive = nameFive.indexOf(' ');
		String firstNameFive = nameFive.substring(0, spaceFive);
		int afterSpaceFive = spaceFive + ONE;
		String lastNameFive = nameFive.substring(afterSpaceFive);
		
		System.out.print(firstNameFive + ", Please enter your mile one time(mm:ss.sss): ");
		String fifthSplitOne = keyboard.nextLine();
		int fifthColonOne = fifthSplitOne.indexOf(':');
		int fifthAftColonOne = fifthColonOne + ONE;
		String fifthSplitOneMinutes = fifthSplitOne.substring(0, fifthColonOne);
		String fifthSplitOneSeconds = fifthSplitOne.substring(fifthAftColonOne);
		
		System.out.print(firstNameFive + ", Please enter your time to the end of the second mile(mm:ss.sss): ");
		String fifthMileTwo = keyboard.nextLine();
		int fifthColonTwo = fifthMileTwo.indexOf(':');
		int fifthAftColonTwo = fifthColonTwo + ONE;
		String fifthMileTwoMinutes = fifthMileTwo.substring(0, fifthColonTwo);
		String fifthMileTwoSeconds = fifthMileTwo.substring(fifthAftColonTwo);
		
		System.out.print(firstNameFive + ", Please enter your time to the end of the 5 kilometers(mm:ss.sss): ");
		String fifthFiveKm = keyboard.nextLine();
		int fifthColonThree = fifthFiveKm.indexOf(':');
		int fifthAftColonThree = fifthColonThree + ONE;
		String fifthFiveKmMinutes = fifthFiveKm.substring(0, fifthColonThree);
		String fifthFiveKmSeconds = fifthFiveKm.substring(fifthAftColonThree);		
		
		int fifthSplitOneMins = Integer.parseInt(fifthSplitOneMinutes);
		int fifthMileTwoMins = Integer.parseInt(fifthMileTwoMinutes);
		int fifthFiveKmMins = Integer.parseInt(fifthFiveKmMinutes);
		
		int fifthSplitOneMinsToSecs = fifthSplitOneMins*SIXTY;
		int fifthMileTwoMinsToSecs = fifthMileTwoMins*SIXTY;
		int fifthFiveKmMinsToSecs = fifthFiveKmMins*SIXTY;
		
		double fifthSplitOneSecs = Double.parseDouble(fifthSplitOneSeconds);
		double fifthMileTwoSecs = Double.parseDouble(fifthMileTwoSeconds);
		double fifthFiveKmSecs = Double.parseDouble(fifthFiveKmSeconds);
		
		double fifthSplitOneTime = fifthSplitOneMinsToSecs + fifthSplitOneSecs;
		double fifthMileTwoTime = fifthMileTwoMinsToSecs + fifthMileTwoSecs;
		double fifthFiveKmTime = fifthFiveKmMinsToSecs + fifthFiveKmSecs;
		
		int fifthSplitOneMin = (int)fifthSplitOneTime/SIXTY;
		int fifthSplitTwoMin = (int)(fifthMileTwoTime - fifthSplitOneTime)/SIXTY;
		int fifthSplitThreeMin = (int)(fifthFiveKmTime - fifthMileTwoTime)/SIXTY;
		
		double fifthSplitOneSec = fifthSplitOneTime - fifthSplitOneMin*SIXTY;
		double fifthSplitTwoSec = (fifthMileTwoTime - fifthSplitOneTime) - fifthSplitTwoMin*SIXTY;
		double fifthSplitThreeSec = (fifthFiveKmTime - fifthMileTwoTime) - fifthSplitThreeMin*SIXTY;
		
		String fifthSplitOneSecsDec = formatter.format(fifthSplitOneSec);
		String fifthSplitTwoSecsDec = formatter.format(fifthSplitTwoSec);
		String fifthSplitThreeSecsDec = formatter.format(fifthSplitThreeSec);
		String fifthFiveKmSecsDec = formatter.format(fifthFiveKmSecs);
		
		System.out.println(" ");
		System.out.println("Runner Five Summary");
		System.out.println(" ");
		System.out.println("Runner: " + lastNameFive + ", " + firstNameFive);
		System.out.println("Split one time: " + fifthSplitOneMin + ":" + fifthSplitOneSecsDec);
		System.out.println("Split two time: " + fifthSplitTwoMin + ":" + fifthSplitTwoSecsDec);
		System.out.println("Split three time: " + fifthSplitThreeMin + ":" + fifthSplitThreeSecsDec);
		System.out.println("Total time: " + fifthFiveKmMins + ":" + fifthFiveKmSecsDec);
		System.out.println(" ");
		
		//* summary table
		
		String firstSplitOneTotalTime = firstSplitOneMin + ":" + firstSplitOneSecsDec;
		String firstSplitTwoTotalTime = firstSplitTwoMin  + ":" + firstSplitTwoSecsDec;
		String firstSplitThreeTotalTime = firstSplitThreeMin + ":" + firstSplitThreeSecsDec;
		String firstTotalTime = firstFiveKmMins + ":" + firstFiveKmSecsDec;
		
		String secondSplitOneTotalTime = secondSplitOneMin + ":" + secondSplitOneSecsDec;
		String secondSplitTwoTotalTime = secondSplitTwoMin  + ":" + secondSplitTwoSecsDec;
		String secondSplitThreeTotalTime = secondSplitThreeMin + ":" + secondSplitThreeSecsDec;
		String secondTotalTime = secondFiveKmMins + ":" + secondFiveKmSecsDec;
		
		String thirdSplitOneTotalTime = thirdSplitOneMin + ":" + thirdSplitOneSecsDec;
		String thirdSplitTwoTotalTime = thirdSplitTwoMin  + ":" + thirdSplitTwoSecsDec;
		String thirdSplitThreeTotalTime = thirdSplitThreeMin + ":" + thirdSplitThreeSecsDec;
		String thirdTotalTime = thirdFiveKmMins + ":" + thirdFiveKmSecsDec;
		
		String fourthSplitOneTotalTime = fourthSplitOneMin + ":" + fourthSplitOneSecsDec;
		String fourthSplitTwoTotalTime = fourthSplitTwoMin  + ":" + fourthSplitTwoSecsDec;
		String fourthSplitThreeTotalTime = fourthSplitThreeMin + ":" + fourthSplitThreeSecsDec;
		String fourthTotalTime = fourthFiveKmMins + ":" + fourthFiveKmSecsDec;
		
		String fifthSplitOneTotalTime = fifthSplitOneMin + ":" + fifthSplitOneSecsDec;
		String fifthSplitTwoTotalTime = fifthSplitTwoMin  + ":" + fifthSplitTwoSecsDec;
		String fifthSplitThreeTotalTime = fifthSplitThreeMin + ":" + fifthSplitThreeSecsDec;
		String fifthTotalTime = fifthFiveKmMins + ":" + fifthFiveKmSecsDec;
		
		System.out.printf("%6s%20s%20s%20s%20s", "Runner", "Split One Time",  "Split Two Time", "Split Three Time", "Total Time");
		System.out.printf("%n%6s%20s%20s%20s%20s", nameOne, firstSplitOneTotalTime, firstSplitTwoTotalTime, firstSplitThreeTotalTime, firstTotalTime);
		System.out.printf("%n%6s%20s%20s%20s%20s", nameTwo, secondSplitOneTotalTime, secondSplitTwoTotalTime, secondSplitThreeTotalTime, secondTotalTime);
		System.out.printf("%n%6s%20s%20s%20s%20s", nameThree, thirdSplitOneTotalTime, thirdSplitTwoTotalTime, thirdSplitThreeTotalTime, thirdTotalTime);
		System.out.printf("%n%6s%20s%20s%20s%20s", nameFour, fourthSplitOneTotalTime, fourthSplitTwoTotalTime, fourthSplitThreeTotalTime, fourthTotalTime);
		System.out.printf("%n%6s%20s%20s%20s%20s", nameFive, fifthSplitOneTotalTime, fifthSplitTwoTotalTime, fifthSplitThreeTotalTime, fifthTotalTime);
		
		keyboard.close();
	
	}

}