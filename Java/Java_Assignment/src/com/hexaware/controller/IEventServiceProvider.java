package com.hexaware.controller;

import java.util.List;

import com.hexaware.entity.Event;
import com.hexaware.entity.Venue;

public interface IEventServiceProvider {
	
	    Event createEvent(String eventName, String date, String time, int totalSeats, float ticketPrice, String eventType, Venue venue);
	    List<Event> getEventDetails();
	    int getAvailableNoOfTickets(Event event);
	}



