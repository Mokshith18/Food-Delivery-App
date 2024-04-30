<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.food.model.User" %>
    <%@page import="com.food.model.Order" %>
    <%@page import="com.food.model.OrderHistory" %>
    <%@page import="com.food.daoimpl.OrderHistoryDAOImpl" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart History</title>
<link href="orderHistory.css">
<style type="text/css">

body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f2f2f2;
}

h1, h2 {
   
    margin-top: 30px;
}

.container {
    max-width: 500px;
    margin: 0 auto;
}

.box {
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 10px;
    margin-bottom: 20px;
}

p {
    margin: 0;
    text-align: center;
}

/* Optional: You can add specific styles for individual elements if needed */


</style>
</head>
<body>
<%
	User u = (User)session.getAttribute("loggedInUser");
	//-Order o = (Order)session.getAttribute("order");
	OrderHistory oh1 = (OrderHistory)session.getAttribute("orderHistory");
	OrderHistoryDAOImpl ohd = new OrderHistoryDAOImpl();
	int id = u.getUserId();
	ArrayList<OrderHistory> oh = ohd.getAllOrderHistory(id); 
	if(oh.size()!=0){
		for(int i=0;i<oh.size();i++){
			
			%>
	 <div class="box">
        <p> Name: <%= u.getUserName() %></p>
        <p> OrderId: <%= oh.get(i).getOrderId() %></p>
       	
        <p> OrderDate: <%= oh.get(i).getOrderDate() %></p>
        <p> Total Amount: <%= oh.get(i).getTotalAmount() %></p>
        <p> Status: <%= oh.get(i).getStatus() %></p>
    </div>
<%}
	}else {%>
	<h1>Not Ordered Yet</h1>
<%} %>
</body>
</html>