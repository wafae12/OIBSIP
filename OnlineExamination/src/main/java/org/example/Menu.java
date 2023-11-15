package org.example;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.Main.main;

public class Menu {

    public static void menu(String username, String password) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Online examination menu: ");
            System.out.println("1: Update profile and password");
            System.out.println("2: MCQs");
            System.out.println("3: Logout");
            System.out.println("Enter your choice: ");
            choice =scanner.nextInt();

            switch (choice){
                case 1:
                    UpdateProfile.UpdateProfile(username,password);
                    main(null);
                    break;
                case 2:
                    MCQ.MCQs(username);
                    break;
                case 3:
                    System.out.println("Logout");
                    main(null);
                    break;
            }
        }while(choice!=3);
    }
}
