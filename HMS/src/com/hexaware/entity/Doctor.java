package com.hexaware.entity;

public class Doctor {
	private int doctorId;
	private String firstName;
	private String lastName;
	private String specialization;
	private String contactNumber;

	// Default constructor
	public Doctor() {
	}

	// Parameterized constructor
	public Doctor(int doctorId, String firstName, String lastName, String specialization, String contactNumber) {
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialization = specialization;
		this.contactNumber = contactNumber;
	}

	// Getters and setters
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	// Method to print member variables and their values
	public void printDetails() {
		System.out.println("Doctor ID: " + doctorId);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Specialization: " + specialization);
		System.out.println("Contact Number: " + contactNumber);
	}
}
