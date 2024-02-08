package com.hexaware.controller;

import java.util.List;

import com.hexaware.entity.Booking;
import com.hexaware.entity.Customer;
import com.hexaware.entity.Event;



public interface IBookingSystemRepository {
    List<Event> getEventDetails();
    int getAvailableNoOfTickets(int eventId);
    double calculateBookingCost(int numTickets, double ticketPrice);
    void bookTickets(String eventName, int numTickets, List<Customer> listOfCustomers);
    void cancelBooking(int bookingId);
    Booking getBookingDetails(int bookingId);
	Event createEvent();
}
