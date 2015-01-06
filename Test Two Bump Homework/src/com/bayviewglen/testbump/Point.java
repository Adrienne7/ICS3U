package com.bayviewglen.testbump;

public class Point {

	public static void main(String[] args) {
	int point = 0;
	int samePoint = -1;
	int moreRolls = -1;
	int time = 0;
	while(point != samePoint){
	point = (int)(Math.random()*6)+1;
	System.out.println("This is your point " + point);
	System.out.println("These are your rolls: ");
	while(point != moreRolls){
	samePoint = point;
	moreRolls = (int)(Math.random()*6)+1;
	System.out.println(moreRolls);
	time++;
	}
	}
	System.out.println("This is how many times you rolled to get your point: " + time);
	}
}
