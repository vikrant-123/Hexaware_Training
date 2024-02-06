package com.hexaware.dao;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.entity.Appointment;
import com.hexaware.exception.PatientNumberNotFoundException;

public interface IHospitalService {

	Appointment getAppointmentById(int appointmentId) throws SQLException;

	List<Appointment> getAppointmentsForPatient(int patientId) throws PatientNumberNotFoundException, SQLException;

	List<Appointment> getAppointmentsForDoctor(int doctorId) throws SQLException;

	boolean scheduleAppointment(Appointment appointment) throws SQLException;

	boolean updateAppointment(Appointment appointment) throws SQLException;

	boolean cancelAppointment(int appointmentId) throws SQLException;

}
