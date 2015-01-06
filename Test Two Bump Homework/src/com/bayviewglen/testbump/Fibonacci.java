package com.bayviewglen.testbump;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Please enter a number: ");
	int number = keyboard.nextInt();
	int firstNumber = 1;
	int addition = 0;
	for (int x = 1; x <= 1; x++){
		System.out.print(firstNumber + "    ");
		while (x <= number && number != 1){
		int sum = firstNumber + addition;
		System.out.print(sum + "    ");
		addition = firstNumber;
		firstNumber = sum;
		x++;
		}
	}
	}

}
