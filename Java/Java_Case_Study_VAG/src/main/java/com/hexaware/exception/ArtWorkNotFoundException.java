package com.hexaware.exception;
/**
 * Custom exception class to indicate that a user was not found.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public class ArtWorkNotFoundException extends Exception {

    public ArtWorkNotFoundException(String message) {
        super(message);
    }
}