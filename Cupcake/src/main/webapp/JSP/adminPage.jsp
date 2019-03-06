<%-- 
    Document   : adminPage
    Created on : Mar 6, 2019, 10:13:57 AM
    Author     : rh
--%>

<%@page import="Shop.Invoice"%>
<%@page import="java.util.ArrayList"%>
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
            if (session.getAttribute("User") != null) {
                User u = (User) session.getAttribute("User");
                out.println("<p>" + "User: " + u.getUserName() + ", Balance: " + u.getBalance() + ", Du er nu logget ind som admin!</p>");
            }
        %>
        <form action="/Cupcake/FrontController" method="post">
            <input type="submit" value="Back to main page" />
        </form>
        <br>
        <form action="/Cupcake/FrontController?action=logOut" method="post">
            <input type="submit" value="Logout" />
        </form>
        <br>
        <h2>All Invoices</h2>
        <table class="table">
            <%
                User u = (User) session.getAttribute("User");
                DataMapper data = new DataMapper();
                if (data.getAllInvoicesForCustomer(u) != null) {
                    ArrayList<Invoice> arIn = data.getAllInvoicesForCustomer(u);
                    for (int i = 0; i < arIn.size(); i++) {
                        out.println("<tr><td>" + arIn.get(i).getCart().toString() + arIn.get(i).getUser().toString() + arIn.get(i).getDate().toString() + "</td></tr>");
                        out.println(" <form action=\"/Cupcake/FrontController?action=invoice\" method=\"post\"> <input type=\"hidden\" name=\"in\" value=\"" + arIn.get(i).getCart().toString() + "\"> <input type=\"submit\" value=\"See invoice\" /> </form>");
                    }
                }
            %>
        </table>
    </body>
</html>
