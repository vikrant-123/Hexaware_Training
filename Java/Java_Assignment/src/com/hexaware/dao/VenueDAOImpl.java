package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Venue;
import com.hexaware.util.DButil;

public class VenueDAOImpl implements VenueDAO {

    @Override
    public void createVenue(Venue venue) throws SQLException {
        try (Connection connection = DButil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Venue (venue_name, address) VALUES (?, ?)")) {
            preparedStatement.setString(1, venue.getVenueName());
            preparedStatement.setString(2, venue.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    @Override
    public Venue getVenueById(int venueId) throws SQLException {
        Venue venue = null;
        try (Connection connection = DButil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Venue WHERE venue_id = ?")) {
            preparedStatement.setInt(1, venueId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    venue = new Venue();
                    venue.setVenueId(resultSet.getInt("venue_id"));
                    venue.setVenueName(resultSet.getString("venue_name"));
                    venue.setAddress(resultSet.getString("address"));
                }
            }
        }
        return venue;
    }

    @Override
    public List<Venue> getAllVenues() throws SQLException {
        List<Venue> venues = new ArrayList<>();
        try (Connection connection = DButil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Venue");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Venue venue = new Venue();
                venue.setVenueId(resultSet.getInt("venue_id"));
                venue.setVenueName(resultSet.getString("venue_name"));
                venue.setAddress(resultSet.getString("address"));
                venues.add(venue);
            }
        }
        return venues;
    }

    @Override
    public void updateVenue(Venue venue) throws SQLException {
        try (Connection connection = DButil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Venue SET venue_name = ?, address = ? WHERE venue_id = ?")) {
            preparedStatement.setString(1, venue.getVenueName());
            preparedStatement.setString(2, venue.getAddress());
            preparedStatement.setInt(3, venue.getVenueId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteVenue(int venueId) throws SQLException {
        try (Connection connection = DButil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Venue WHERE venue_id = ?")) {
            preparedStatement.setInt(1, venueId);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public int insertOrUpdateVenue(Venue venue, Connection connection) throws SQLException {
        // First, check if the venue exists
        try (PreparedStatement checkStmt = connection.prepareStatement("SELECT venue_id FROM Venue WHERE venue_name = ?")) {
            checkStmt.setString(1, venue.getVenueName());
            try (ResultSet resultSet = checkStmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("venue_id"); // Venue exists, return its ID
                }
            }
        }
        if (venue.getVenueName() == null || venue.getVenueName().isEmpty() || venue.getAddress() == null || venue.getAddress().isEmpty()) {
            throw new SQLException("Venue name and address cannot be null or empty.");
        }


        // Venue doesn't exist, insert it
        try (PreparedStatement insertStmt = connection.prepareStatement("INSERT INTO Venue (venue_name, address) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            insertStmt.setString(1, venue.getVenueName());
            insertStmt.setString(2, venue.getAddress());
            insertStmt.executeUpdate();

            try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the new venue ID
                } else {
                    throw new SQLException("Creating venue failed, no ID obtained.");
                }
            }
        }
        
    }

}

