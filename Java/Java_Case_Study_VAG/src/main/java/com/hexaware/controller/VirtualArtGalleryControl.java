package com.hexaware.controller;

import java.util.List;

import com.hexaware.dao.ArtworkDAO;
import com.hexaware.dao.UserDAO;
import com.hexaware.model.Artwork;
/**
 * Implementation of the IVirtualArtGalleryControl interface.
 * Manages operations in the Virtual Art Gallery.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public class VirtualArtGalleryControl implements IVirtualArtGallery {
	private final ArtworkDAO artworkDAO;
    private final UserDAO userDAO;
    
    
    public VirtualArtGalleryControl(ArtworkDAO artworkDAO, UserDAO userDAO) {
        this.artworkDAO = artworkDAO;
        this.userDAO = userDAO;
    }

    @Override
    public boolean addArtwork(Artwork artwork) {
        return artworkDAO.addArtwork(artwork);
    }

    @Override
    public boolean updateArtwork(Artwork artwork) {
        return artworkDAO.updateArtwork(artwork);
    }

    @Override
    public boolean removeArtwork(int artworkID) {
        return artworkDAO.removeArtwork(artworkID);
    }

    @Override
    public Artwork getArtworkById(int artworkID) {
        return artworkDAO.getArtworkById(artworkID);
    }

    @Override
    public List<Artwork> searchArtworks(String keyword) {
        return artworkDAO.searchArtworks(keyword);
    }

    @Override
    public boolean addArtworkToFavorite(int userId, int artworkId) {
        return userDAO.addArtworkToFavorite(userId, artworkId);
    }

    @Override
    public boolean removeArtworkFromFavorite(int userId, int artworkId) {
        return userDAO.removeArtworkFromFavorite(userId, artworkId);
    }

    @Override
    public List<Artwork> getUserFavoriteArtworks(int userId) {
        return userDAO.getUserFavoriteArtworks(userId);
    }
}