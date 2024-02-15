package com.example.jdbcdemo.database;

import com.example.jdbcdemo.dao.UserDAO;
import com.example.jdbcdemo.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.example.jdbcdemo.database.MySQLConnection.*;

public class UserDatabase implements UserDAO {

    private static final String SQL_SELECT = "SELECT userId, userName, userCity FROM USER";
    private static final String SQL_SELECT_ONE = "SELECT userId, userName, userCity FROM USER WHERE userId = ?";
    private static final String SQL_INSERT = "INSERT INTO USER(userId, userName, userCity) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE USER SET userName=?, userCity=? WHERE userId = ?";
    private static final String SQL_DELETE = "DELETE FROM USER WHERE userId = ?";



    @Override
    public int insert(User user) throws SQLException {
        if (user.getUserName() == null || user.getUserCity() == null) {
            return 0;
        }

        Connection conn = null;
        PreparedStatement pStatement = null;
        int rs = 0;

        try {
            conn = getConnection();
            pStatement = conn.prepareStatement(SQL_INSERT);
            pStatement.setInt(1, user.getUserId());
            pStatement.setString(2, user.getUserName());
            pStatement.setString(3, user.getUserCity());

            rs = pStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            pStatement.close();
            conn.close();
        }

        return rs;
    }

    @Override
    public int update(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        int rs = 0;

        try {
            conn = getConnection();
            pStatement = conn.prepareStatement(SQL_UPDATE);
            pStatement.setInt(1, user.getUserId());
            pStatement.setString(2, user.getUserName());
            pStatement.setString(3, user.getUserCity());

            rs = pStatement.executeUpdate();
        } catch(SQLSyntaxErrorException ex) {
            System.out.println("error: " + ex.getMessage());
        } catch(Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            pStatement.close();
            conn.close();
        }

        return rs;
    }

    @Override
    public int delete(int userId) throws SQLException {
        return 0;
    }

    @Override
    public int select(int userId) throws SQLException {
        return 0;
    }

    @Override
    public List<User> select() throws SQLException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try{
            conn = getConnection();
            pStatement = conn.prepareStatement(SQL_SELECT);
            rs = pStatement.executeQuery();

            while (rs.next()){

                users.add(new User(
                rs.getInt("userId"),
                rs.getString("userName"),
                rs.getString("userCity")
               ));

            }

        }catch (Exception ex){
            System.out.println("Error:" + ex.getMessage());
        }



        return null;
    }
}
