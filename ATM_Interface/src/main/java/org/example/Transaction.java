package org.example;

import java.io.Serializable;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

}
