package org.example.todolist.dao;

import org.example.todolist.model.User;
import org.example.todolist.utility.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO
{
    public int registerUser(User user) throws SQLException {
        String INSERT = "INSERT INTO users (firstname, lastname, username, passHash) VALUES (?, ?, ?, ?)";

        int result = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try
        {
            connection = SQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(INSERT);

            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassHash());

            result = preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("error: " + e.getMessage());
        }
        finally
        {
            connection.close();
            preparedStatement.close();

        }
        return result;
    }
}
