package com.hexaware.model;

import java.util.Date;
/**
 * Represents an artist in the virtual art gallery.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public class Artist {
    private int artistID;
    private String name;
    private String biography;
    private Date birthDate;
    private String nationality;
    private String website;
    private String contactInformation;

// Default constructor 
    public Artist() {
        
    }
    
 // Parameterized constructor
    public Artist(int artistID, String name, String biography, Date birthDate, String nationality, String website, String contactInformation) {
        this.artistID = artistID;
        this.name = name;
        this.biography = biography;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.website = website;
        this.contactInformation = contactInformation;
    }

    // Getter and setter for ArtistId
    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

 // Getter and setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 // Getter and setter for Biography
    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    // Getter and setter for BirthDate
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
 // Getter and setter for Nationality
    public String getNationality() {
        return nationality;
    }
 
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

 // Getter and setter for Website
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    // Getter and setter for ContactInformation
    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
