package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankRepository repository = new BankRepository();
        BankService bankService = new BankService(repository);
        TransferService transferService = new TransferService(bankService, repository);

        while (true) {

            System.out.println("\n========== BANK TRANSFER SYSTEM ==========");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer Money");
            System.out.println("6. View All Accounts");
            System.out.println("7. View Transaction History");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice : ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter Account Number : ");
                        long accNo = sc.nextLong();
                        sc.nextLine();

                        System.out.print("Enter Account Holder Name : ");
                        String name = sc.nextLine();

                        System.out.print("Enter Initial Balance : ");
                        double balance = sc.nextDouble();

                        Account account = new Account(accNo, name, balance);

                        bankService.createAccount(account);

                        System.out.println("✅ Account Created Successfully.");

                        break;

                    case 2:

                        System.out.print("Enter Account Number : ");
                        accNo = sc.nextLong();

                        System.out.print("Enter Deposit Amount : ");
                        double deposit = sc.nextDouble();

                        bankService.deposit(accNo, deposit);

                        System.out.println("✅ Amount Deposited Successfully.");

                        break;

                    case 3:

                        System.out.print("Enter Account Number : ");
                        accNo = sc.nextLong();

                        System.out.print("Enter Withdraw Amount : ");
                        double withdraw = sc.nextDouble();

                        bankService.withdraw(accNo, withdraw);

                        System.out.println("✅ Amount Withdrawn Successfully.");

                        break;

                    case 4:

                        System.out.print("Enter Account Number : ");
                        accNo = sc.nextLong();

                        System.out.println("Available Balance : "
                                + bankService.checkBalance(accNo));

                        break;

                    case 5:

                        System.out.print("From Account : ");
                        long from = sc.nextLong();

                        System.out.print("To Account : ");
                        long to = sc.nextLong();

                        System.out.print("Amount : ");
                        double amount = sc.nextDouble();

                        Transaction transaction =
                                transferService.transferMoney(from, to, amount);

                        System.out.println("\n===== Transfer Successful =====");
                        System.out.println(transaction);

                        break;

                    case 6:

                        System.out.println("\n===== All Accounts =====");

                        for (Account a : bankService.getAllAccounts()) {
                            System.out.println(a);
                        }

                        break;

                    case 7:

                        System.out.println("\n===== Transaction History =====");

                        for (Transaction t : repository.getAllTransactions()) {
                            System.out.println(t);
                        }

                        break;

                    case 8:

                        System.out.println("Thank You...");
                        System.exit(0);

                    default:

                        System.out.println("Invalid Choice.");

                }

            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

        }

    }

}