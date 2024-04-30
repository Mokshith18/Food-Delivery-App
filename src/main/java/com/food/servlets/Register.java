package com.food.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.daoimpl.UserDAOImpl;
import com.food.model.User;
@WebServlet("/callReg")
public class Register extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("uname");
		String email = req.getParameter("mail");
		long phone = Long.parseLong(req.getParameter("num"));
		String pass = req.getParameter("pass");
		String role = req.getParameter("role");
		
		User user = new User();
		user.setUserName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(pass);
		user.setRole(role);
		
		UserDAOImpl u = new UserDAOImpl();
		u.addUser(user);
		
		RequestDispatcher d = req.getRequestDispatcher("Login.jsp");
		d.forward(req, resp);
		
	}
	

}
