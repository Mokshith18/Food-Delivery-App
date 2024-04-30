package com.food.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.dao.RestaurantDAO;
import com.food.daoimpl.RestaurantDAOImpl;
import com.food.model.Restaurant;

public class RestaurantServlet extends HttpServlet{
	private RestaurantDAO res;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		res = new RestaurantDAOImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Restaurant> list = res.getAllRestaurant();
			request.setAttribute("restaurantlist", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
}
