package org.example.productstore.dao;

import org.example.productstore.modal.Cart;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CartDao {
    public void insert(Cart cart) throws SQLException;
    public void update(Cart cart) throws SQLException;
    public void delete(Cart cart) throws SQLException;
    public Cart select(String user, String Password) throws SQLException;
    ArrayList<Cart> select(int userID) throws SQLException;
}
