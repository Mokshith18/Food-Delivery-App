package com.food.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoimpl.OrderHistoryDAOImpl;
import com.food.daoimpl.UserDAOImpl;
import com.food.model.Order;
import com.food.model.OrderHistory;
import com.food.model.User;
@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Order or = (Order) session.getAttribute("order");
		User user1 = (User) session.getAttribute("loggedInUser");
		
		if(or!=null) {
			
		
		OrderHistoryDAOImpl ohis = new OrderHistoryDAOImpl();
		OrderHistory oh=new OrderHistory(1, user1.getUserId(), or.getOrderId(), null, or.getTotalAmount(), "Delivered");
		//OrderHistory oh = new OrderHistory(1, user1.getUserId(), or.getOrderId(), user1.get, 0, getServletInfo())
		ohis.addOrderHistory(oh);
		session.setAttribute("orderHistory", oh);
		}
		response.sendRedirect("OrderHistory.jsp");
	}

}
