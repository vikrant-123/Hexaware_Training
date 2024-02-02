package com.hexaware;

// Interface has Loosely Coupled Relationship

interface Abc{
	
	// int x;                              // we can't only declare, have to initialize
	int y = 20;                           // Variables By Default public static final
	
	
//	public Vehicle() {                    // we can't create Constr. of Interface
//
//	}
	
	public void fly();                    // Methods by default public abstract
										 // Methods should not have implementation
}

interface Vehicle extends Abc {          

	int y = 20;
	void move();						// Methods by default public abstract
										// Methods should not have implementation
}

class XYZ{
	
}

class Car extends XYZ implements Vehicle{

	public void move() {
		System.out.println("Car Moving...");
	}
	
	public void applyHandBrake() {
		System.out.println("Use Handbrake in the car");
	}
	public void applyBrake() {
		System.out.println("applying brake");
	}

	@Override
	public void fly() {
		System.out.println("flying");
	}

}



public class InterfaceDemo {

	public static void main(String[] args) {
		Vehicle a;							 // Can create Object but cannot Instantiate
		
		
		Vehicle v = new Car();				// can instantiate with the car class
		v.move();
		v.fly();
		//v.applyHandBrake();               // can't call method in the car
		

	}

}



