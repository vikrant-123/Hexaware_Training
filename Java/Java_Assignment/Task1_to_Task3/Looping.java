package com.hexaware.entity;

import java.util.Scanner;

public class Looping {

	public static void main(String[] args) {
		System.out.println("---------------Welcome to TBS---------------");
		Scanner sc = new Scanner(System.in);
		int choice;
		int noOfTickets;
		double price=0.0;
		String ch=null;
		
		do {
		System.out.println("Choose the Ticket Type:");
		System.out.println("1. Silver");
		System.out.println("2. Gold");
		System.out.println("3. Diamond");
		choice = sc.nextInt();
		System.out.println("Enter the No. of Tickets to book");
		noOfTickets=sc.nextInt();
		
		switch(choice) {
		case 1:
			price=350.0;
			break;
			
		case 2:
			price=550.0;
			break;
			
		case 3:
			price=750.0;
			break;
			
		default:
			System.out.println("Enter a Valid Choice");
		}
		double totalCost=price*noOfTickets;
		System.out.println("The total cost for booked tickets is "+totalCost);
		System.out.println("Do you want to book more tickets?(Y or y)");
		ch=sc.next();
		
		}while(ch.equals("Y") || ch.equals("y"));
		sc.close();
	}

}
