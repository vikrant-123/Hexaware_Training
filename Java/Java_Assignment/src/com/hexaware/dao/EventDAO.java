package com.hexaware.dao;

import java.sql.SQLException;

import com.hexaware.entity.Event;
import com.hexaware.exception.EventNotFoundException;


public interface EventDAO {
    void createEvent(Event event) throws SQLException;
    int getAvailableNoOfTickets() throws SQLException;
    Event getEventDetailsById(int eventId) throws SQLException;
    Event getEventById(int eventId)  throws SQLException, EventNotFoundException;

}
