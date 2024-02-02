package com.hexaware;

import java.util.Scanner;

public class EnumAnd2DArray {

	int x=10;
	static int licenseNo;
	
	static {                              // It'll Execute Before Main method
		System.out.println("Enter the license number");
		Scanner sc = new Scanner(System.in);
		licenseNo=sc.nextInt();
		System.out.println("From Static Block");
		sc.close();
	}
	
	enum Months {
		JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10),
		NOVEMBER(11), DECEMBER(12);

		int value;

		Months() {                           // Enum Constructor
			System.out.println("From Constructor Enum");
		}

		Months(int value) {					// Enum Param. Constructor
			this.value = value;
			System.out.println("From Param. Constructor Enum");

		}

		public int getValue() {            // Getters
			return value;
		}
	}

	public static void main(String[] args) {
//		int[][] arr2d = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		for (int i = 0; i < arr2d.length; i++) {
//			for (int j = 0; j < arr2d[i].length; j++) {
//				System.out.println(arr2d[i][j] + "   ");
//			}
//			System.out.println(" ");
//		}
//		System.out.println("*********************");
//
//		int[][] jaggedArray = new int[3][];           // Jagged Array
//
//		jaggedArray[0] = new int[] { 10, 11, 12 };
//		jaggedArray[1] = new int[] { 13, 14 };
//		jaggedArray[2] = new int[] { 15, 16, 17, 18 };
//
//		for (int i = 0; i < jaggedArray.length; i++) {
//			for (int j = 0; j < jaggedArray[i].length; j++) {
//				System.out.println(jaggedArray[i][j] + "   ");
//			}
//			System.out.println(" ");
//		}
		
		System.out.println("*********************");

		Months[] mons = Months.values();     // Enum Month[] type of Array
//		for (Months mon : mons) {
//			System.out.println(mon);
//		}

//		for (Months mon : mons) {
//			System.out.println(mon + " --> " + mon.ordinal());  // ordinal() starts from zero
//		}
//		System.out.println("*********Get Assigned Values************");
//		for (Months mon : mons) {
//			System.out.println(mon + " --> " + mon.getValue());
//		}
		
		
		// switch case
//		Months ch = Months.APRIL;
//		switch (ch) {
//		case JANUARY:
//			System.out.println("JAN is the First month");
//			break;
//		case FEBRUARY:
//			System.out.println("Feb is the 2nd month");
//			break;
//		case MARCH:
//			System.out.println("Mar is the 3rd month");
//			break;
//		case APRIL:
//			System.out.println("Apr is the 4th month");
//			break;
//		default:
//			System.out.println("Other months plz work out");
//		}
		System.out.println("From Main " +licenseNo);

	}

}
