package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    // Instance Variables
    private String transactionId;
    private String utrId;
    private long fromAccount;
    private long toAccount;
    private double amount;
    private LocalDateTime transactionDateTime;
    private String status;

    // Default Constructor
    public Transaction() {

    }

    // Parameterized Constructor
    public Transaction(String transactionId,
                       String utrId,
                       long fromAccount,
                       long toAccount,
                       double amount,
                       LocalDateTime transactionDateTime,
                       String status) {

        this.transactionId = transactionId;
        this.utrId = utrId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.transactionDateTime = transactionDateTime;
        this.status = status;
    }

    // Getter Methods
    public String getTransactionId() {
        return transactionId;
    }

    public String getUtrId() {
        return utrId;
    }

    public long getFromAccount() {
        return fromAccount;
    }

    public long getToAccount() {
        return toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public String getStatus() {
        return status;
    }

    // Setter Methods
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setUtrId(String utrId) {
        this.utrId = utrId;
    }

    public void setFromAccount(long fromAccount) {
        this.fromAccount = fromAccount;
    }

    public void setToAccount(long toAccount) {
        this.toAccount = toAccount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString()
    @Override
    public String toString() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");

        return "\n==========================================" +
                "\n         TRANSACTION RECEIPT" +
                "\n==========================================" +
                "\nTransaction ID : " + transactionId +
                "\nUTR ID         : " + utrId +
                "\nFrom Account   : " + fromAccount +
                "\nTo Account     : " + toAccount +
                "\nAmount         : ₹" + amount +
                "\nDate & Time    : " + transactionDateTime.format(formatter) +
                "\nStatus         : " + status +
                "\n==========================================";
    }
}