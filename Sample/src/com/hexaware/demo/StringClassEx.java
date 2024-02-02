package com.hexaware.demo;

public class StringClassEx {

	public static void main(String[] args) {
		
		String str1 = "I like Java";              //String Pool
		String str2 = new String("I like Java"); //Heap
		String str3 ="";
		System.out.println("str1 : " + str1);
		System.out.println("isEmpty :" + str3.isEmpty());
		System.out.println("length :" + str1.length());
		System.out.println("charAt :" + str1.charAt(3));
		System.out.println("concat :" + str1.concat("Programming"));
		System.out.println("contains :" + str1.contains("JAVA"));
		System.out.println("equals :" + str1.equals(str2));   // check the value inside
		System.out.println("substring(2) :" + str1.substring(2));
		System.out.println("substring(0,5) :" + str1.substring(0, 5));
		System.out.println("substring(2,5) :" + str1.substring(2, 5));
		System.out.println(str1.toLowerCase());
		System.out.println(str1.toUpperCase());
		System.out.println("compareTo str2 :" + str1.compareTo(str2));  //check value and return ascii code difference
		System.out.println("compareTo(\"I like java\") :" + str1.compareTo("I like java"));
		System.out.println("compareTo(\"I like C\") :" + str1.compareTo("I like C"));
		System.out.println("replace :" + str1.replace("Java", "JAVA"));
		System.out.println("   Hello  " + ":" + "   Hello  ".trim());
		
		String s1 = new String("Hello");    //Heap
		System.out.println(s1.hashCode()); // will return the address	
		s1 = s1+"All";
		System.out.println(s1);
		System.out.println(s1.hashCode());  // address will get changed because strings are immutable
		
		
		System.out.println("***********String Buffer **********");
		StringBuffer s2 = new StringBuffer("Hello");  // We can create mutable string with StringBuffer
		System.out.println(s2.hashCode()); // will return the address	
		//s2 = s2+"All";
		s2.append(" Everybody");
		
		System.out.println(s2);
		System.out.println(s2.hashCode());  // Hashcode after appending

		System.out.println("***********String Builder **********");
		StringBuilder s3 = new StringBuilder("Hello"); // We can create mutable string with StringBuilder
		System.out.println(s3.hashCode()); // will return the address	
		//s2 = s2+"All";
		s3.append(" My dear ones");
		
		System.out.println(s3);
		System.out.println(s3.hashCode());  // Hashcode after appending
		
		
		
		
		

	}

	}


