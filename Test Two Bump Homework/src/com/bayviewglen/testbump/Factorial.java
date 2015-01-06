package com.bayviewglen.testbump;

import java.util.Scanner;

public class Factorial {
//if the number is too large to be held by an int, the output is zero.
	public static void main(String[] args) {
			Scanner keybard = new Scanner(System.in);
			int start = 1;
			int sum = 1;
			System.out.print("Please enter a number: ");
			int number = keybard.nextInt();
			for(int x = start; x <= number; x++){
			sum *= x;
			}
			System.out.println(sum);
			}

	}
