<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Register</title>
<link rel="stylesheet" href="Register1.css">
</head>
<body>  
    <h1>Food Delivery App</h1>
    <div class="reg"> 
        <h2>REGISTER</h2>    
        <form action="callReg"><!--  -->
        
            <input type="text" name="uname" id="nam" required placeholder="Name"/><br><br>
            
            <input type="email" name="mail" required placeholder="Email"/><br><br>
            
            <input type="number" name="num" required placeholder="Phone"/><br><br>
            
            <input type="password" name="pass" required placeholder="Password"/><br><br>
            
            <!--  <p>Please select your role:</p>-->
            <div class="subReg">
            	<input type="radio" id="customer" name="role" value="customer" class="role" required>
                <label for="customer">Customer</label>
            
                <input type="radio" id="admin" name="role" value="admin" class="role">
                <label for="admin">Admin</label><br><br>
            
            </div>
            
            <button type="submit">Register</button>
            
        </form>
    </div>
</body>

</html>