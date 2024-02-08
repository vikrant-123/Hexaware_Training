package com.hexaware.dao;

import java.sql.SQLException;

import com.hexaware.entity.Booking;
import com.hexaware.exception.InvalidBookingIDException;

public interface BookingDAO {
   
	Booking getBookingById(int bookingId) throws SQLException, InvalidBookingIDException ;
    
    void createBooking(Booking booking) throws SQLException;
    
    void cancelBooking(int bookingId) throws SQLException, InvalidBookingIDException;
    
    Booking getBookingDetails(int bookingId) throws SQLException, InvalidBookingIDException;
    
}
