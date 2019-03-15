<%-- 
    Document   : adminPage
    Created on : Mar 6, 2019, 10:13:57 AM
    Author     : rh
--%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page import="Shop.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Users.User"%>
<%@page import="Data.DataMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <link rel="stylesheet" type="text/css" href="css.css">
</head> 

<h1>Admin Page</h1>
<h2>Du er logget ind som admin!</h2>
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
<br>
<h2>All User Invoices</h2>
<table id="tableIn" class="table">
    <%
        if (session.getAttribute("User") != null) {
            DataMapper data = new DataMapper();
            if (data.getAllInvoices() != null) {
                ArrayList<User> us = data.getAllUsers();
                for (int j = 0; j < us.size(); j++) {
                    User user = us.get(j);
                    for (int i = 0; i < data.getAllInvoicesForCustomer(user.getUserName(), user.getPassword()).size(); i++) {
                        out.println("<tr><td>" + "<p>" + data.getAllInvoicesForCustomer(user.getUserName(), user.getPassword()).get(i).toString() + "</p>");
                        out.println("<form action=\"/Cupcake/FrontController?action=invoice\" method=\"post\"> <input type=\"hidden\" name=\"in\" value=\"" + data.getAllInvoicesForCustomer(user.getUserName(), user.getPassword()).get(i).getCart().toString() + "\"> <input type=\"submit\" value=\"See invoice\" /> </form>" + "<tr><td>");
                    }
                }
            }
        }
    %>
</table>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>