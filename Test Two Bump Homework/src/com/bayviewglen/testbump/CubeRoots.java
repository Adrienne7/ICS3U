package com.bayviewglen.testbump;

import java.text.DecimalFormat;

public class CubeRoots {

	public static void main(String[] args) {
		DecimalFormat formatter = new DecimalFormat("#.####");
	int start = 10;
	for (int x = start; x <= 50; x++){
		double cubeRoot = Math.cbrt(x);
		String cubeRootFormatted = formatter.format(cubeRoot);
		System.out.println(x + "    " + cubeRootFormatted);
		
	}

	}

}
