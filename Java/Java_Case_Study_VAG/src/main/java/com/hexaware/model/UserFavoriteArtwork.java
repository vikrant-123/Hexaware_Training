package com.hexaware.model;
/**
 * Represents an UserFavoriteArtwork in the virtual art gallery.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public class UserFavoriteArtwork {
	
	private int userId;
	private int artworkId;
	
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getArtworkId() {
		return artworkId;
	}
	
	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}
	
	
	public UserFavoriteArtwork() {
		
	}

	public UserFavoriteArtwork(int userId, int artworkId) {
		
		this.userId = userId;
		this.artworkId = artworkId;
	}

	@Override
	public String toString() {
		return "UserFavoriteArtwork [userId=" + userId + ", artworkId=" + artworkId + "]";
	}
	
	
	
}
