package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.entity.Booking;
import com.hexaware.exception.InvalidBookingIDException;
import com.hexaware.util.DButil;

public class BookinDAOImpl implements BookingDAO {

    @Override
    public Booking getBookingById(int bookingId) throws SQLException, InvalidBookingIDException {
        Booking booking = null;
        try (Connection connection = DButil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Booking WHERE booking_id = ?")) {
            preparedStatement.setInt(1, bookingId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                booking = new Booking();
                booking.setBookingId(resultSet.getInt("booking_id"));
                booking.setCustomerId(resultSet.getInt("customer_id"));
                booking.setEventId(resultSet.getInt("event_id"));
                booking.setNumTickets(resultSet.getInt("num_tickets"));
                booking.setTotalCost(resultSet.getDouble("total_cost"));
                booking.setBookingDate(resultSet.getDate("booking_date"));
            }
            else {
            throw new InvalidBookingIDException("Booking not found with ID: " + bookingId);
            }
        }
        
            catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
		return booking;
   }

    @Override
    public void createBooking(Booking booking) throws SQLException {
        try (Connection connection = DButil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Booking (customer_id, event_id, num_tickets, total_cost, booking_date) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, booking.getCustomerId());
            preparedStatement.setInt(2, booking.getEventId());
            preparedStatement.setInt(3, booking.getNumTickets());
            preparedStatement.setDouble(4, booking.getTotalCost());
            preparedStatement.setDate(5, booking.getBookingDate());
            preparedStatement.executeUpdate();
            
            try (PreparedStatement updateStmt = connection.prepareStatement("UPDATE Event SET available_seats = available_seats - ? WHERE event_id = ?")) {
                updateStmt.setInt(1, booking.getNumTickets());
                updateStmt.setInt(2, booking.getEventId());
                updateStmt.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public void cancelBooking(int bookingId) throws SQLException, InvalidBookingIDException {
        try (Connection connection = DButil.getDBConn()) {
            // Start transaction
            connection.setAutoCommit(false);

            // Retrieve the booking to find the number of tickets and event ID
            int numTickets = 0;
            int eventId = 0;
            try (PreparedStatement selectStmt = connection.prepareStatement("SELECT * FROM Booking WHERE booking_id = ?")) {
                selectStmt.setInt(1, bookingId);
                ResultSet resultSet = selectStmt.executeQuery();
                if (resultSet.next()) {
                    numTickets = resultSet.getInt("num_tickets");
                    eventId = resultSet.getInt("event_id");
                } else {
                    throw new InvalidBookingIDException("Booking not found with ID: " + bookingId);
                }
            }

            // Delete the booking
            try (PreparedStatement deleteStmt = connection.prepareStatement("DELETE FROM Booking WHERE booking_id = ?")) {
                deleteStmt.setInt(1, bookingId);
                deleteStmt.executeUpdate();
            }
            // Update available seats in the event
            try (PreparedStatement updateStmt = connection.prepareStatement("UPDATE Event SET available_seats = available_seats + ? WHERE event_id = ?")) {
                updateStmt.setInt(1, numTickets);
                updateStmt.setInt(2, eventId);
                updateStmt.executeUpdate();
            }

            // Commit transaction
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
   

    @Override
    public Booking getBookingDetails(int bookingId) throws SQLException {
        Booking booking = null;

        try (Connection connection = DButil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Booking WHERE booking_id = ?")) {
            preparedStatement.setInt(1, bookingId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    booking = new Booking();
                    booking.setBookingId(resultSet.getInt("booking_id"));
                    booking.setCustomerId(resultSet.getInt("customer_id"));
                    booking.setEventId(resultSet.getInt("event_id"));
                    booking.setNumTickets(resultSet.getInt("num_tickets"));
                    booking.setTotalCost(resultSet.getDouble("total_cost"));
                    booking.setBookingDate(resultSet.getDate("booking_date"));
                }
            }
        }
        return booking;
    }
    
}
