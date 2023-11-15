package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class UpdateProfile {

    public static void UpdateProfile(String username,String password) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Update your profile and password : ");
        int ch;

        do{
            System.out.println("1: Update your username");
            System.out.println("2: Update your password");
            System.out.println("3: Cancel");
            System.out.println("Enter you choice : ");
            ch = scanner.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Enter your current password: ");
                    String oldpass = scanner.next();
                    if(Objects.equals(oldpass, password)) {
                        System.out.println("Enter your new username: ");
                        String userName = scanner.next();
                        updateData(userName,password);
                    }
                    break;
                case 2:
                    System.out.println("Enter your current password: ");
                     oldpass = scanner.next();
                    if(Objects.equals(oldpass, password)){
                        System.out.println("Enter your new password: ");
                        String pass = scanner.next();
                        changePass(password,pass);
                        break;
                    }

            }
        }while(ch!=3);



}

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/onlineexamination";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void updateData(String name, String password) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {

                String updateQuery = "UPDATE users SET username = ? WHERE password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, password);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Data updated successfully!");
                    } else {
                        System.out.println("Failed to update data.");
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changePass(String oldpass, String newPass) {

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {

            String updateQuery = "UPDATE users SET password = ? WHERE password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1,newPass );
                preparedStatement.setString(2, oldpass);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data updated successfully!");
                } else {
                    System.out.println("Failed to update data.");
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
