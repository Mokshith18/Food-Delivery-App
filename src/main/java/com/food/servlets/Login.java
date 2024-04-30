package com.food.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.UserDAO;
import com.food.daoimpl.UserDAOImpl;
import com.food.model.User;
@WebServlet("/callLogin")
public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("username");
		String pass = req.getParameter("passw");
		
		UserDAO user = new UserDAOImpl();
		User u = user.getUserByName(name);
		if(u != null) {
			if(u.getPassword().equals(pass)) {
				HttpSession session = req.getSession();
				session.setAttribute("loggedInUser", u);
				RequestDispatcher rd = req.getRequestDispatcher("home");
				rd.forward(req, resp);
			}
			
		}
		
		
		
	}

}
