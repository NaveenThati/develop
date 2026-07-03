package org.example;

import java.time.LocalDateTime;

public class TransferService {

    private BankService bankService;
    private BankRepository repository;

    public TransferService(BankService bankService,
                           BankRepository repository) {

        this.bankService = bankService;
        this.repository = repository;
    }

    public Transaction transferMoney(long fromAccountNumber,
                                     long toAccountNumber,
                                     double amount)
            throws InvalidAccountException,
            InsufficientBalanceException {

        // Get Accounts
        Account fromAccount = bankService.getAccount(fromAccountNumber);
        Account toAccount = bankService.getAccount(toAccountNumber);

        // Same Account Validation
        if (Validation.isSameAccount(fromAccountNumber, toAccountNumber)) {
            throw new IllegalArgumentException(
                    "From Account and To Account cannot be same.");
        }

        // Amount Validation
        if (!Validation.isValidAmount(amount)) {
            throw new IllegalArgumentException(
                    "Transfer amount must be greater than zero.");
        }

        // Balance Validation
        if (!Validation.hasSufficientBalance(fromAccount, amount)) {
            throw new InsufficientBalanceException(
                    "Available Balance : "
                            + fromAccount.getBalance()
                            + ", Transfer Amount : "
                            + amount
            );
        }

        // Debit
        fromAccount.setBalance(fromAccount.getBalance() - amount);

        // Credit
        toAccount.setBalance(toAccount.getBalance() + amount);

        // Create Transaction
        Transaction transaction = new Transaction();

        transaction.setTransactionId(
                "TXN" + System.currentTimeMillis());

        transaction.setUtrId(
                UTRGenerator.generateUTR());

        transaction.setFromAccount(fromAccountNumber);

        transaction.setToAccount(toAccountNumber);

        transaction.setAmount(amount);

        transaction.setTransactionDateTime(
                LocalDateTime.now());

        transaction.setStatus("SUCCESS");

        // Save Transaction
        repository.saveTransaction(transaction);

        return transaction;
    }
}