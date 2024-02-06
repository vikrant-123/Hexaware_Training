package com.hexware.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.HospitalServiceImpl;
import com.hexaware.entity.Appointment;
import com.hexaware.exception.PatientNumberNotFoundException;

public class HospitalMgmtSystem {

	public static void main(String[] args) throws PatientNumberNotFoundException {
		Scanner scanner = new Scanner(System.in);
		HospitalServiceImpl hsi = new HospitalServiceImpl();
		
		int choice;
		 do {
			 System.out.println();
             System.out.println("=========== Hospital Management System ============");
             System.out.println("1. Get Appointment by ID");
             System.out.println("2. Get Appointments for Patient");
             System.out.println("3. Get Appointments for Doctor");
             System.out.println("4. Schedule Appointment");
             System.out.println("5. Update Appointment");
             System.out.println("6. Cancel Appointment");
             System.out.println("0. Exit");
             System.out.println("===================================================");
             System.out.print("Enter your choice: ");
             

             choice = scanner.nextInt();

             switch (choice) {
                 case 1:
                     System.out.print("Enter Appointment ID: ");
                     int appointmentId = scanner.nextInt();
                     try {
                         Appointment appointment = hsi.getAppointmentById(appointmentId);
                         if (appointment != null) {
                        	 System.out.println("===============================");
                             appointment.printDetails();
                             System.out.println("===============================");
                         } else {
                             System.out.println("Appointment not found.");
                         }
                     } catch(SQLException e) {
                		 System.out.println("Error: "+ e.getMessage());
                	 }
                     break;
                     
                 case 2:
                	 System.out.print("Enter Patient ID: ");
                	 int patientId = scanner.nextInt();
                	 try {
                		 List<Appointment> patientAppointments = hsi.getAppointmentsForPatient(patientId);
                		 if(!patientAppointments.isEmpty()) {
                			 for(Appointment appointment : patientAppointments) {
                            	 System.out.println("===============================");
                				 appointment.printDetails();
                				 System.out.println("===============================");
                			 } 
                		 }else {
                             throw new PatientNumberNotFoundException("Patient Number Not Found");
                         }
                	 }catch(PatientNumberNotFoundException e) {
                		 System.out.println("Error: "+e.getMessage());
                	 }
                	 catch(SQLException e) {
                		 System.out.println("Error: "+ e.getMessage());
                	 }
                	 break;
                	 
                 case 3:
                	 System.out.print("Enter Doctor ID:");
                	 int doctorId = scanner.nextInt();
                	 try {
                		 List<Appointment> doctorAppointments = hsi.getAppointmentsForDoctor(doctorId);
                		 if(!doctorAppointments.isEmpty()) {
                			 for(Appointment appointment : doctorAppointments) {
                            	 System.out.println("===============================");
                				 appointment.printDetails();
                            	 System.out.println("===============================");
                			 }
                		 }
                		 else {
                			 System.out.println("No Appointments found for Doctor.");
                		 }
                	 }catch(SQLException e) {
                		 System.out.println("Error: "+ e.getMessage());
                	 }
                	 break;
                	 
                 case 4:
                	 System.out.println("Schedule Appointment: ");
                	 System.out.print("Enter Appointment ID: ");
                	 int appointmentID = scanner.nextInt();
                	 System.out.print("Enter Patient ID: ");
                	 int patientID= scanner.nextInt();
                	 System.out.print("Enter Doctor ID: ");
                	 int doctorID= scanner.nextInt();
                	 scanner.nextLine();
                	 System.out.print("Enter Appointment Date (YYYY-MM-DD)");
                	 String appointmentDate= scanner.nextLine();
                	 System.out.print("Enter Description: ");
                	 String description = scanner.nextLine();
                	 
                	 Appointment newAppointment = new Appointment(appointmentID, patientID, doctorID, appointmentDate, description);
                	 try {
                		 boolean success = hsi.scheduleAppointment(newAppointment);
                		 if(success) {
                			 System.out.println("Appointment Scheduled Successfully");
                		 }
                		 else {
                			 System.out.println("Failed to schedule Appointment");
                		 }
                	 }catch(SQLException e) {
                		 System.out.println("Error: "+ e.getMessage());
                	 }
                	 break;
                	 
                 case 5:
                	 System.out.print("Enter Appointment ID: ");
                	    int updateAppointmentId = scanner.nextInt();
                	    try {
                	        Appointment appointmentToUpdate = hsi.getAppointmentById(updateAppointmentId);
                	        if (appointmentToUpdate != null) {
                	            System.out.print("Enter New Patient ID (or 0 to keep current): ");
                	            int newPatientId = scanner.nextInt();
                	            if (newPatientId != 0) {
                	                appointmentToUpdate.setPatientId(newPatientId);
                	            }
                	            System.out.print("Enter New Doctor ID (or 0 to keep current): ");
                	            int newDoctorId = scanner.nextInt();
                	            scanner.nextLine();
                	            if (newDoctorId != 0) {
                	                appointmentToUpdate.setDoctorId(newDoctorId);
                	            }
                	            System.out.print("Enter New Appointment Date (or leave blank to keep current): ");
                	            String newAppointmentDate = scanner.nextLine().trim(); // Consume newline character left by nextInt()
                	            if (!newAppointmentDate.isEmpty()) {
                	                appointmentToUpdate.setAppointmentDate(newAppointmentDate);
                	            }
                	            System.out.print("Enter New Appointment Description (or leave blank to keep current): ");
                	            String newDescription = scanner.nextLine();
                	            if (!newDescription.isEmpty()) {
                	                appointmentToUpdate.setDescription(newDescription);
                	            }
                	            
                	            boolean updateSuccess = hsi.updateAppointment(appointmentToUpdate);
                	            if (updateSuccess) {
                	                System.out.println("Appointment updated successfully.");
                	            } else {
                	                System.out.println("Failed to update appointment.");
                	            }
                	        } else {
                	            System.out.println("Appointment not found.");
                	        }
                	    } catch (SQLException e) {
                	        System.out.println("Error: "+e.getMessage());
                	    }
                	    break;
                	    
                 case 6:
                	    System.out.println("Cancel Appointment:");
                	    System.out.print("Enter Appointment ID: ");
                	    int cancelAppointmentId = scanner.nextInt();
                	    try {
                	       
                	        boolean cancelSuccess = hsi.cancelAppointment(cancelAppointmentId);
                	        if (cancelSuccess) {
                	            System.out.println("Appointment canceled successfully.");
                	        } else {
                	            System.out.println("Failed to cancel appointment.");
                	        }
                	    } catch (SQLException e) {
                	        System.out.println("Error: "+e.getMessage());
                	    }
                	    break;
                	    
                 case 0:
                     System.out.println("Exiting the Hospital Management System. Goodbye!");
                     break;

                 default:
                     System.out.println("Invalid choice. Please enter a valid option.");
             }
         } while (choice != 0);
		 scanner.close();

		}
	}

