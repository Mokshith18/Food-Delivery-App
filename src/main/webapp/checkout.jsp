<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Checkout</title>
    <link rel="stylesheet" href="checkout.css">
</head>
<body>
	 <h2>Checkout</h2>
    <form action="checkout" method="post">
        <label for="address">Delivery Address:</label>
        <textarea id="address" name="address" required></textarea>
        <label>Payment Method:</label>
        <select name="paymentMethod">
            <option value="Online">Credit Card</option>
            <option value="Online">Debit Card</option>
            <option value="offline">Cash on Delivery</option>
        </select><br><br>
        <input type="submit" value="Place Order">
    </form>
</body>
</html>