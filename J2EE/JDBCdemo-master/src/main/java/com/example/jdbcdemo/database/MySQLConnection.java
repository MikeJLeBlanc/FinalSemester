package com.example.jdbcdemo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static String url = "jdbc:mysql://localhost/sql";
    private static String uname = "root";
    private static String pass = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,uname,pass);
    }

}
