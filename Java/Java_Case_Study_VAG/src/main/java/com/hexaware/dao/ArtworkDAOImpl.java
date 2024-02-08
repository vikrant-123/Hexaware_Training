package com.hexaware.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Artwork;
import com.hexaware.util.DBConnection;
/**
 * Implementation of the ArtworkDAO interface for interacting with the 
 * Virtual Art Gallery database.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public class ArtworkDAOImpl implements ArtworkDAO {

    private Connection connection;

    public ArtworkDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public boolean addArtwork(Artwork artwork) {
        String query = "INSERT INTO Artwork (Artwork_Id, Title, Description, Creation_Date, Medium, Image_URL, Artist_Id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        	st.setInt(1, artwork.getArtworkID());
        	st.setString(2, artwork.getTitle());
        	st.setString(3, artwork.getDescription());
        	st.setDate(4, new Date(artwork.getCreationDate().getTime()));
        	st.setString(5, artwork.getMedium());
        	st.setString(6, artwork.getImageURL());
        	st.setInt(7, artwork.getArtistId());
        	

            return st.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateArtwork(Artwork artwork) {
        String query = "UPDATE Artwork SET Title=?, Description=?, Creation_Date=?, Medium=?, Image_URL=?, Artist_Id=? WHERE Artwork_ID=?";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        	st.setString(1, artwork.getTitle());
        	st.setString(2, artwork.getDescription());
        	st.setDate(3, new Date(artwork.getCreationDate().getTime()));
        	st.setString(4, artwork.getMedium());
        	st.setString(5, artwork.getImageURL());
        	st.setInt(6, artwork.getArtistId());
        	st.setInt(7, artwork.getArtworkID());
        	

            return st.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeArtwork(int artworkID) {
        String query = "DELETE FROM Artwork WHERE Artwork_ID=?";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        	st.setInt(1, artworkID);

            return st.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Artwork getArtworkById(int artworkID) {
        String query = "SELECT * FROM Artwork WHERE Artwork_ID=?";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        	st.setInt(1, artworkID);

            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                return createArtworkFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Artwork> searchArtworks(String keyword) {
        List<Artwork> artworks = new ArrayList<>();
        String query = "SELECT * FROM Artwork WHERE Title LIKE ? OR Description LIKE ?";

        try (PreparedStatement st = connection.prepareStatement(query)) {
            String searchKeyword = "%" + keyword + "%";
            st.setString(1, searchKeyword);
            st.setString(2, searchKeyword);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                artworks.add(createArtworkFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artworks;
    }

    private Artwork createArtworkFromResultSet(ResultSet resultSet) throws SQLException {
        return new Artwork(
                resultSet.getInt("Artwork_ID"),
                resultSet.getString("Title"),
                resultSet.getString("Description"),
                resultSet.getDate("Creation_Date"),
                resultSet.getString("Medium"),
                resultSet.getString("Image_URL"),
                resultSet.getInt("Artist_ID")
        );
    }
}

