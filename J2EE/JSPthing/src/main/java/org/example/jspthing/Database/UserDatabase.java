package org.example.jspthing.Database;

import org.example.jspthing.dao.UserDAO;
import org.example.jspthing.model.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.jspthing.Database.MySQLConnection.*;

public class UserDatabase implements UserDAO {

    private static final String SQL_SELECT = "select userID, userName, userCity from user";
    private static final String SQL_SELECT_SINGLE = "select userID, userName, userCity from user where userID = ?";
    private static final String SQL_INSERT = "insert into user(userID, userName, userCity) values (?, ?, ?)";
    private static final String SQL_UPDATE = "update user set userName = ?, userCity = ? where userID = ?)";

    @Override
    public int insert(user user) throws SQLException {
        return 0;
    }

    @Override
    public int update(user user) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int userID) throws SQLException {
        return 0;
    }

    @Override
    public int select(user user) throws SQLException {
        return 0;
    }

    @Override
    public List<user> select() throws SQLException {
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resSet = null;

        List<user> users = new ArrayList<>();

        try{
            conn = getConnection();
            preStatement = conn.prepareStatement(SQL_SELECT);
            resSet = preStatement.executeQuery();

            while (resSet.next()) {
                users.add(new user(
                        resSet.getInt("userID"),
                        resSet.getString("userName"),
                        resSet.getString("userCity")
                        )
                );

            }

        } catch (SQLSyntaxErrorException ex){
            System.out.println("error: " + ex.getMessage());
        }
        return null;
    }
}
