package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CreateAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private String user_id;

    private int pin;

    private double balance;

    private List<Transaction> transactions;

    public CreateAccount(String user_id, int pin, double balance) {
        this.user_id = user_id;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getUser_id() {
        return user_id;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void diposit(double amount){
        balance+=amount;
        transactions.add(new Transaction("Deposit", amount));
        updateAccountData();
    }

    public boolean withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            transactions.add(new Transaction("Withdrawal", -amount));
            updateAccountData();
            return true;
        }else return false;
    }
    private void updateAccountData() {
        AccountData.saveAccount(this);
    }
}
