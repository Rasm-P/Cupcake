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
            div{
                margin: auto;
                text-align: center;
                width:600px;
            }
            body{
                max-width:vw;
                max-height:vh;
                background-image: url(https://images4.alphacoders.com/149/1494.jpg);
            }
        </style>
    </head>
    <body>
        <div>
            <h1>Login</h1>       
            <br> 
            <form action="/Cupcake/FrontController?action=login" method="post">
                <h4>Hvis du har en bruger kan du logge ind her</h4>   
                <p>Username:<p><input type="text" name="username" value=""><br>
                Login:<br><input type="password" name="password" value=""><br>
                <br>               
                <input type="submit" value="Login"></form>
            <br>
            <h4>Ellers kan du lave en bruger her!</h4>
            <form action="/Cupcake/FrontController?action=makeLogin" method="post">
                <input type="submit" value="Create an account" />
            </form>
        </div>
    </body>
</html>
