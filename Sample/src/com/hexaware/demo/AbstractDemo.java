package com.hexaware.demo;

// Abstract Class have Tightly Coupled Relationship

abstract class Vehicle {
	int x;                                // we can only declare in Abstract Class
	int y = 20;

	public Vehicle() {                    // we can create Constr. of Abstract Class

	}

	public void start() {
		System.out.println("Starting Vehicle...");
	}

	public abstract void move();
	
	public void applyHandBrake() {
		System.out.println("Use Handbrake");
	}
	
}

class Car extends Vehicle {

	public void move() {
		System.out.println("Car Moving...");
	}
	
	public void applyHandBrake() {
		System.out.println("Use Handbrake in the car");
	}
	public void applyBrake() {
		System.out.println("applying brake in the car");
	}

}

public class AbstractDemo {

	public static void main(String[] args) {

		Vehicle v;                        // Can create Object but cannot Instantiate

		Car c = new Car();          
		c.move();                         // Calling child class method
		c.start();                        // Calling Parent class method
		
		Vehicle vech = new Car();        // can instantiate with the child class
		                                 // Polymorphic Object
		
		vech.move();                     // Virtual Method invocation 
		                                 // Calling child class method
		vech.applyHandBrake();           // Calling child class method
		vech.start();	                // Calling parent class method
		//vech.applyBrake();            // Cannot call child class method
	}

}






