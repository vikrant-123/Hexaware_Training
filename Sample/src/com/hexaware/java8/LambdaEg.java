package com.hexaware.java8;

public class LambdaEg {

	public static void main(String[] args) {
		
		//Java7
		/*
		Runnable r = new Runnable() {

			@Override
			public void run() {
				Task t = new Task();
				t.print();

			}
		};
		Thread t2 = new Thread(r);
		t2.start();
		*/
		
		// Java 8 - way1
		Runnable r=() -> {
			Task t = new Task();
			t.print();
		};
		Thread t1 = new Thread(r);
		t1.start();
		
		// Java 8 - way2  -- Lambda as a parameter
		Thread t = new Thread(() -> {
			Task task = new Task();
			task.print();
		});
		t.start();
		
		// Java 8 - way3
		Thread t2 = new Thread(() -> {
			new Task().print();
		});
		t2.start();
		// Java 8 - way4
		new Thread(() -> { 
			new Task().print();
		}).start();
		
		//Method Reference
		// Java 8 - way 5
		new Thread(new Task()::print).start();
	}

}
