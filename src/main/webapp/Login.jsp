<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
    <h1>Food Delivery</h1>
    <div class="login">
        <h2>LOGIN</h2>
        <form action="callLogin" >
            <!-- <label for="uname">UserName:</label> -->
            <input type="text" id="uname" name="username" placeholder="UserName" required><br><br>
             <!--<label for="pass">Password:</label>  -->
            
            <input type="password" name="passw" id="pass" placeholder="Password" required><br><br>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>