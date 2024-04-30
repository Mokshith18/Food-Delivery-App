<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.food.model.Order" %>
    <%@page import="com.food.model.User" %>
    <%@page import="com.food.daoimpl.UserDAOImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CheckOut</title>
<link rel="stylesheet" href="order_con.css">
</head>
<body>
<h2>Thank you for Ordering</h2>
<%Order order = (Order) session.getAttribute("order"); 
UserDAOImpl u = new UserDAOImpl();
User uu = u.getUser(order.getUserId());
%>
<p>Name:<%=uu.getUserName() %></p>
<p>Amount: <%=order.getTotalAmount() %></p>
<p>Address:<%=uu.getAddress() %></p>
<p>PaymentMode:<%=order.getPaymentMode() %></p>
<a href="home">Home</a>
</body>
</html>