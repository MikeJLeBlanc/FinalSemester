package org.example.productstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.example.productstore.modal.Order;
import org.example.productstore.modal.Product;

public class OrderDao {

	private final Connection con;
	private String query;
    private PreparedStatement pst;

    public OrderDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean insertOrder(Order model) {
        boolean result = false;
        try {
            query = "insert into orders (userId, productId, quantity) values(?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getUserId());
            pst.setInt(2, model.getId());
            pst.setInt(3, model.getQuantity());
            pst.executeUpdate();

            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Order> userOrders(int id) {
        List<Order> list = new ArrayList<>();
        try {
            query = "select * from orders where userId=? order by orders.id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                ProductDao productDao = new ProductDao(this.con);
                int pId = rs.getInt("productId");

                Product product = productDao.getSingleProduct(pId);
                order.setOrderId(rs.getInt("id"));
                order.setId(pId);
                order.setName(product.getName());
                order.setCategory(product.getCategory());
                order.setPrice(product.getPrice()* rs.getInt("quantity"));
                order.setQuantity(rs.getInt("quantity"));
                order.setDate(rs.getString("orderDate"));

                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cancelOrder(int id) {
        try {
            query = "delete from orders where id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
    }
}
