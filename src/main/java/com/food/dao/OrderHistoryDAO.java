package com.food.dao;

import java.util.ArrayList;

import com.food.model.OrderHistory;

public interface OrderHistoryDAO {
	
	void addOrderHistory(OrderHistory orderHistory);
	
	OrderHistory getOrderHistory(int orderHistory);
	
	void updateOrderHistory(OrderHistory orderHistory);
	
	void deleteOrderHistory(int orderHistoryId);
	
	ArrayList<OrderHistory> getAllOrderHistory(int userId);

}
