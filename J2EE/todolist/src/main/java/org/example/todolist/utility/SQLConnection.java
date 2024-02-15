package org.example.todolist.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection
{
    private static final String url = "jdbc:mysql://localhost/sql";
    private static final String uname = "root";
    private static final String pass = "";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url,uname,pass);
    }
}
