package com.bayviewglen.testbump;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

public class SumSequence {

	public static void main(String[] args) {
	Scanner keybard = new Scanner(System.in);
	int start = 1;
	int sum = 0;
	System.out.print("Please enter a number: ");
	int number = keybard.nextInt();
	for(int x = start; x <= number; x++){
	sum += x;
	}
	System.out.println(sum);
	}
}
