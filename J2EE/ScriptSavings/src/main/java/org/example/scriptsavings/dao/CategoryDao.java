package org.example.scriptsavings.dao;

import org.example.scriptsavings.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private Connection conn;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CategoryDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try {
            query = "select * from category";
            preparedStatement = this.conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Category row = new Category();
                row.setId(resultSet.getInt("Id"));
                row.setName(resultSet.getString("name"));

                categories.add(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
