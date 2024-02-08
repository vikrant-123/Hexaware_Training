package com.hexaware.controller;

import java.util.List;

import com.hexaware.model.Artwork;
/**
 * Interface for controlling operations in the Virtual Art Gallery.
 * Defines methods for managing artworks, user favorites.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public interface IVirtualArtGallery {
    // Artwork Management
    boolean addArtwork(Artwork artwork);
    boolean updateArtwork(Artwork artwork);
    boolean removeArtwork(int artworkID);
    Artwork getArtworkById(int artworkID);
    List<Artwork> searchArtworks(String keyword);

    // User Favorites
    boolean addArtworkToFavorite(int userId, int artworkId);
    boolean removeArtworkFromFavorite(int userId, int artworkId);
    List<Artwork> getUserFavoriteArtworks(int userId);
}
