package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/onlineexamination";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void saveAnswers(String username, int choiceQ1, int choiceQ2, int choiceQ3) {
        try {

            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "INSERT INTO usersanswers (username, question_1, question_2, question_3) VALUES (?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setInt(2, choiceQ1);
                statement.setInt(3, choiceQ2);
                statement.setInt(4, choiceQ3);

                statement.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
