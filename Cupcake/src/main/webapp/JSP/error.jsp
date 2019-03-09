<%-- 
    Document   : error
    Created on : Mar 5, 2019, 10:53:35 AM
    Author     : rh
--%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<h1>Error</h1>
<p>Ups something went wrong!</p>
<form action="/Cupcake/FrontController" method="post">
    <input type="submit" value="Back to main page" />
</form>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
