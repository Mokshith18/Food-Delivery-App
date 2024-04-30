<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.food.dao.MenuDAO"%>
<%@page import="com.food.model.Menu"%>
<%@page import="com.food.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="menu.css">
</head>
<body>
	<header>
		<h1>Welcome to Tap Online Food Delivery</h1>
		<div class="nav-container">
			<nav>
				<a href="Home.jsp">Home</a>
				<%
				User loggedInUser1 = (User) session.getAttribute("loggedInUser");
				if (loggedInUser1 != null) {
				%>
				<span>Welcome, <%=loggedInUser1.getUserName()%></span> <a href="#">View
					Cart</a> <a href="#">View Order History</a> <a href="#">Logout</a>
				<%
				} else {
				%>
				<a href="Login.jsp">Login</a> <a href="Register.jsp">Register</a>
				<%
				}
				%>
			</nav>
		</div>

	</header>
	<h2 style="text-align: center">Menu</h2>
	<section class="res">
		<%
		List<Menu> menuList = (List<Menu>) request.getAttribute("menus");
		if (menuList != null && !menuList.isEmpty()) {
		%>

		<div class="row">
			<%
			for (int i = 0; i < menuList.size(); i++) {
			%>
			<div class="column">
				<div class="picdiv">
					<img alt="Image of <%=menuList.get(i).getItemName()%>"
						src="<%=menuList.get(i).getImagePath()%>" class="pic" />

					<h3><%=menuList.get(i).getItemName()%></h3>
					<p>
						<%=menuList.get(i).getDescription()%>
					</p>
					<p>
						&#8377
						<%=menuList.get(i).getPrice()%>&#9733
						<%=menuList.get(i).getRating()%></p>
					<form action="cart" >
						<!-- Modify action to cart servlet URL and change method to POST -->
						<input type="hidden" name="menuId" value="<%=menuList.get(i).getMenuId()%>">
						<!-- Hidden field to store menu ID -->
						<input type="number" placeholder="Quantity" name="quantity">
						<input type="hidden" name="action" value="add">
						<!-- Hidden field to store action value -->
						<button type="submit" class="but">Add To Cart</button>
						<!-- Change link to button -->
					</form>


				</div>
			</div>
			<%
			if ((i + 1) % 2 == 0) {
			%>
		</div>
		<div class="row">
			<!-- Close and reopen row every two items -->
			<%
			}
			%>
			<%
			}
			%>
		</div>
		<%
		} else {
		%>
		<p>No Menu available at the moment</p>
		<%
		}
		%>
	</section>

	<footer>
		<p>&#169  Tap Online Food Ltd. All rights reserved</p>
	</footer>
</body>
</html>