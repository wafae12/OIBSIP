package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineexamination";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";

    public static boolean verifyLogin(String username, String password) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {
            String sql = "SELECT password FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("password");
                        return password.equals(storedPassword);
                    }
                }
            }
        }

        return false;

    }

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcomme to Online examination app!");

        System.out.println("Login");


        //Login
        while (true) {
            System.out.println("Enter your username: ");
            String username = scanner.next();
            System.out.println("Enter your password: ");
            String password = scanner.next();

            if (verifyLogin(username, password)) {
                System.out.println("Login successful!");
                Menu.menu(username, password);
                break;
            } else {
                System.out.println("Invalid username or password. Login failed.");
            }

        }
    }
}