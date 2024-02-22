package org.example.demo.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    private static final String url = "jdbc:mysql://localhost:3306/coffeelist";
    private static final String uname = "root";
    private static final String pass = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,uname,pass);
    }
}
