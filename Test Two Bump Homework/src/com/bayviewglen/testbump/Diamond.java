package com.bayviewglen.testbump;

public class Diamond {

	public static void main(String[] args) {
	for(int x = 1; x <= 5; x++){
	for (int y = 4; y >= x; y--){
	System.out.print(" ");
	}
	for(int z = 1; z <= x*2-1; z++){
	System.out.print("*");
	}
	System.out.println("");
	}
	for(int a = 1; a <= 4; a++){
	for(int i = 1; i <= a; i++){
	System.out.print(" ");
	}
	for(int b = 7; b >= a*2-1; b--){
	System.out.print("*");
	}
	System.out.println("");
	}
	}
	}
