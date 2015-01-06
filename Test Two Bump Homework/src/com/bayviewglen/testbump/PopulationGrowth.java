package com.bayviewglen.testbump;

public class PopulationGrowth {

	public static void main(String[] args) {
	double population = 150000;
	int year = 0;
	while (population<= 1000000){
	double growth = population/5;
	population += growth;
	year++;
	}
	System.out.print(year);
	}

}
