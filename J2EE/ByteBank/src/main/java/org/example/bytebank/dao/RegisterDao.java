package org.example.bytebank.dao;

import org.example.bytebank.model.Customer;
import org.example.bytebank.model.Increpete_Decrepete;
import org.example.bytebank.model.Logins;
import org.example.bytebank.utility.SqlConnection;

import java.sql.*;
public class RegisterDao {
	Increpete_Decrepete in1=new Increpete_Decrepete();

	public int create(Customer r) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnection.getConnection();
		String pass = r.getPassword();
		String pass1 = in1.getEncodedString(pass);
		int i = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into Registration values(?,?,?,?,?)");
			preparedStatement.setString(1, r.getName());
			preparedStatement.setString(2, r.getEmail());
			preparedStatement.setString(3, r.getBalance());
			preparedStatement.setString(4, r.getUsername());
			preparedStatement.setString(5, pass1);
			i = preparedStatement.executeUpdate();
			if (i > 0) {
				System.out.println("register successfully!");
				return i;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int validateUser(Logins l) throws SQLException, ClassNotFoundException {
		int j = 0;
		Connection connection = SqlConnection.getConnection();
		String pass = l.getPassword();
		String pass1 = in1.getEncodedString(pass);

		try {
			PreparedStatement ps=connection.prepareStatement("select * from Registration where username=? and password=?");
			ps.setString(1,l.getUsername());
			ps.setString(2,pass1);
			ResultSet rs=ps.executeQuery();

			if(rs.next()) {
				System.out.println("login successfully");
				j = 1;
			}
			connection.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return j;
	}
	public int checkuser(Customer r) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnection.getConnection();
		int b=0;

		try {
			PreparedStatement ps = connection.prepareStatement("select * from Registration where username=? and password=?");
			ps.setString(1,r.getUsername());
			ps.setString(2,r.getPassword());
			ResultSet rs=ps.executeQuery();

			if(rs.next()) {
				System.out.println("check user successfully");
				b = 1;
			}
			connection.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return b;
	}
}
