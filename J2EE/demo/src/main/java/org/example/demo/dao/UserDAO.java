package org.example.demo.dao;

import org.example.demo.model.User;
import org.example.demo.utility.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    public int registerUser(User user) throws SQLException, ClassNotFoundException {
        String INSERT = "INSERT INTO users (fname, lname, username, password) VALUES (?, ?, ?, ?)";

        int result = 0;

        Connection connection = SQLConnection.getConnection();

        try (connection; PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {

            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());

            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        return result;
    }
}
