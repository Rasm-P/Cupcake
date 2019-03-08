<%-- 
    Document   : Login
    Created on : Mar 4, 2019, 5:41:35 PM
    Author     : Rasmus2
--%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <style> 
            div{
                margin: auto;
                text-align: center;
                width:600px;
            }
            body{
                max-width:vw;
                max-height:vh;
                background-image: url(https://images4.alphacoders.com/149/1494.jpg);
            }
        </style>
    </head>
    <body>
        <div>
            <h1>Login</h1>       
            <br> 
            <form action="/Cupcake/FrontController?action=login" method="post">
                <p>Username:<p><input type="text" name="username" value=""><br>
                Login:<br><input type="password" name="password" value=""><br>
                <br>               
                <input type="submit" value="Login"></form>

            </form>
        </div>
    </body>
</html>


<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>