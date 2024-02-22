package org.example.demo.dao;

import org.example.demo.model.LoginBean;
import org.example.demo.utility.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public boolean validate(LoginBean bean) throws ClassNotFoundException, SQLException {
        boolean status = false;

        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "select * from users where username = ? and password = ? ";

        try (Connection connection = SQLConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, bean.getUsername());
            preparedStatement.setString(2, bean.getPassword());

            ResultSet rs = preparedStatement.executeQuery();

            status = rs.next();


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return status;
    }
}
