package com.hexaware.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hexaware.dao.ArtworkDAO;
import com.hexaware.dao.ArtworkDAOImpl;
import com.hexaware.model.Artwork;
import com.hexaware.util.DBConnection;

public class ArtworkDAOImplTest {

	private static Connection connection;
	private static ArtworkDAO artworkDAO;

	@BeforeClass
	public static void setUp() throws SQLException {
		connection = DBConnection.getConnection();
		artworkDAO = new ArtworkDAOImpl();
	}

	@Test
	public void testAddArtwork() {
		Artwork artworkToAdd = new Artwork(6, "Test Artwork", "Test Description", new Date(System.currentTimeMillis()),
				"Test Medium", "test_image_url", 1);

		boolean isAdded = artworkDAO.addArtwork(artworkToAdd);

		assertEquals(true, isAdded);
	}

	@Test
	public void testUpdateArtwork() {

		Artwork artworkToUpdate = new Artwork(1, "Updated Artwork1", "Updated Test Description",
				new Date(System.currentTimeMillis()), "Updated Test Medium", "updated_image_url", 2);

		boolean isUpdated = artworkDAO.updateArtwork(artworkToUpdate);

		assertEquals(true, isUpdated);
	}

	@Test
	public void testRemoveArtwork() {
		
		Artwork artworkToAdd = new Artwork(7, "Test Artwork", "Test Description", new Date(System.currentTimeMillis()),
				"Test Medium", "test_image_url", 1);
		boolean isAdded = artworkDAO.addArtwork(artworkToAdd);
		
		int artworkId = 7;
		boolean isRemoved = artworkDAO.removeArtwork(artworkId);
		assertEquals(isAdded, isRemoved);
	}

	@Test
	public void testGetArtworkById() {
		int artworkIdToRetrieve = 1;

		Artwork retrievedArtwork = artworkDAO.getArtworkById(artworkIdToRetrieve);

		assertNotNull(retrievedArtwork);

	}

	@Test
	public void testSearchArtworks() {
		String keyword = "fam";

		List<Artwork> searchResults = artworkDAO.searchArtworks(keyword);

		assertEquals(false, searchResults.isEmpty());

	}

	@AfterClass
	public static void tearDown() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
}
