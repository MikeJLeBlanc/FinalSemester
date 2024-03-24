package org.example.bytebank.dao;
import java.util.*;
import org.example.bytebank.model.DepositWithdraw;
import org.example.bytebank.model.Increpete_Decrepete;
import org.example.bytebank.model.Recharge;
import org.example.bytebank.utility.SqlConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
public class TransactionDao {
	public int deposit(String username, String amount) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnection.getConnection();
		int i = 0;
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyy");
		Date date = new Date(i);
		String newdate = df.format(date);
		String type = "Deposit";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into  withdraw_deposit values(?,?,?,?)");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, amount);
			preparedStatement.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
			preparedStatement.setString(4, type);

			i = preparedStatement.executeUpdate();
			if(i == 1) {
				PreparedStatement user = connection.prepareStatement("Select * from registration where username=?");
				user.setString(1, username);
				ResultSet set = user.executeQuery();
				if(set.next()) {
					String balance = set.getString(4);
					int bal1 = Integer.parseInt(balance);
					String bal = amount;
					int bal2=Integer.parseInt(bal);
					int bal3 = bal1 + bal2;
					String bal4 = Integer.toString(bal3);

					preparedStatement = connection.prepareStatement("update registration set balance=? where username=?");
					preparedStatement.setString(1,bal4);
					preparedStatement.setString(2, username);
					i = preparedStatement.executeUpdate();
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return i;
	}

	public int withdraw(String username,String amount) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnection.getConnection();
		int i = 0;
		SimpleDateFormat df = new SimpleDateFormat("dd-mmm-yyy");
		Date date = new Date(i);
		String newdate = df.format(date);
		String type = "Withdraw";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into  withdraw_deposit values(?,?,?,?)");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, amount);
			preparedStatement.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
			preparedStatement.setString(4, type);
			i = preparedStatement.executeUpdate();

			if(i==1) {
				PreparedStatement user = connection.prepareStatement("Select * from registration where username=?");
				user.setString(1, username);
				ResultSet set = user.executeQuery();
				if(set.next()) {
					String balance=set.getString(4);
					int bal1=Integer.parseInt(balance);
					String bal = amount;
					int bal2 = Integer.parseInt(bal);
					int bal3 = bal1 - bal2;
					String bal4 = Integer.toString(bal3);
					preparedStatement = connection.prepareStatement("update registration set balance=? where username=?");
					preparedStatement.setString(1, bal4);
					preparedStatement.setString(2, username);
					i = preparedStatement.executeUpdate();
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return i;
	}
	public List<Recharge> rhistory(String username) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnection.getConnection();
		int i=0;
		
		List<Recharge> ls=new LinkedList<Recharge>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from  recharge_transaction where username=?");
			preparedStatement.setString(1, username);
			ResultSet set = preparedStatement.executeQuery();

			while(set.next()) {
				Recharge r = new Recharge(
						set.getString(1),
						set.getString(2),
						set.getString(3),
						set.getDate(4)
				);

				System.out.println(set.getString(1)+"123");
				ls.add(r);
			}
		} catch (SQLException e1) {
				e1.printStackTrace();
		}
		return ls;
	}
	
	public List<DepositWithdraw> rechHistory(String usrname) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnection.getConnection();
		int i=0;
		List<DepositWithdraw> ls1 = new LinkedList<DepositWithdraw>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from   withdraw_deposit where username=?");
			preparedStatement.setString(1,usrname);
			ResultSet set = preparedStatement.executeQuery();

			while(set.next()) {
				DepositWithdraw r = new DepositWithdraw(set.getString(1),set.getString(2),set.getDate(3),set.getString(4)) ;
				System.out.println(set.getString(1)+"123");
				ls1.add(r);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ls1;
	}
}
