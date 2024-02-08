package com.hexaware.entity;

import com.hexaware.dao.*;
import com.hexaware.exception.EventNotFoundException;

import java.sql.Date;
import java.sql.SQLException;

public class Booking {
	private int bookingId;
	private int customerId;
	private int eventId;
	private int numTickets;
	private double totalCost;
	private Date bookingDate;

	public Booking() {
	}

	public Booking(int bookingId, int customerId, int eventId, int numTickets, double totalCost, Date bookingDate) {
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.eventId = eventId;
		this.numTickets = numTickets;
		this.totalCost = totalCost;
		this.bookingDate = bookingDate;
	}

	// Getter and Setter methods

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getNumTickets() {
		return numTickets;
	}

	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void calculateBookingCost(int eventId, int numTickets, EventDAO eventDao) throws SQLException {
		// Retrieve the event by eventId
		Event event;
		try {
			event = eventDao.getEventById(eventId);

			if (event != null) {
				// Calculate the total cost
				double ticketPrice = event.getTicketPrice();
				this.totalCost = ticketPrice * numTickets;
			} else {
				// Handle case where event is not found
				System.out.println("Event not found for ID: " + eventId);
			}
		} catch (EventNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerId=" + customerId + ", eventId=" + eventId
				+ ", numTickets=" + numTickets + ", totalCost=" + totalCost + ", bookingDate=" + bookingDate + "]";
	}
}
