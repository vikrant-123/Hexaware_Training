package com.hexaware.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Artwork;
import com.hexaware.util.DBConnection;
/**
 * Implementation of the UserDAO interface for interacting with 
 * the Virtual Art Gallery database.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public class UserDAOImpl implements UserDAO {

    private Connection connection;

    public UserDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public boolean addArtworkToFavorite(int userId, int artworkId) {
        String query = "INSERT INTO user_favourite_artwork (UserID, Artwork_ID) VALUES (?, ?)";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        	st.setInt(1, userId);
        	st.setInt(2, artworkId);

            return st.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeArtworkFromFavorite(int userId, int artworkId) {
        String query = "DELETE FROM user_favourite_artwork WHERE UserID=? AND Artwork_ID=?";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        	st.setInt(1, userId);
            st.setInt(2, artworkId);

            return st.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Artwork> getUserFavoriteArtworks(int userId) {
        List<Artwork> favoriteArtworks = new ArrayList<>();
        String query = "SELECT * FROM Artwork A INNER JOIN User_Favourite_Artwork UFA ON A.Artwork_ID = UFA.Artwork_ID WHERE UFA.UserID=?";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        	st.setInt(1, userId);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                favoriteArtworks.add(createArtworkFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return favoriteArtworks;
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

