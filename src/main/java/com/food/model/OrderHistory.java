package com.food.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class OrderHistory {
	private int orderHistoryId;
	private int userId;
	private int orderId;
	private LocalDateTime orderDate;
	private float totalAmount;
	private String status;
	
	public OrderHistory() {
		// TODO Auto-generated constructor stub
	}

	public OrderHistory(int orderHistoryId, int userId, int orderId, LocalDateTime orderDate, float totalAmount,
			String status) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.userId = userId;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderHistory [orderHistoryId=" + orderHistoryId + ", userId=" + userId + ", orderId=" + orderId
				+ ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}
	

}
