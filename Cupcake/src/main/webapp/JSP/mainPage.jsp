<%-- 
    Document   : mainPage
    Created on : Mar 4, 2019, 7:35:59 PM
    Author     : Rasmus2
--%>

<%@page import="Users.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Main Page</title>
    </head>
    <body>
        <h1>Main landing page!</h1>
        <form action="/Cupcake/FrontController?action=addmoney" method="POST">
            <input type="text" name="amount" placeholder="Enter amount"/>
            <input type="submit" value="Add money to account"/>
        </form>
        <%
            if (session.getAttribute("User") != null) {
                User u = (User) session.getAttribute("User");
                out.println("<p>" + "User: " + u.getUserName() + ", Balance: " + u.getBalance() + "</p>");
            }
        %>
        <form action="/Cupcake/FrontController?action=shop" method="post">
            <input type="submit" value="Shop" />
        </form>
        <br>
        <form action="/Cupcake/FrontController?action=logOut" method="post">
            <input type="submit" value="Logout" />
        </form>
    </body>
</html>
