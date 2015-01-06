package com.bayviewglen.testbump;

import java.util.Scanner;

public class Countdown {

	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	System.out.print("What number should I stop at? ");
	int number = keyboard.nextInt();
	for (int x = 100; x >= number; x -= 5){
	System.out.println(x);
	}
	System.out.println("I stopped.");
	}

}
