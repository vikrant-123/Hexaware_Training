package com.hexaware.java8;

interface Calculator {
	public void add(int a, int b);
	//public int sub(int a, int b);  // Cannot add 2 abstract methods in Functional Interface
}

/*
//Java 7
public class FuncInter implements Calculator {
	  
	public static void main(String[] args) {
		FuncInter f = new FuncInter();
		System.out.println(f.add(10, 20));
	}

	@Override
	public int add(int a, int b) {
		return a + b;
	}
}
*/

// Java 8
public class FuncInter{
	public static void main(String[] args) {
//		Calculator res=(a,b) -> { 
//			return a+b;
//		};
//		
//		System.out.println(res.add(10, 31));
		
		Calculator res=(a,b) ->             // when return type void {} not required
		System.out.println(a+b);
		res.add(10, 20);
	}
}


