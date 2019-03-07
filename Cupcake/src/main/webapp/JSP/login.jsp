<%-- 
    Document   : Login
    Created on : Mar 4, 2019, 5:41:35 PM
    Author     : Rasmus2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <style> 
            #Div1{
                margin: auto;
                text-align: center;
                width:600px;
            }
        </style>
    </head>
    <body>
        <div id="">
            <h1>Login</h1>
            <p>
            <form action="/Cupcake/FrontController?action=login" method="post">
                <br>Username:<br><input type="text" name="username" value=""><br>
                Login:<br><input type="password" name="password" value=""><br>
                <br><input type="submit" value="Login"></form>
            <br>
            <form action="/Cupcake/FrontController?action=makeLogin" method="post">
                <input type="submit" value="Create an account" />
            </form>
        </div>
    </body>
</html>
