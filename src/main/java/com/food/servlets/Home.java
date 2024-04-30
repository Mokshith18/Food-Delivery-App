package com.food.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.dao.RestaurantDAO;
import com.food.daoimpl.RestaurantDAOImpl;
import com.food.model.Restaurant;

@WebServlet("/home")
public class Home extends HttpServlet {
	private RestaurantDAO res;
	@Override
	public void init() throws ServletException {
		res = new RestaurantDAOImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		List<Restaurant> list = res.getAllRestaurant();
		request.setAttribute("restaurantlist", list);
		
		RequestDispatcher d = request.getRequestDispatcher("Home.jsp");
		d.forward(request, responce);
	}

}
