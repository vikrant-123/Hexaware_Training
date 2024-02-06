package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Appointment;
import com.hexaware.exception.PatientNumberNotFoundException;
import com.hexaware.util.DBConnection;


public class HospitalServiceImpl implements IHospitalService{
	
	private static Connection con = DBConnection.getConnection();
	
	
	@Override
    public Appointment getAppointmentById(int appointmentId) throws SQLException {
        Appointment appointment = null;
        String query = "SELECT * FROM Appointment WHERE appointmentId = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, appointmentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                appointment = new Appointment(
                        resultSet.getInt("appointmentId"),
                        resultSet.getInt("patientId"),
                        resultSet.getInt("doctorId"),
                        resultSet.getString("appointmentDate"),
                        resultSet.getString("description")
                );
            }
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAppointmentsForPatient(int patientId) throws PatientNumberNotFoundException, SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM Appointment WHERE patientId = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, patientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Appointment appointment = new Appointment(
                        resultSet.getInt("appointmentId"),
                        resultSet.getInt("patientId"),
                        resultSet.getInt("doctorId"),
                        resultSet.getString("appointmentDate"),
                        resultSet.getString("description")
                );
                appointments.add(appointment);
            }
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public List<Appointment> getAppointmentsForDoctor(int doctorId) throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM Appointment WHERE doctorId = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, doctorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Appointment appointment = new Appointment(
                        resultSet.getInt("appointmentId"),
                        resultSet.getInt("patientId"),
                        resultSet.getInt("doctorId"),
                        resultSet.getString("appointmentDate"),
                        resultSet.getString("description")
                );
                appointments.add(appointment);
            }
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public boolean scheduleAppointment(Appointment appointment) throws SQLException {
        String query = "INSERT INTO Appointment (appointmentId, patientId, doctorId, appointmentDate, description) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, appointment.getAppointmentId());
            preparedStatement.setInt(2, appointment.getPatientId());
            preparedStatement.setInt(3, appointment.getDoctorId());
            preparedStatement.setString(4, appointment.getAppointmentDate());
            preparedStatement.setString(5, appointment.getDescription());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    @Override
    public boolean updateAppointment(Appointment appointment) throws SQLException {
        String query = "UPDATE Appointment SET patientId = ?, doctorId = ?, appointmentDate = ?, description = ? WHERE appointmentId = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, appointment.getPatientId());
            preparedStatement.setInt(2, appointment.getDoctorId());
            preparedStatement.setString(3, appointment.getAppointmentDate());
            preparedStatement.setString(4, appointment.getDescription());
            preparedStatement.setInt(5, appointment.getAppointmentId());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    @Override
    public boolean cancelAppointment(int appointmentId) throws SQLException {
        String query = "DELETE FROM Appointment WHERE appointmentId = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, appointmentId);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
}