package org.example.scriptsavings.dao;

import org.example.scriptsavings.model.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatementDao {
    private Connection conn;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public StatementDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean insertTransaction(Statement model) {
        boolean result = false;
        try {
            query = "insert into statement (name, amount, categoryId, userId) values(?,?,?,?)";
            preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setDouble(2, model.getAmount());
            preparedStatement.setInt(3, model.getCategoryId());
            preparedStatement.setInt(4, model.getUserId());
            preparedStatement.executeUpdate();

            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


}
