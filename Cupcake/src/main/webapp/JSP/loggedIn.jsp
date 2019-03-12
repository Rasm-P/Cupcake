<%-- 
    Document   : loggedIn
    Created on : Mar 4, 2019, 7:37:25 PM
    Author     : Rasmus2
--%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page import="java.util.ArrayList"%>
<%@page import="Data.DataMapper"%>
<%@page import="Users.User"%>
<%@page import="java.time.LocalDate"%>
<%@page import="Shop.Invoice"%>
<%@page import="Shop.lineItems"%>
<%@page import="Shop.shoppingCart"%>
<%@page import="Data.transaction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <link rel="stylesheet" type="text/css" href="css.css">
</head> 

<h1>Logged in</h1>
<form action="/Cupcake/FrontController?action=addmoney" method="POST">
    <input type="text" name="amount" placeholder="Enter amount"/>
    <input type="submit" value="Add money to account"/>
</form>
<%
    if (session.getAttribute("User") != null) {
        DataMapper data = new DataMapper();
        User u = (User) session.getAttribute("User");
        out.println("<p>" + "User: " + u.getUserName() + ", Balance: " + u.getBalance() + "</p>");
    }
%>
<br>
<h2>All Your Invoices</h2>
<form> 
    <table class="table">
        <%
            User u = (User) session.getAttribute("User");
            DataMapper data = new DataMapper();
            if (data.getAllInvoicesForCustomer(u) != null) {
                ArrayList<Invoice> arIn = data.getAllInvoicesForCustomer(u);
                for (int i = 0; i < arIn.size(); i++) {
                    out.println("<h3> Invoice " + (i + 1) + ":" + "</h3>");
                    //out.println("<div id=\"divList\">");
                    out.println("<tr><td>" + "Toral: " + arIn.get(i).getCart().getToal() + " Invoice size: " + arIn.get(i).getCart().size() + " User: " + arIn.get(i).getUser().getUserName() + " Date: " + arIn.get(i).getDate().toString());
                    out.println(" <form action=\"/Cupcake/FrontController?action=invoice\" method=\"post\"> <input type=\"hidden\" name=\"in\" value=\"" + arIn.get(i).getCart().toString() + "\"> <input type=\"submit\" value=\"See invoice\" /> </form>"  + "<tr><td>");
                    //out.println("<br>");
                    //out.println("</div>");
                }
            }
        %>
    </table>
</form> 

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>



