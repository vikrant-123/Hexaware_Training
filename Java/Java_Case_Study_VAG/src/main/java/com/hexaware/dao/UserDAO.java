package com.hexaware.dao;

import java.util.List;

import com.hexaware.model.Artwork;
/**
 * Interface for accessing and managing user-related data 
 * in the Virtual Art Gallery database.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public interface UserDAO {

    boolean addArtworkToFavorite(int userId, int artworkId);

    boolean removeArtworkFromFavorite(int userId, int artworkId);

    List<Artwork> getUserFavoriteArtworks(int userId);
}
