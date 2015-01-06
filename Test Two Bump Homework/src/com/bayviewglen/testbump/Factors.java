package com.bayviewglen.testbump;

import java.util.Scanner;

public class Factors {

	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Please enter a number: ");
	int number = keyboard.nextInt();
	for (int x = 1; x <= number; x++){
	int divisor = number%x;
	if (divisor == 0){
		System.out.print(x + "    ");
	}
	}

	}

}