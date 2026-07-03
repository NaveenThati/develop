package org.example;

public class InsufficientBalanceException extends Exception {

    // Default Constructor
    public InsufficientBalanceException() {
        super("Insufficient balance. Transaction cannot be completed.");
    }

    // Parameterized Constructor
    public InsufficientBalanceException(String message) {
        super(message);
    }
}