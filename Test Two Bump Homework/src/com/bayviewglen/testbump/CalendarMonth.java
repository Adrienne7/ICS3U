package com.bayviewglen.testbump;

import java.util.Scanner;

public class CalendarMonth {

	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Day the month starts on (Sunday is 1): ");
	String dayOfWeek = keyboard.nextLine();
	int dayOfWeekInt = Integer.valueOf(dayOfWeek);
	System.out.print("Number of days in month: ");
	String numberOfDays = keyboard.nextLine();
	int numberOfDaysInt = Integer.valueOf(numberOfDays);
	int dayOfMonth = 1;
	System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
	while(dayOfMonth <= numberOfDaysInt){
		for(int x = 1; x <= 7 && dayOfMonth <= numberOfDaysInt; x++){
		if (dayOfWeekInt > 1){
			System.out.print("\t");
			dayOfWeekInt--;
		}
		else{
		System.out.print(dayOfMonth + "\t");
		dayOfMonth++;
		}
		}
		System.out.println("");
	}
	}
	}
