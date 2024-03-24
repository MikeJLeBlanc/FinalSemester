package org.example.bytebank.model;

import java.util.Date;

public class Recharge {
private String username;
private String amt;
private String operator;
private Date date;

public Recharge(String username, String amt, String operator, Date date) {
	super();
	this.username = username;
	this.amt = amt;
	this.operator = operator;
	this.date = date;
	
}

public String getAmt() {
	return amt;
}
public void setAmt(String amt) {
	this.amt = amt;
}
public String getOperator() {
	return operator;
}
public void setOperator(String operator) {
	this.operator = operator;
}
public Date getDate() {return date;}
public void setDate(Date date) {this.date = date;}
public String getUsername() {return username;}
public void setUsername(String username) {this.username = username;}

}