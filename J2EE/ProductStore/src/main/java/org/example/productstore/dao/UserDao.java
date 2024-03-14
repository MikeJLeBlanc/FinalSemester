package org.example.productstore.dao;

import org.example.productstore.modal.User;

import java.sql.*;

public class UserDao {
	private final Connection conn;

    public UserDao(Connection con) {
		this.conn = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
        try {
            String query = "select * from users where email=? and pass=?";
            PreparedStatement pst = this.conn.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
}
