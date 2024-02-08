package com.hexaware.exception;
/**
 * Custom exception class to indicate that an artwork was not found.
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }
}
