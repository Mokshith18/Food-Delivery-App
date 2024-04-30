package com.food.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderItemDAO;
import com.food.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO{
	
	private Connection con;
	String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
	String user = "root";
	String pswd = "root";
	
	public OrderItemDAOImpl(){
		try {
			con = DriverManager.getConnection(url, user, pswd);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	@Override
	public void addOrderItem(OrderItem orderItem) {
		String query = "insert into orderitem(orderId,menuId,quantity,totalprize) values(?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, orderItem.getOrderId());
			stmt.setInt(2, orderItem.getMenuId());
			stmt.setInt(3, orderItem.getQuantity());
			stmt.setFloat(4, orderItem.getTotalPrize());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				orderItem.setOrderItemId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public OrderItem getOrderItem(int orderItemId) {
		String query = "select * from orderItem where orderItemId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, orderItemId);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				OrderItem ot = new OrderItem();
				ot.setOrderItemId(res.getInt("orderItemId"));
				ot.setMenuId(res.getInt("menuId"));
				ot.setOrderId(res.getInt("orderId"));
				ot.setQuantity(res.getInt("quantity"));
				ot.setTotalPrize(res.getInt("totalPrize"));
				return ot;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateOrderItem(OrderItem orderItem) {
		String query = "update orderItem set orderId = ?,menuId = ?,quantity = ?,totalprize = ? where orderItemId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, orderItem.getOrderId());
			stmt.setInt(2, orderItem.getMenuId());
			stmt.setInt(3, orderItem.getQuantity());
			stmt.setFloat(4, orderItem.getTotalPrize());
			stmt.setInt(5, orderItem.getOrderItemId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteOrderItem(int orderItemId) {
		String query = "delete from orderItem where orderItemId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, orderItemId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<OrderItem> getAllOrderItemByOrder(int orderId) {
		List<OrderItem> list = new ArrayList<>();
		String query ="select * from orderItem where orderId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, orderId);
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				OrderItem ot = new OrderItem();
				ot.setOrderItemId(res.getInt("orderItemId"));
				ot.setMenuId(res.getInt("menuId"));
				ot.setOrderId(res.getInt("orderId"));
				ot.setQuantity(res.getInt("quantity"));
				ot.setTotalPrize(res.getInt("totalPrize"));
				list.add(ot);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
