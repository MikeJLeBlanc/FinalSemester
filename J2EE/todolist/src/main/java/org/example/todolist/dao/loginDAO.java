package org.example.todolist.dao;

import org.example.todolist.model.LoginBean;
import org.example.todolist.utility.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDAO {
    public boolean validate(LoginBean bean) throws ClassNotFoundException, SQLException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.driver");
        String sql = "select * from users where username = ? and password = ? ";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = SQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bean.getUsername());
            preparedStatement.setString(2, bean.getPassword());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        }

        return status;
    }

}
