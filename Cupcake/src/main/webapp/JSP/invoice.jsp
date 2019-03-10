<%-- 
    Document   : invoice
    Created on : Mar 6, 2019, 9:56:14 AM
    Author     : Rasmus2
--%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page import="Shop.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.DataMapper"%>
<%@page import="Users.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Invoice</h1>
<table class="table">
    <%
        if (session.getAttribute("chosenInvoice") != null) {
            String in = (String) session.getAttribute("chosenInvoice");
            User u = (User) session.getAttribute("User");
            DataMapper data = new DataMapper();
            if (data.getAllInvoicesForCustomer(u.getUserName(), u.getPassword()) != null) {
                ArrayList<Invoice> arIn = data.getAllInvoicesForCustomer(u.getUserName(), u.getPassword());
                for (int i = 0; i < arIn.size(); i++) {
                    if (in.equals(arIn.get(i).getCart().toString())) {
                        out.println("<td><tr>" + arIn.get(i).toString() + "</td></tr>");
                    }
                }
            }
        }
    %>
</table>
<form action="/Cupcake/FrontController" method="post">
    <input type="submit" value="Back to main page" />
</form>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
