<%-- 
    Document   : confirmationPage
    Created on : Mar 4, 2019, 8:04:37 PM
    Author     : Rasmus2
--%>

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
                double total = 0.0;
                ArrayList<lineItems> arOld = (ArrayList<lineItems>) session.getAttribute("ArrayList<lineItems>");
                for (int i = 0; i < arOld.size(); i++) {
                    out.println("<p>" + arOld.get(i).toString() + "</p>");
                    total = total + arOld.get(i).getFullPrice();
                }

                out.println("<p>" + "Total: " + total + "</p>");
                session.setAttribute("ArrayList<lineItems>", null);
            %>
        </form>
        <form action="/Cupcake/FrontController" method="post">
            <input type="submit" value="Back to main page" />
        </form>
    </body>
</html>
