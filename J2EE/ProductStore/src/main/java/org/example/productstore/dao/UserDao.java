package org.example.productstore.dao;

import org.example.productstore.modal.User;
import org.example.productstore.utility.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public int registerUser(User user) throws SQLException, ClassNotFoundException {
        String INSERT = "INSERT INTO users (fname, lname, username, password) VALUES (?, ?, ?, ?)";

        int result = 0;

        Connection connection = SqlConnection.getConnection();

        try (connection; PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {

            preparedStatement.setString(1, user.getfName());
            preparedStatement.setString(2, user.getlName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());

            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        return result;
    }
}
