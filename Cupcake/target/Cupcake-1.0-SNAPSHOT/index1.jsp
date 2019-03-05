<%-- 
    Document   : index
    Created on : Mar 4, 2019, 10:06:10 AM
    Author     : Rasmus2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <nav> 
            <a href="/Cupcake/FrontController">Log in</a>
        </nav>
        <%
            String message = "<p>hej</p>";
            out.println(message);
        %>

        <%= message%>

    </body>
</html>
