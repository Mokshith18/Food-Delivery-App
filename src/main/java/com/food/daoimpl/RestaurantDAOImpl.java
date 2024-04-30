package com.food.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.RestaurantDAO;
import com.food.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {
	
	private Connection con;
	String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
	String user = "root";
	String pswd = "root";
	
	public RestaurantDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pswd);
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void addRestaurant(Restaurant restaurant) {
		String query = "insert into Restaurant(name,address,phone,rating,cusineType,isActive,userId) values (?,?,?,?,?,?,?)"; 
//name varchar(45) not null,address blob not null,phone bigint, rating float,cusineType varchar(20),isActive bool,
		try {
			PreparedStatement stmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, restaurant.getName());
			stmt.setString(2, restaurant.getAddress());
			stmt.setLong(3, restaurant.getPhone());
			stmt.setFloat(4, restaurant.getRating());
			stmt.setString(5, restaurant.getCusineType());
			stmt.setBoolean(6, restaurant.isActive());
			stmt.setInt(7,restaurant.getUserId());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				restaurant.setRestaurantId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public Restaurant getRestaurant(int restaurantId) {
		
		String query = "select * from restaurant where restaurantId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, restaurantId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Restaurant res = new Restaurant();
				res.setRestaurantId(rs.getInt("restaurantId"));
				res.setName(rs.getString("name"));
				res.setAddress(rs.getString("address"));
				res.setPhone(rs.getLong("phone"));
				res.setRating(rs.getFloat("rating"));
				res.setCusineType(rs.getString("cusineType"));
				res.setActive(rs.getBoolean("isActive"));
				res.setEta(rs.getString("eta"));
				res.setImagePath(rs.getString("imagePath"));
				return res;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateRestaurant(Restaurant restaurant) {
		String query ="update restaurant set name = ?,address = ?,phone = ?,rating = ?,cusineType = ?,isActive =  ? where restaurantId = ?";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, restaurant.getName());
			stmt.setString(2, restaurant.getAddress());
			stmt.setLong(3, restaurant.getPhone());
			stmt.setFloat(4, restaurant.getRating());
			stmt.setString(5, restaurant.getCusineType());
			stmt.setBoolean(6, restaurant.isActive());
			stmt.setInt(7,restaurant.getRestaurantId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		String query = "delete from restaurant where restaurantId = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, restaurantId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> list = new ArrayList<>();
		String query = "select * from restaurant";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Restaurant res = new Restaurant();
				res.setRestaurantId(rs.getInt("restaurantId"));
				res.setName(rs.getString("name"));
				res.setAddress(rs.getString("address"));
				res.setPhone(rs.getLong("phone"));
				res.setRating(rs.getFloat("rating"));
				res.setCusineType(rs.getString("cusineType"));
				res.setActive(rs.getBoolean("isActive"));
				res.setEta(rs.getString("eta"));
				res.setImagePath(rs.getString("imagePath"));
				list.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
