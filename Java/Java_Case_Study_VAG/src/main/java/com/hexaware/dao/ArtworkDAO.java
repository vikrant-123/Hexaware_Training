package com.hexaware.dao;

import java.util.List;

import com.hexaware.model.Artwork;
/**
 * Interface for accessing and managing artwork-related data in 
 * the Virtual Art Gallery database.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public interface ArtworkDAO {

    boolean addArtwork(Artwork artwork);

    boolean updateArtwork(Artwork artwork);

    boolean removeArtwork(int artworkID);

    Artwork getArtworkById(int artworkID);

    List<Artwork> searchArtworks(String keyword);
}
