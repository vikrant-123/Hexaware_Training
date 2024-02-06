package com.hexaware.entity;

public class Patient {
	private int patientId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String contactNumber;
	private String address;

	// Default constructor
	public Patient() {
	}

	// Parameterized constructor
	public Patient(int patientId, String firstName, String lastName, String dateOfBirth, String gender,
			String contactNumber, String address) {
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	// Getters and setters
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Method to print member variables and their values
	public void printDetails() {
		System.out.println("Patient ID: " + patientId);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Date of Birth: " + dateOfBirth);
		System.out.println("Gender: " + gender);
		System.out.println("Contact Number: " + contactNumber);
		System.out.println("Address: " + address);
	}
}
