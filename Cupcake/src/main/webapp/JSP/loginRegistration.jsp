<%-- 
    Document   : LoginRegistration
    Created on : Mar 4, 2019, 4:53:23 PM
    Author     : Rasmus2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Registration</title>
    </head>
    <body>
        <h1>Login Registration</h1>
        <p>
        <form action="/Cupcake/FrontController?action=makeLogin" method="post"><br>Username:<br><input type="text" name="username" value=""><br>Login:<br><input type="text" name="password" value=""><br><br><input type="submit" value="Create account"></form>
        <br>
        <form action="/Cupcake/FrontController?action=login" method="post">
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
