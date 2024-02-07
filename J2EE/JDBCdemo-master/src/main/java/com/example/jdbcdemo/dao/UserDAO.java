package com.example.jdbcdemo.dao;

import com.example.jdbcdemo.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    public int insert(User user) throws SQLException;
    public int update(User user) throws SQLException;
    public int delete(int userId) throws SQLException;
    public int select(int userId) throws SQLException;
    public List<User> select() throws SQLException;

}
