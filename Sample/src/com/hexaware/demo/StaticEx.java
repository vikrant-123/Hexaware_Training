package com.hexaware.demo;

import static java.lang.Math.*;                     // used static import


final class First{									// cannot be inherited
	final int x=10;                                 // cannot be changed(Constant)
	
	public final void finalMethod() {				// cannot be override
		System.out.println("from finalMethod...");
	}
	
	
}

 class Second{		
	 static class subSec{				// can create static class inside class
		 
	 }
	 
	 static {							// static block
		 
	 }
	 
	 static int x=10;
	 int y=20;
	 
	 public void regularMethod() {
			System.out.println("x = " + ++x);
			System.out.println("y = " + ++y);
		}

		public static void staticMethod() {      // static method
			System.out.println("x = " + x);
			//System.out.println("y = " + y);   // cannot access non-static variables 
		}
	
}




public class StaticEx {

	public static void main(String[] args) {
		
		Second s=new Second();
		s.regularMethod();
		
		System.out.println("-----------------------------------------");
		
		Second s1=new Second();
		s1.regularMethod();   // When we call regular method twice the value of 
		                      // static variable get changed but local variables get
							  // default value
		
		System.out.println("-----------------------------------------");
		Second.staticMethod();  // can access only static variables
		
		System.out.println("-----------------------------------------");
		System.out.println(pow(2.5, 2.0));    // by using static import 
		System.out.println(random());         //Access methods directly without 
		                                      // using class name
	}

}
