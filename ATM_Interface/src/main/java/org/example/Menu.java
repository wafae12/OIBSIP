package org.example;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void Menu_ATM(CreateAccount account) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Balance");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewTransactionHistory(account);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful. New balance: " + account.getBalance()+" MAD");
                    } else {
                        System.out.println("Insufficient funds or invalid amount. Withdrawal failed.");
                    }
                    break;
                case 3:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.diposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + account.getBalance()+" MAD");
                    break;
                case 4:
                    Transfer(account);
                    break;
                case 5:
                    System.out.println("Your balance: " + account.getBalance()+" MAD");
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private static void viewTransactionHistory(CreateAccount userAccount) {
        List<Transaction> transactions = userAccount.getTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getDescription() + ": $" + transaction.getAmount());
            }
            AccountData.saveTransactionHistory(userAccount);
        }
}

    private static void Transfer(CreateAccount senderAccount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the recipient's username: ");
        String recipientUsername = scanner.next();
        CreateAccount recipientAccount = AccountData.loadAccount(recipientUsername);
        if (recipientAccount != null) {
            System.out.print("Enter the transfer amount: $");
            double transferAmount = scanner.nextDouble();

            if (senderAccount.withdraw(transferAmount)) {
                recipientAccount.diposit(transferAmount);
                System.out.println("Transfer successful.");
                senderAccount.getTransactions().add(new Transaction("Transfer to "+recipientUsername, transferAmount));
            } else {
                System.out.println("Insufficient funds or invalid amount. Transfer failed.");
            }
        } else {
            System.out.println("Recipient account not found. Transfer failed.");
        }
    }

}
