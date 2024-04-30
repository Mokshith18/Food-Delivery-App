package com.food.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoimpl.MenuDAOImpl;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Menu;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	private Cart cart;
	static HttpSession session;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String i = request.getParameter("menuId");
		//System.out.println(i);
//		int id = Integer.parseInt(i);
		int q = Integer.parseInt(request.getParameter("quantity"));
		session = request.getSession();
		cart = (Cart) session.getAttribute("cart");
		if(cart== null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		 String action = request.getParameter("action");
		 //System.out.println(cart);

		//System.out.println("action: "+ action);
		
		if(action.equals("add")) {
			addItemToCart(cart,request);
		}
		else if(action.equals("update")) {
			updateItemInCart(cart,request);
		}
		else if(action.equals("remove")) {
			deleteItemInCart(cart,request);
		}
		session.setAttribute("cart", cart);
		response.sendRedirect("Cart.jsp");

		
	}
	static void addItemToCart(Cart cart, HttpServletRequest request) {
		MenuDAOImpl menu = new MenuDAOImpl();
		int id = Integer.parseInt(request.getParameter("menuId"));
		
		Menu m = menu.getMenu(id);
		
		CartItem ci = new CartItem();
		ci.setItemId(m.getMenuId());
		ci.setName(m.getItemName());
		ci.setPrice(m.getPrice());
		ci.setRestaurantId(m.getRestaurantId());
		ci.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		cart.addItem(ci);
		session.setAttribute("restaurantId", m.getRestaurantId());
		
		
	}
	static void updateItemInCart(Cart cart,HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("menuId"));
		int q = Integer.parseInt(request.getParameter("quantity"));
		//System.out.println(id+"  "+q);
		cart.updateItem(id, q);
	}
	static void deleteItemInCart(Cart cart,HttpServletRequest request) {
		int i = Integer.parseInt(request.getParameter("menuId"));
		cart.deleteItem(i);
	}
}
