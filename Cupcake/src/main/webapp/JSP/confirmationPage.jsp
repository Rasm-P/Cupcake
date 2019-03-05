<%-- 
    Document   : confirmationPage
    Created on : Mar 4, 2019, 8:04:37 PM
    Author     : Rasmus2
--%>

<%@page import="Data.transaction"%>
<%@page import="Data.DataMapper"%>
<%@page import="Shop.Invoice"%>
<%@page import="java.time.LocalDate"%>
<%@page import="Users.User"%>
<%@page import="Shop.shoppingCart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Shop.lineItems"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
        <h1>Confirmation</h1>
        <h2>Thank you for your purchase!</h2>
        <form action="/Cupcake/FrontController?action=confirmation" method="post">
            <%
                DataMapper d = new DataMapper();
                User u = (User) session.getAttribute("User");
                double total = 0.0;
                shoppingCart arOld = (shoppingCart) session.getAttribute("ArrayList<lineItems>");
                for (int i = 0; i < arOld.size(); i++) {
                    out.println("<p>" + arOld.get(i).toString() + "</p>");
                    total = total + arOld.get(i).getFullPrice();
                }
                
                Invoice in = new transaction(arOld, u, LocalDate.now());
                d.createOrder(in);

                out.println("<p>" + "Total: " + total + "</p>");
                session.setAttribute("ArrayList<lineItems>", null);
            %>
        </form>
        <form action="/Cupcake/FrontController" method="post">
            <input type="submit" value="Back to main page" />
        </form>
    </body>
</html>
