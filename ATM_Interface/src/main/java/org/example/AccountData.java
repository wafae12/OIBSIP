package org.example;

import java.io.*;

public class AccountData {
    private static final String DATA_DIR = "account_data/";
    public static void saveAccount(CreateAccount account) {
        String filePath = DATA_DIR + account.getUser_id()+"_data.txt";
        File directory = new File(DATA_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(account);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CreateAccount loadAccount(String username) {
        String filePath = DATA_DIR + username + "_data.txt";
        CreateAccount account = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            account = (CreateAccount) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Account data not found.");
        }
        return account;
    }
    public static void saveTransactionHistory(CreateAccount account) {
        String filePath = DATA_DIR + account.getUser_id() + "_transactions.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            for (Transaction transaction : account.getTransactions()) {
                writer.println(transaction.getDescription() + ": MAD" + transaction.getAmount());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
