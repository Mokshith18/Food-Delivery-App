package com.food.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.food.dao.OrderHistoryDAO;
import com.food.model.OrderHistory;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {
	private Connection con;
	String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
	String user = "root";
	String pswd = "root";
	
	public OrderHistoryDAOImpl() {
		try {
			con = DriverManager.getConnection(url, user, pswd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addOrderHistory(OrderHistory orderHistory) {
		String query = "insert into OrderHistory(userId, orderId, totalAmount,status,orderDate) values(?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, orderHistory.getUserId());
			stmt.setInt(2, orderHistory.getOrderId());
			stmt.setFloat(3, orderHistory.getTotalAmount());
			stmt.setString(4, orderHistory.getStatus());
			LocalDateTime currentTime = LocalDateTime.now();
			stmt.setObject(5, currentTime);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				orderHistory.setOrderHistoryId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public OrderHistory getOrderHistory(int userId) {
		// TODO Auto-generated method stub
		String query = "Select * from OrderHistory where userId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, userId);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				OrderHistory oh = new OrderHistory();
				oh.setOrderHistoryId(res.getInt("OrderHistoryId"));
				oh.setOrderId(res.getInt("orderId"));
				oh.setUserId(res.getInt("userId"));
				oh.setStatus(res.getString("status"));
				oh.setTotalAmount(res.getFloat("totalAmount"));
				Timestamp currentTime = res.getTimestamp("orderdate");
				 LocalDateTime localDateTime = currentTime.toLocalDateTime();
				 oh.setOrderDate(localDateTime);
				return oh;
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		String query = "update OrderHistory set userId = ?, orderId = ?, totalAmount = ?,status = ? where orderHistoryId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, orderHistory.getUserId());
			stmt.setInt(2, orderHistory.getOrderId());
			stmt.setFloat(3, orderHistory.getTotalAmount());
			stmt.setString(4, orderHistory.getStatus());
			stmt.setInt(5, orderHistory.getOrderHistoryId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		String query = "delete from Orderhistory where orderHistoryId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, orderHistoryId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<OrderHistory> getAllOrderHistory(int userId) {
		ArrayList<OrderHistory> list = new ArrayList<>();
		String query = "select * from orderhistory where userId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, userId);
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				OrderHistory oh = new OrderHistory();
				oh.setOrderHistoryId(res.getInt("OrderHistoryId"));
				oh.setOrderId(res.getInt("orderId"));
				oh.setUserId(res.getInt("userId"));
				oh.setStatus(res.getString("status"));
				oh.setTotalAmount(res.getFloat("totalAmount"));
				Timestamp currentTime = res.getTimestamp("orderdate");
				 LocalDateTime localDateTime = currentTime.toLocalDateTime();
				 oh.setOrderDate(localDateTime);
				list.add(oh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
