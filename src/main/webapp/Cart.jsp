<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.food.model.Cart" %>
    <%@page import="java.util.Map" %>
    <%@page import="com.food.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="cart.css">
</head>
<body>
<h1>Your Shopping Cart</h1>
<div class="cart-items">
<%

Cart cart = (Cart) session.getAttribute("cart");
if (cart != null && !cart.getItems().isEmpty()) {
for (CartItem item : cart.getItems().values()) {
%>
<div class="cart-item">
	<h3><%=item.getName()%></h3>
	<p>
	&#x20B9;<%=item.getPrice()%></p>
<!-- For update button -->
<form action="cart">
    <input type="hidden" name="itemId" value="<%=item.getItemId()%>">
    
    <label>Quantity: 
        <input type="number" name="quantity" value="<%=item.getQuantity()%>" min="1">
    </label> 
    <input type="submit" name="action" value="update" class="update-btn">
    <input type="hidden" name="menuId" value="<%=item.getItemId()%>">
    <input type="submit" name="action" value="remove" class="remove-btn">
</form>
	

</div>
<%
}
} else {
%>
<p>Your cart is empty.</p>
<%
}
%>
<!-- session.getAttribute("restaurantId") -->
<a href="menu?restaurantId=<%=(Integer)session.getAttribute("restaurantId")%>"
class="btn">Add More Items</a>

<!-- Proceed to Checkout Button -->
<%
if (session.getAttribute("cart") != null) {
%>
<form action="checkout.jsp" >
<input type="submit" value="Proceed to Checkout"
class="btn proceed-to-checkout-btn">
</form>
<%
}
%>
</div>
</body>
</html>