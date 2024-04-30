package com.food.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.OrderDAO;
import com.food.dao.UserDAO;
import com.food.daoimpl.OrderDAOImpl;
import com.food.daoimpl.UserDAOImpl;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.User;
@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {
	
	private OrderDAO orderDAO;
	
	 @Override
	    public void init() {
	        orderDAO = new OrderDAOImpl();
	    }
	 
	 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	        Cart cart = (Cart) session.getAttribute("cart");
	        User user = (User) session.getAttribute("loggedInUser");
	       
	        if (cart != null && user != null && !cart.getItems().isEmpty()) {
	        	String paymentMethod = request.getParameter("paymentMethod");
	        	//System.out.println(paymentMethod);
	        	 Order order = new Order();
	             order.setUserId(user.getUserId());
	             order.setRestaurantId((int) session.getAttribute("restaurantId"));
	             order.setOrderDate(new Date());
	             order.setPaymentMode(paymentMethod);
	             order.setStatus("accepted");
	             
	             float  totalAmount = 0;
                 String addr = (String) request.getParameter("address");
                //System.out.println(addr);
	            UserDAO u = new UserDAOImpl();
	             User loggedUser1 = (User) session.getAttribute("loggedInUser");
	             loggedUser1.setAddress(addr);
	             u.addAddressByUser(loggedUser1);
	             for (CartItem item : cart.getItems().values()) {
	                 totalAmount += item.getPrice() * item.getQuantity();
	                 // Assuming Order has a method to handle the addition of order items
	                 // order.addOrderItem(item);
	             }
	             order.setTotalAmount(totalAmount);
	             
	             orderDAO.addOrder(order);
	             
	             //session.removeAttribute("cart");
	             session.setAttribute("order", order);
	             
	             response.sendRedirect("order_confirmation.jsp");
	        }
	        else {
	        	
	        	response.sendRedirect("Login.jsp");
	        }
	}

}
