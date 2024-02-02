package com.hexaware.java8;

public class MyThread implements Runnable {

	@Override
	public void run() {
		Task t = new Task();
		t.print();

	}

}
