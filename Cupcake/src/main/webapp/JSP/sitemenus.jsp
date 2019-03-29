<%@page import="CupcakeData.DataMapper"%>
<%@page import="CupcakeLogic.User"%>

<%
    User userLoggedIn = (User) session.getAttribute("User");
%>

<div id="sitemenus">

    <nav id="site">

        <%
            if (userLoggedIn != null) {
        %>
        <a href="/Cupcake/FrontController">Home</a>
        <%
        } else {
        %>
        <a href=".">Home</a>
        <%
            }
        %>

        <%
            DataMapper data = new DataMapper();
            if (userLoggedIn != null && data.isAdmin(userLoggedIn.getUserName(), userLoggedIn.getPassword()) == true) {
        %>
        <a href="/Cupcake/FrontController?action=admin">Admin page</a>
        <%
            }
        %>
    </nav>

    <nav id="user">

        <%
            if (userLoggedIn == null) {
        %>
        <a href="JSP/loginRegistration.jsp">Register</a>
        <a href="JSP/login.jsp">Log in</a>
        <%
        } else {
        %>
        <a href="JSP/shop.jsp">Shop</a>
        <a href="/Cupcake/FrontController?action=logOut">Log out</a>
        <%
            }
        %>

    </nav>

</div>