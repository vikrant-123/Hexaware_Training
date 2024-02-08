package com.hexaware.model;

import java.util.Date;

/**
 * Represents an artwork in the virtual art gallery.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */

public class Artwork {
    private int artworkID;
    private String title;
    private String description;
    private Date creationDate;
    private String medium;
    private String imageURL;
    private int artistId;

    public Artwork() {
        // Default constructor
    }

	public Artwork(int artworkID, String title, String description, Date creationDate, String medium, String imageURL, int artistId) {
        this.artworkID = artworkID;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.medium = medium;
        this.imageURL = imageURL;
        this.setArtistId(artistId);
    }

    // Getters and setters

    public int getArtworkID() {
        return artworkID;
    }

    public void setArtworkID(int artworkID) {
        this.artworkID = artworkID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	
    @Override
	public String toString() {
		return "Artwork [ArtworkID=" + artworkID + ", "+
			   "Title=" + title + ", "
			 + "Description=" + description + ", "+
			   "CreationDate=" + creationDate + ", "
			 + "Medium=" + medium + ", "
			 + "imageURL=" + imageURL + "]";
	}
}
