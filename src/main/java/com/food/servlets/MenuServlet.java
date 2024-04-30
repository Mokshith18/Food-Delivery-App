package com.food.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.dao.MenuDAO;
import com.food.daoimpl.MenuDAOImpl;
import com.food.model.Menu;
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private RequestDispatcher rd;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("hello");
		String i = request.getParameter("restaurantId");
		
		//System.out.println(i);
		int id = Integer.parseInt(i);
		MenuDAO menu = new MenuDAOImpl();
		List<Menu> list =menu.getAllMenusByRestaurant(id);
		request.setAttribute("menus", list);
		rd = request.getRequestDispatcher("Menu.jsp");
		rd.forward(request, response);
	}
	

}
