package com.example.jdbcdemo;

import java.sql.*;

public class JDBC {

    // Main driver method
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://localhost/sql";
        String uname = "root";
        String pass = "";

        String query = "select * from login";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con  = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String name = rs.getString("FirstName");

        System.out.println(name);

        st.close();

        con.close();
    }
}
