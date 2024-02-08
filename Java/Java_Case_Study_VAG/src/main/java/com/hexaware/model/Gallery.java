package com.hexaware.model;
/**
 * Represents an Gallery in the virtual art gallery.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public class Gallery {
    private int galleryID;
    private String name;
    private String description;
    private String location;
    private int curator; // Reference to ArtistID
    private String openingHours;

    public Gallery() {
        // Default constructor
    }

    public Gallery(int galleryID, String name, String description, String location, int curator, String openingHours) {
        this.galleryID = galleryID;
        this.name = name;
        this.description = description;
        this.location = location;
        this.curator = curator;
        this.openingHours = openingHours;
    }

    // Getters and setters

    public int getGalleryID() {
        return galleryID;
    }

    public void setGalleryID(int galleryID) {
        this.galleryID = galleryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCurator() {
        return curator;
    }

    public void setCurator(int curator) {
        this.curator = curator;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
}
