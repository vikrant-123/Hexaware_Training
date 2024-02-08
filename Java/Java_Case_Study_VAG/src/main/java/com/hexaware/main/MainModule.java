package com.hexaware.main;

import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.ArtworkDAO;
import com.hexaware.dao.ArtworkDAOImpl;
import com.hexaware.dao.UserDAO;
import com.hexaware.dao.UserDAOImpl;
import com.hexaware.exception.ArtWorkNotFoundException;
import com.hexaware.exception.UserNotFoundException;
import com.hexaware.model.Artwork;
/**
 * MainModule class for demonstrating the functionalities of the
 * Virtual Art Gallery application.
 * This class contains methods to showcase menu-driven operations 
 * and interact with the database.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public class MainModule {


    private static ArtworkDAO artworkDAO = new ArtworkDAOImpl();
    private static UserDAO userDAO = new UserDAOImpl(); 
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        try {	
        	int choice;
        	do {
                System.out.println("\n==== Virtual Art Gallery Menu ====");
                System.out.println("1. Add Artwork");
                System.out.println("2. Update Artwork");
                System.out.println("3. Remove Artwork");
                System.out.println("4. Display Artwork Details");
                System.out.println("5. Search Artworks");
                System.out.println("6. Add Artwork to Favorites");
                System.out.println("7. Remove Artwork from Favorites");
                System.out.println("8. Display User's Favorite Artworks");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        addArtwork();
                        break;
                    case 2:
                    	updateArtwork();
                        break;
                    case 3:
                        removeArtwork();
                        break;
                    case 4:
                        displayArtworkDetails();
                        break;
                    case 5:
                        searchArtworks();
                        break;
                    case 6:
                        addArtworkToFavorites();
                        break;
                    case 7:
                        removeArtworkFromFavorites();
                        break;
                    case 8:
                        displayUserFavoriteArtworks();
                        break;
                    case 9:
                        System.out.println("Exiting the Virtual Art Gallery. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }

            } while(choice!=9);
        }finally {
        	scanner.close();
        }
}
    

    private static void addArtwork() {
        
        System.out.print("Enter Artwork ID: ");
        int artworkId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Artwork Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Artwork Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Artwork Creation Date (YYYY-MM-DD): ");
        String creationDateStr = scanner.nextLine();

        System.out.print("Enter Artwork Medium: ");
        String medium = scanner.nextLine();

        System.out.print("Enter Artwork Image URL: ");
        String imageURL = scanner.nextLine();
        
        System.out.print("Enter new Artist ID: ");
        int artistId = scanner.nextInt();
        scanner.nextLine();

        try {
            // Parse the date directly in the method
            java.sql.Date creationDate = java.sql.Date.valueOf(creationDateStr);

            Artwork artwork = new Artwork(artworkId, title, description, creationDate, medium, imageURL, artistId);
            boolean success = artworkDAO.addArtwork(artwork);

            if (success) {
                System.out.println("Artwork added successfully!");
            } else {
                System.out.println("Failed to add artwork.");
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    private static void updateArtwork() {

        System.out.print("Enter Artwork ID to update: ");
        int artworkId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        try {
            Artwork existingArtwork = artworkDAO.getArtworkById(artworkId);

            if (existingArtwork != null) {
                System.out.print("Enter new Artwork Title: ");
                String title = scanner.nextLine();

                System.out.print("Enter new Artwork Description: ");
                String description = scanner.nextLine();

                System.out.print("Enter new Artwork Creation Date (YYYY-MM-DD): ");
                String creationDateStr = scanner.nextLine();

                System.out.print("Enter new Artwork Medium: ");
                String medium = scanner.nextLine();

                System.out.print("Enter new Artwork Image URL: ");
                String imageURL = scanner.nextLine();
                System.out.print("Enter new Artist ID: ");
                int artistId = scanner.nextInt();
                scanner.nextLine();

                // Parse the date directly in the method
                java.sql.Date creationDate = java.sql.Date.valueOf(creationDateStr);

                Artwork updatedArtwork = new Artwork(
                        artworkId, title, description,
                        creationDate, medium, imageURL,
                        artistId);

                boolean success = artworkDAO.updateArtwork(updatedArtwork);

                if (success) {
                    System.out.println("Artwork updated successfully!");
                } else {
                    System.out.println("Failed to update artwork.");
                }

            } else {
                throw new ArtWorkNotFoundException("Artwork with ID " + artworkId + " not found.");
            }

        } catch (ArtWorkNotFoundException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    private static void removeArtwork() {

        System.out.print("Enter Artwork ID to remove: ");
        int artworkId = scanner.nextInt();

        try {
            boolean success = artworkDAO.removeArtwork(artworkId);

            if (success) {
                System.out.println("Artwork removed successfully!");
            } else {
                throw new ArtWorkNotFoundException("Artwork with ID " + artworkId + " not found.");
            }

        } catch (ArtWorkNotFoundException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    private static void displayArtworkDetails() {

        System.out.print("Enter Artwork ID: ");
        int artworkId = scanner.nextInt();
        scanner.nextLine();

        try {
            Artwork artwork = artworkDAO.getArtworkById(artworkId);

            if (artwork != null) {
                System.out.println("Artwork Details:");
                System.out.println(artwork);
            } else {
                throw new ArtWorkNotFoundException("Artwork with ID " + artworkId + " not found.");
            }

        } catch (ArtWorkNotFoundException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    private static void searchArtworks() {

        System.out.println("Enter keyword to search artworks: ");
        String keyword = scanner.nextLine();

        try {
            List<Artwork> artworks = artworkDAO.searchArtworks(keyword);

            if (!artworks.isEmpty()) {
                System.out.println("Search Results:");
                for (Artwork artwork : artworks) {
                    System.out.println(artwork);
                }
            } else {
                System.out.println("No artworks found with the given keyword.");
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    private static void addArtworkToFavorites() {

        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();

        System.out.print("Enter Artwork ID to add to favorites: ");
        int artworkId = scanner.nextInt();

        try {
            boolean success = userDAO.addArtworkToFavorite(userId, artworkId);

            if (success) {
                System.out.println("Artwork added to favorites successfully!");
            } else {
                throw new UserNotFoundException("User with ID " + userId + " not found.");
            }

        } catch (UserNotFoundException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    private static void removeArtworkFromFavorites() {

        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();

        System.out.print("Enter Artwork ID to remove from favorites: ");
        int artworkId = scanner.nextInt();

        try {
            boolean success = userDAO.removeArtworkFromFavorite(userId, artworkId);

            if (success) {
                System.out.println("Artwork removed from favorites successfully!");
            } else {
                throw new UserNotFoundException("User with ID " + userId + " not found.");
            }

        } catch (UserNotFoundException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    private static void displayUserFavoriteArtworks() {

        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();

        try {
            List<Artwork> favoriteArtworks = userDAO.getUserFavoriteArtworks(userId);

            if (!favoriteArtworks.isEmpty()) {
                System.out.println("User's Favorite Artworks:");
                for (Artwork artwork : favoriteArtworks) {
                    System.out.println(artwork);
                }
            } else {
                throw new UserNotFoundException("User with ID " + userId + " has no favorite artworks.");
            }

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}