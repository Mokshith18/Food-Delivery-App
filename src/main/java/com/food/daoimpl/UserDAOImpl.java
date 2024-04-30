package com.food.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.UserDAO;
import com.food.model.User;

public class UserDAOImpl implements UserDAO {
	
	private Connection con;
	String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
	String user = "root";
	String pswd = "root";
	
	public UserDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pswd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		String query = "insert into user(username,password,email,phone,address,role) values(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setLong(4, user.getPhone());
			stmt.setString(5, user.getAddress());
			stmt.setString(6, user.getRole());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				user.setUserId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		String query = "Select * from user where userId = ?";
		try(PreparedStatement stmt = con.prepareStatement(query)){
			stmt.setInt(1, userId);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("userId"));
				u.setUserName(res.getString("username"));
				u.setPassword(res.getString("password"));
				u.setAddress(res.getString("address"));
				u.setPhone(res.getLong("phone"));
				u.setEmail(res.getString("email"));
				u.setRole(res.getString("role"));
				return u;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		String query = "update user set username = ?, password = ?, email = ?, phone = ?,address = ?,role = ? where userId = ? ";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setLong(4, user.getPhone());
			stmt.setString(5, user.getAddress());
			stmt.setString(6, user.getRole());
			stmt.setInt(7, user.getUserId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		String query = "delete from user where userId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, userId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<>();
		String query = "select * from user";
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("userId"));
				u.setUserName(res.getString("username"));
				u.setPassword(res.getString("password"));
				u.setPhone(res.getLong("phone"));
				u.setEmail(res.getString("email"));
				u.setRole(res.getString("role"));
				userList.add(u);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}
	@Override
	public User getUserByName(String name) {
		String query = "select * from user where username = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("userId"));
				u.setUserName(res.getString("username"));
				u.setPassword(res.getString("password"));
				u.setPhone(res.getLong("phone"));
				u.setEmail(res.getString("email"));
				u.setRole(res.getString("role"));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void addAddressByUser(User user) {
		String query = "update user set address = ? where userId = ? ";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, user.getAddress());
			
			stmt.setInt(2, user.getUserId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
