package org.example.jspthing;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://localhost/test";
        String uname = "root";
        String pass = "";

        String query = "select * from login";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(url, uname, pass);
        Statement stment = conn.createStatement();
        ResultSet rsSet = stment.executeQuery(query);

        while (rsSet.next()) {
            String name = rsSet.getString("FirstName");

            System.out.println(name);
        }

        stment.close();

        conn.close();
    }
}
