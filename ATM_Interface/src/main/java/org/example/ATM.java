package org.example;


import java.util.Scanner;

import static org.example.Menu.Menu_ATM;

public class ATM {

    public static void main(String[] args) {

        System.out.println("Welcome to ATM interface!");

        Scanner scanner=new Scanner(System.in);

        System.out.println(" 1 : Login");
        System.out.println(" 2 : Create account");
        System.out.println("Enter 1 if you have already a account, if not Enter 2 to create one.");
        System.out.println("Please enter : ");

        int input = scanner.nextInt();

        while (input!=1 && input!=2){

            System.out.println("Please enter : ");
            input=scanner.nextInt();
        }

        if(input==1) {

            System.out.println("Please enter your username: ");
            String username= scanner.next();
            System.out.println("Please enter your pin: ");
            int pin= scanner.nextInt();

            CreateAccount account = AccountData.loadAccount(username);

            if (account != null && account.getPin() == pin) {
                System.out.println("Login successful!");


                Menu_ATM(account);

            } else {
                System.out.println("Login failed. Invalid username or pin.");
            }

        }else if (input==2){

            System.out.println("Please enter your username: ");
            String username= scanner.next();
            System.out.println("Please enter your pin: ");
            int pin= scanner.nextInt();
            System.out.println("Please enter your balance: ");
            double balance= scanner.nextDouble();

            CreateAccount newAccount = new CreateAccount(username, pin, balance);
            AccountData.saveAccount(newAccount);
            System.out.println("Account created successfully!");

            Menu_ATM(newAccount);

        }

    }
}