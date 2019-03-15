<%-- 
    Document   : shop
    Created on : Mar 4, 2019, 5:53:51 PM
    Author     : Rasmus2
--%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page import="Data.DataMapper"%>
<%@page import="Shop.shoppingCart"%>
<%@page import="Users.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Shop.lineItems"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <link rel="stylesheet" type="text/css" href="css.css">
</head> 

<h1>Shop</h1>
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
<form action="/Cupcake/FrontController?action=shop" method="post">

    <table class="table table-striped">
        <thead id="tabled"><tr><th>Topping</th><th>Bottom</th><th>Quantity</th><th>Select</th><th></th></tr></thead>
        <tbody>
            <tr>
                <td><select name="topping" id="toppingSelect">
                        <option value="0">Choose topping</option>
                        <option value="Chocolate">Chocolate: 5.0</option><option value="Blueberry">Blueberry: 5.0</option><option value="Rasberry">Rasberry: 5.0</option><option value="Crispy">Crispy: 6.0</option><option value="Strawberry">Strawberry: 6.0</option><option value="Rum/Raisin">Rum/Raisin: 7.0</option><option value="Lemon">Lemon: 8.0</option><option value="Orange">Orange: 8.0</option><option value="Blue cheese">Blue cheese: 9.0</option>
                    </select></td>
                <td><select name="bottom" id="bottomSelect">
                        <option value="0">Choose bottom</option>
                        <option value="Chocolate">Chocolate: 5.0</option><option value="Vanilla">Vanilla: 5.0</option><option value="Nutmeg">Nutmeg: 5.0</option><option value="Pistacio">Pistacio: 6.0</option><option value="Almond">Almond: 7.0</option>
                    </select></td>
                <td><input type="text" name="qty" placeholder="quantity" id="qtyInput"></td>
                <td><input type="submit" name="submit" value="Add to cart"></td><td><span id="errorContainer"></span></td>
            </tr>
        </tbody>
    </table>
</form>
<form> 
    <table id="shopped" class="table">
        <%
            double total = 0.0;
            if (session.getAttribute("ArrayList<lineItems>") != null) {
                shoppingCart arOld = (shoppingCart) session.getAttribute("ArrayList<lineItems>");
                for (int i = 0; i < arOld.size(); i++) {
                    out.println("<tr><td>" + arOld.get(i).toString() + "</td></tr>");
                    total = total + arOld.get(i).getFullPrice();
                }
            }
        %>
    </table>
</form>

<form id="formed">
    <%
        out.println("<tr><td>" + "Total: " + total + "</td></tr>");
    %>
</form>
<%
    if (session.getAttribute("User") != null) {
        User u = (User) session.getAttribute("User");
        DataMapper data = new DataMapper();
        if (total < u.getBalance()) {
            out.println("<form action=\"/Cupcake/FrontController?action=confirmation\" method=\"post\"><input type=\"submit\" value=\"Checkout\" /></form>");
            data.removeFromBalance(u, total);
            User newu = data.getInfoFromUsername(u.getUserName(), u.getPassword());
            session.setAttribute("User", newu);
        } else {
            out.println("<form action=\"/Cupcake/FrontController?action=error\" method=\"post\"><input type=\"submit\" value=\"Checkout\" /></form>");
        }
    }
%>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>