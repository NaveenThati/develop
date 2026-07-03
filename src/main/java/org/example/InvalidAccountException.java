package org.example;

public class InvalidAccountException extends Exception {

    // Default Constructor
    public InvalidAccountException() {
        super("Invalid Account. Please enter a valid account number.");
    }

    // Parameterized Constructor
    public InvalidAccountException(String message) {
        super(message);
    }
}