package org.example;

public class Validation {

    // Check Amount
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    // Check Same Account
    public static boolean isSameAccount(long fromAccount, long toAccount) {
        return fromAccount == toAccount;
    }

    // Check Account Exists
    public static boolean isAccountExists(Account account) {
        return account != null;
    }

    // Check Balance
    public static boolean hasSufficientBalance(Account account, double amount) {
        return account.getBalance() >= amount;
    }
}