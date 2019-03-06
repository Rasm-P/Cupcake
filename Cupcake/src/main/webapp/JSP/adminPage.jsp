<%-- 
    Document   : adminPage
    Created on : Mar 6, 2019, 10:13:57 AM
    Author     : rh
--%>

<%@page import="Users.User"%>
<%@page import="Data.DataMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <h1>Admin</h1>

        <%
            DataMapper d = new DataMapper();
            if (session.getAttribute("User") != null) {
                User u = (User) session.getAttribute("User");
                out.println("<p>" + "User: " + u.getUserName() + "</p>");
                out.println("<p> Du er nu logget ind som admin!" + "</p>");
                
                
            }

        %>
    </body>
</html>
