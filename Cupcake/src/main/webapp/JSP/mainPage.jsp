<%-- 
    Document   : mainPage
    Created on : Mar 4, 2019, 7:35:59 PM
    Author     : Rasmus2
--%>

<%@page import="Shop.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.DataMapper"%>
<%@page import="Users.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Main Page</title>
    </head>
    <body>
        <h1>Main landing page</h1>
        <form action="/Cupcake/FrontController?action=addmoney" method="POST">
            <input type="text" name="amount" placeholder="Enter amount"/>
            <input type="submit" value="Add money to account"/>
        </form>
        <%
            if (session.getAttribute("User") != null) {
                DataMapper data = new DataMapper();
                User u = (User) session.getAttribute("User");
                out.println("<p>" + "User: " + u.getUserName() + ", Balance: " + u.getBalance() + "</p>");
                if (data.isAdmin(u.getUserName(), u.getPassword())) {
                    out.println("<form action=\"/Cupcake/FrontController?action=admin\" method=\"post\"> <input type=\"submit\" value=\"Go to admin page\" /> </form>");
                    out.println("<br>");
                }
            }
        %>
        <br>
        <form action="/Cupcake/FrontController?action=shop" method="post">
            <input type="submit" value="Shop" />
        </form>
        <br>
        <form action="/Cupcake/FrontController?action=logOut" method="post">
            <input type="submit" value="Logout" />
        </form>
        <h2>All Your Invoices</h2>
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
