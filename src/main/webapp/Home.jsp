<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "java.util.List" %>
    <%@page import = "com.food.model.User" %>
    <%@page import = "com.food.model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="home.css">
	<title>Home</title>
</head>
<body>
	<header>
        <h1>Welcome to Tap Online Food Delivery</h1>
        <div class="nav-container">
    <nav>
        <a href="Home.jsp">Home</a>
        <% User loggedInUser1 = (User) session.getAttribute("loggedInUser");
        if(loggedInUser1 != null){ %>
            <span>Welcome, <%=loggedInUser1.getUserName() %></span>
            <a href="Cart.jsp">View Cart</a>
            <a href="orderHistory">View Order History</a>
            <a href="logout">Logout</a>
        <% } else { %>
            <a href="Login.jsp">Login</a>
            <a href="Register.jsp">Register</a>
        <% } %>
    </nav>
</div>

    </header>
    <h2>Featured Restaurants</h2>
<section class="res">
    <%
    List<Restaurant> resList = (List<Restaurant>)request.getAttribute("restaurantlist");
    if(resList != null && !resList.isEmpty()){
    %>
    <div class="row">
        <% for (int i = 0; i < resList.size(); i++) { %>
            <div class="column">
                <div class="picdiv">   
                    <img alt="Image of <%=resList.get(i).getName() %>" src="<%=resList.get(i).getImagePath()%>" class="pic" />
                    <hr/>
                    <h3><%= resList.get(i).getName() %></h3>
                    <p> <%=resList.get(i).getCusineType() %>  <%=resList.get(i).getEta() %> mins </p>
                    <a href="menu?restaurantId=<%=resList.get(i).getRestaurantId() %>" class="button">Menu</a>
                </div>
            </div>
            <% if ((i + 1) % 2 == 0) { %>
                </div><div class="row"> <!-- Close and reopen row every two items -->
            <% } %>
        <% } %>
    </div>
    <% }
    else{
    %>
    <p>No Restaurant available at the moment</p>
    <%
    }
    %>
</section>

    <footer>
		<p>&#169  Tap Online Food Ltd. All rights reserved</p>
	</footer>
</body>
</html>