package org.example.bytebank.dao;
import java.sql.Date;
import java.text.*;
import java.sql.*;

import org.example.bytebank.model.Increpete_Decrepete;
import org.example.bytebank.model.Recharge;
import org.example.bytebank.utility.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RechargeDao {

	public int returnbal(String usr) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnection.getConnection();

		int oldbal=0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from registration where username=?");
			preparedStatement.setString(1, usr);
			ResultSet set = preparedStatement.executeQuery();
			if(set.next()) {
				String bal1=set.getString(4);
				oldbal=Integer.parseInt(bal1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return oldbal;
	}

	public int recharge(Recharge r) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnection.getConnection();
		int i = 0;
		SimpleDateFormat df = new SimpleDateFormat("dd-mmm-yyy");
		Date d = new Date(i);
		String newdate = df.format(d);

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into recharge_transaction values(?,?,?,?)");
			preparedStatement.setString(1, r.getUsername());
			preparedStatement.setString(2, r.getAmt());
			preparedStatement.setString(3, r.getOperator());
			preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			i = preparedStatement.executeUpdate();

			if(i == 1) {
				System.out.println("done recharge");
			}
			connection.close();
		}

		catch (SQLException e1) {
			e1.printStackTrace();
		}
		return i;
	}

	public void updateBal(String usr,String newbal) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnection.getConnection();
		int i=0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update registration set balance=? where username=?");
			preparedStatement.setString(1,newbal);
			preparedStatement.setString(2, usr);
			i = preparedStatement.executeUpdate();
			if (i == 1) {
				System.out.println("balance update");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
