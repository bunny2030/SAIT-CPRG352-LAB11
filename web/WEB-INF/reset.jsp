<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <p>Please enter your email address to reset your password.</p>
        <form action="resetPass" method="POST">
            <label>Email Address:</label>
            <input type="email" name="userEmail"> <br>
            <input type="submit" value="Submit">
        </form>
        
       
        
    </body>
</html>