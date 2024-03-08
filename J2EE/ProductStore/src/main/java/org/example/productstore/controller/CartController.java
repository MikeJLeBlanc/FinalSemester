package org.example.productstore.controller;

import org.example.productstore.dao.CartDao;
import org.example.productstore.modal.Cart;

import java.sql.SQLException;
import java.util.ArrayList;

public class CartController implements CartDao {

    @Override
    public void insert(Cart cart) throws SQLException {

    }

    @Override
    public void update(Cart cart) throws SQLException {

    }

    @Override
    public void delete(Cart cart) throws SQLException {

    }

    @Override
    public Cart select(String user, String Password) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Cart> select(int userID) throws SQLException {
        return null;
    }
}
