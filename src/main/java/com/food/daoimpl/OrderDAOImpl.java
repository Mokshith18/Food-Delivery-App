package com.food.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderDAO;
import com.food.model.Order;

public class OrderDAOImpl implements OrderDAO {
	private Connection con;
	String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
	String user = "root";
	String pswd = "root";
	public OrderDAOImpl(){
		try {
			con = DriverManager.getConnection(url, user, pswd);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	@Override
	public void addOrder(Order order) {
		String query ="insert into orders(userId, restaurantId,totalAmount,status,orderdate, paymentmode) values(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,order.getUserId());
			stmt.setInt(2,order.getRestaurantId());
			stmt.setFloat(3, order.getTotalAmount());
			stmt.setString(4, order.getStatus());
			java.util.Date utilDate = order.getOrderDate();
	        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			stmt.setDate(5, sqlDate);
			stmt.setString(6, order.getPaymentMode());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				order.setOrderId(rs.getInt(1));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public Order getOrder(int orderId) {
		String query = "select * from orders where orderId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, orderId);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				Order or = new Order();
				or.setOrderId(res.getInt("orderId"));
				or.setRestaurantId(res.getInt("restaurantId"));
				or.setUserId(res.getInt("userId"));
				//or.setOrderDate(res.getDate("orderdate"));
				or.setTotalAmount(res.getFloat("totalAmount"));
				or.setStatus(res.getString("status"));
				or.setPaymentMode(res.getString("paymentmode"));
				return or;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void updateOrder(Order order) {
		String query = "update orders set userId = ?,restaurantId = ?,paymentmode = ?,status = ?,totalAmount = ? where orderId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, order.getUserId());
			stmt.setInt(2, order.getRestaurantId());
			stmt.setString(3, order.getPaymentMode());
			stmt.setString(4, order.getStatus());
			stmt.setFloat(5, order.getTotalAmount());
			stmt.setInt(6,order.getOrderId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteOrder(int orderId) {
		String query = "delete from orders where orderId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, orderId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Order> getAllOrder(int userId) {
		List<Order> list = new ArrayList<>();
		String query = "select * from orders where userId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, userId);
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				Order or = new Order();
				or.setOrderId(res.getInt("orderId"));
				or.setRestaurantId(res.getInt("restaurantId"));
				or.setUserId(res.getInt("userId"));
				or.setOrderDate(res.getDate("orderdate"));
				or.setTotalAmount(res.getFloat("totalAmount"));
				or.setStatus(res.getString("status"));
				or.setPaymentMode(res.getString("paymentmode"));
				list.add(or);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
