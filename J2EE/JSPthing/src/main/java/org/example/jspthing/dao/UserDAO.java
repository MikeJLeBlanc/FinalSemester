package org.example.jspthing.dao;

import org.example.jspthing.model.user;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    int insert(user user) throws SQLException;
    int update(user user) throws SQLException;
    int delete(int userID) throws SQLException;
    int select(user user) throws SQLException;
    List<user> select() throws SQLException;
}
