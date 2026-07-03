package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankRepository {

    private Map<Long, Account> accounts = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(long accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean accountExists(long accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public void removeAccount(long accountNumber) {
        accounts.remove(accountNumber);
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public void saveTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}