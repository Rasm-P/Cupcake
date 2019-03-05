<%-- 
    Document   : shop
    Created on : Mar 4, 2019, 5:53:51 PM
    Author     : Rasmus2
--%>

<%@page import="Shop.shoppingCart"%>
<%@page import="Users.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Shop.lineItems"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Shop</title>
    </head>
    <body>
        <h1>Cupcakeshop </h1>
        <form action="/Cupcake/FrontController?action=shop" method="post">
            <%
                if (session.getAttribute("User") != null) {
                    User u = (User) session.getAttribute("User");
                    out.println("<p>" + "User: " + u.getUserName() + ", Balance: " + u.getBalance() + "</p>");
                }
            %>
            <table class="table table-striped">
                <thead><tr><th>Topping</th><th>Bottom</th><th>Quantity</th><th>Select</th><th></th></tr></thead>
                <tbody>
                    <tr>
                        <td><select name="topping" id="toppingSelect">
                                <option value="0">Choose topping</option>
                                <option value="Chocolate">Chocolate: 5.0</option><option value="Blueberry">Blueberry: 5.0</option><option value="Rasberry">Rasberry: 5.0</option><option value="Crispy">Crispy: 6.0</option><option value="Strawberry">Strawberry: 6.0</option><option value="Rum/Raisin">Rum/Raisin: 7.0</option><option value="Lemon">Lemon: 8.0</option><option value="Orange">Orange: 8.0</option><option value="Blue cheese">Blue cheese: 9.0</option>
                            </select></td>
                        <td><select name="bottom" id="bottomSelect">
                                <option value="0">Choose bottom</option>
                                <option value="Chocolate">Chocolate: 5.0</option><option value="Vanilla">Vanilla: 5.0</option><option value="Nutmeg">Nutmeg: 5.0</option><option value="Pistacio">Pistacio: 6.0</option><option value="Almond">Almond: 7.0</option>
                        </td>
                        <td><input type="text" name="qty" placeholder="quantity" id="qtyInput"></td>
                        <td><input type="submit" name="submit" value="Add to cart"></td><td><span id="errorContainer"></span></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <table class="table">
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


        <table class="table">
            <%
                out.println("<tr><td>" + "Total: " + total + "</td></tr>");
            %>
        </table>
        <form action="/Cupcake/FrontController?action=confirmation" method="post">
            <input type="submit" value="Checkout" />
        </form>
        <br>
        <form action="/Cupcake/FrontController" method="post">
            <input type="submit" value="Back to main page" />
        </form>
    </body>
</html>
