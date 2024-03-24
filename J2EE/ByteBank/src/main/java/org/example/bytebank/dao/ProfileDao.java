package org.example.bytebank.dao;

import org.example.bytebank.model.Customer;
import org.example.bytebank.model.Increpete_Decrepete;
import org.example.bytebank.utility.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProfileDao {
	Increpete_Decrepete in1=new Increpete_Decrepete();

	public List<Customer> getUser(String username) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnection.getConnection();
		List<Customer> lst = new LinkedList<>();
		try	{
			PreparedStatement preparedStatement = connection.prepareStatement("select * from Registration where username=?");
			preparedStatement.setString(1,username);
			ResultSet rs = preparedStatement.executeQuery();

			if(rs.next()) {
				String pass=rs.getString(6);
				String pass1=in1.getDecodedString(pass);
				Customer s = new Customer(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						pass1
				);
				lst.add(s);
			}
			connection.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return lst;
	}
	public int UpdateProfile(Customer customer,String user) throws SQLException, ClassNotFoundException {
		int i=0;
		Connection connection = SqlConnection.getConnection();
		String pass = customer.getPassword();
		String pass1 = in1.getEncodedString(pass);

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update Registration set name=?,email=?,mobile_no=?,balance=?,password=? where username=?");
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getEmail());
			preparedStatement.setString(3, customer.getBalance());
			preparedStatement.setString(4, pass1);
			preparedStatement.setString(5, user);
			i = preparedStatement.executeUpdate();

			if(i > 0) {
				System.out.println("get updated");
				i = 1;
			} else {
				System.out.println("error");
			}
			connection.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return i;
	}
}
