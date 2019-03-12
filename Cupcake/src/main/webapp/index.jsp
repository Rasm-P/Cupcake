<%-- 
    Document   : index
    Created on : Mar 4, 2019, 10:06:10 AM
    Author     : Rasmus2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css.css">
    </head>
    <body>       
        <div id ="DivIn" style="background:pink !important" class = "jumbotron">
            <h1>The Cupcake Shop!</h1>
            <p id = "pIn"> Welcome to the cupcake shop</p>
        </div>
        <br>         
        <div id="Div2" class="container" style="background:pink !important">
            <p id="pIn" class="p2">Login to the cupcake shop here</p>
            <h2><a href="/Cupcake/FrontController">Log in</a></h2>
        </div>  
    </body>
</html>