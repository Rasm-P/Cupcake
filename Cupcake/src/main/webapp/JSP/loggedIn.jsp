<%-- 
    Document   : loggedIn
    Created on : Mar 4, 2019, 7:37:25 PM
    Author     : Rasmus2
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Data.DataMapper"%>
<%@page import="Users.User"%>
<%@page import="java.time.LocalDate"%>
<%@page import="Shop.Invoice"%>
<%@page import="Shop.lineItems"%>
<%@page import="Shop.shoppingCart"%>
<%@page import="Data.transaction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logged In</title>
    </head>
    <body>
        <h1> Velkommen tilbage! </h1>
        <h1>Logged in!</h1>
        <form action="/Cupcake/FrontController?action=addmoney" method="POST">
            <input type="text" name="amount" placeholder="Enter amount"/>
            <input type="submit" value="Add money to account"/>
        </form>
        <%
            DataMapper d = new DataMapper();
            if (session.getAttribute("User") != null) {
                User u = (User) session.getAttribute("User");
                out.println("<p>" + "User: " + u.getUserName() + "Balance: " + u.getBalance() + "</p>");
            }
        %>
        <form action="/Cupcake/FrontController?action=shop" method="post">
            <input type="submit" value="Shop" />
        </form>
        <br>
        <form action="/Cupcake/FrontController" method="post">
            <input type="submit" value="Back to main page" />
        </form>
        <br>
        <form action="/Cupcake/FrontController?action=logOut" method="post">
            <input type="submit" value="Logout" />
        </form>
    </body>
</html>
