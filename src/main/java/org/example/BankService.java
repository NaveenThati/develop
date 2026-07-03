package org.example;

import java.util.Collection;

public class BankService {

    private BankRepository repository;

    // Constructor Injection
    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    // Create New Account
    public void createAccount(Account account) {
        repository.addAccount(account);
    }

    // Get Account
    public Account getAccount(long accountNumber) throws InvalidAccountException {

        Account account = repository.getAccount(accountNumber);

        if (account == null) {
            throw new InvalidAccountException(
                    "Account Number " + accountNumber + " not found."
            );
        }

        return account;
    }

    // Deposit Money
    public void deposit(long accountNumber, double amount)
            throws InvalidAccountException {

        Account account = getAccount(accountNumber);

        account.setBalance(account.getBalance() + amount);
    }

    // Withdraw Money
    public void withdraw(long accountNumber, double amount)
            throws InvalidAccountException {

        Account account = getAccount(accountNumber);

        account.setBalance(account.getBalance() - amount);
    }

    // Check Balance
    public double checkBalance(long accountNumber)
            throws InvalidAccountException {

        return getAccount(accountNumber).getBalance();
    }

    // View All Accounts
    public Collection<Account> getAllAccounts() {
        return repository.getAllAccounts();
    }
}