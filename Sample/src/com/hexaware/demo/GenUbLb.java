package com.hexaware.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenUbLb {
	// Integer is the Lowerbound
	public static void addNumToList(List<? super Integer> list) {
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list);
	}

	// Number is the Upperbound
	public static void sumNumbers(List<? extends Number> list) {
		double d = 0;
		for (Number n : list) {
			d = d + n.doubleValue();
		}
		System.out.println(d);

	}

	public static void main(String[] args) {

		List<Object> l1 = new ArrayList<>(); // Object is super class of Integer
		addNumToList(l1);
		List<Number> l2 = new ArrayList<>(); // Number is super class of Integer
		addNumToList(l2);

		List<Double> l3 = Arrays.asList(1.1, 2.2, 3.3); // Double is sub class of Number
		sumNumbers(l3);
		List<Integer> l4 = Arrays.asList(10, 20, 30); // Integer is sub class of Number
		sumNumbers(l4);

//		List<Object> l5 = Arrays.asList(10,20,30);
//		sumNumbers(l5);
	}

}
