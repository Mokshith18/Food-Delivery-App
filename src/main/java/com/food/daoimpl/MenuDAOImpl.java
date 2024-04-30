package com.food.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.MenuDAO;
import com.food.model.Menu;

public class MenuDAOImpl implements MenuDAO {
	
	private Connection con;
	String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
	String user = "root";
	String pswd = "root";
	
	public MenuDAOImpl() {
		// TODO Auto-generated constructor stub
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
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		String query = "insert into menu(restaurantId, itemName, description, price, ratings, isAvailable,imagePath) values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, menu.getRestaurantId());
			stmt.setString(2, menu.getItemName());
			stmt.setString(3, menu.getDescription());
			stmt.setFloat(4,menu.getPrice());
			stmt.setFloat(5, menu.getRating());
			stmt.setBoolean(6, menu.isAvailable());
			stmt.setString(7, menu.getImagePath());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				menu.setMenuId(rs.getInt(1));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Menu getMenu(int menuId) {
		// TODO Auto-generated method stub
		String query = "Select * from menu where menuId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, menuId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Menu me = new Menu();
				me.setMenuId(rs.getInt("menuId"));
				me.setRestaurantId(rs.getInt("restaurantId"));
				me.setItemName(rs.getString("itemName"));
				me.setDescription(rs.getString("description"));
				me.setPrice(rs.getFloat("price"));
				me.setRating(rs.getFloat("ratings"));
				me.setAvailable(rs.getBoolean("isAvailable"));
				return me;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	@Override
	public void updateMenu(Menu menu) {
		String query = "update menu set restaurantId = ?,itemName = ?,description = ?,price = ?,ratings = ?,isAvailable = ? where menuId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, menu.getRestaurantId());
			stmt.setString(2, menu.getItemName());
			stmt.setString(3, menu.getDescription());
			stmt.setFloat(4,menu.getPrice());
			stmt.setFloat(5, menu.getRating());
			stmt.setBoolean(6, menu.isAvailable());
			stmt.setInt(7, menu.getMenuId());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteMenu(int menuId) {
		String query = "delete from menu where menuId = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, menuId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Menu> getAllMenusByRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		List<Menu> list = new ArrayList<>();
		String query = "select * from menu where restaurantId = ?";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1,restaurantId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Menu me = new Menu();
				me.setMenuId(rs.getInt("menuId"));
				me.setRestaurantId(rs.getInt("restaurantId"));
				me.setItemName(rs.getString("itemName"));
				me.setDescription(rs.getString("description"));
				me.setPrice(rs.getFloat("price"));
				me.setRating(rs.getFloat("ratings"));
				me.setAvailable(rs.getBoolean("isAvailable"));
				me.setImagePath(rs.getString("imagePath"));
				list.add(me);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}
