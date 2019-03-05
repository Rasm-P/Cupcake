<%-- 
    Document   : loggedIn
    Created on : Mar 4, 2019, 7:37:25 PM
    Author     : Rasmus2
--%>

<%@page import="Users.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logged In</title>
    </head>
    <body>
        <h1>Logged in!</h1>
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
