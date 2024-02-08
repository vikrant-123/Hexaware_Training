package com.hexaware.entity;

// Task1
import java.util.Scanner;

public class ConditionalStatements {

	public static void main(String[] args) {
		System.out.println("---------------Welcome to TBS---------------");
		int availableTickets;
		int noOfTicketsBook;
		Scanner sc = new Scanner(System.in);
		String ch=null;
		
		System.out.println("Enter the Available No. of Tickets...");
		availableTickets=sc.nextInt();
		
		
		do {
		System.out.println("Enter the No. of Tickets to Book...");
		noOfTicketsBook=sc.nextInt();
		
		if(availableTickets>=noOfTicketsBook && noOfTicketsBook>0) {
			availableTickets -= noOfTicketsBook;
			System.out.println(noOfTicketsBook+" Tickets Booked Successfully");
			System.out.println("Available Tickets: "+availableTickets);
		}
		else {
			System.out.println("Enter Valid No. of Tickets to Book ");
		}
		System.out.println("Do you want to Continue? Y or y");
		ch=sc.next();
		
		}while(availableTickets>0 && (ch.equals("Y") || ch.equals("y")));
		System.out.println("Thanks for using our Ticket Booking System !!!");
		sc.close();
		
	}

}
