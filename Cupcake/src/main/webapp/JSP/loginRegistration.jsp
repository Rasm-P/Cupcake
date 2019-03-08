<%-- 
    Document   : LoginRegistration
    Created on : Mar 4, 2019, 4:53:23 PM
    Author     : Rasmus2
--%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div>
    <h1>Login Registration</h1>
    <div id ="Div1" class="container">
        <form action="/Cupcake/FrontController?action=makeLogin" method="post"><br>Username:<br><input type="text" name="username" value=""><br>Login:<br><input type="text" name="password" value=""><br><br><input type="submit" value="Create account"></form>
    </div>
</div>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
