<%-- 
    Document   : LoginRegistration
    Created on : Mar 4, 2019, 4:53:23 PM
    Author     : Rasmus2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Registration</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- <link rel="stylesheet" type="text/css" href="registration.css"/> --%>
        <style>
            #Div1 { 
                border: solid 1px blue;
                width:600px;
                border: 40px solid #402811;
                padding: 10px;
                margin: auto;
                font-size: 20px;
                text-align: center;
            }

            h1{
                text-align: center;
                color: blue;
            }

            #Div2{
                width:vw;
            }

            h1.solid {
                margin: auto;
                border-left-style: dotted;
                border-right-style: dotted;
                border-top-style: solid;
                border-bottom-style: solid;
                width: 400px;
            }
            
            body {
                background-image: url("cupcake-3723832_960_720.jpg");
            }
        </style>
    </head>
    <body>
        <div id="Div2" class="container">
            <h1 class="solid">Login Registration</h1><img src ="https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.XudpHfMmkSpYY9N_uNoEFAHaHy%26pid%3D15.1&f=1" height = "100">
        </div>
        <form action="/Cupcake">
            <input type="submit" value="Go to startpage" />
        </form>   
            <div id ="Div1" class="container">
                <form action="/Cupcake/FrontController?action=makeLogin" method="post"><br>Username:<br><input type="text" name="username" value=""><br>Login:<br><input type="text" name="password" value=""><br><br><input type="submit" value="Create account"></form>
                <form action="/Cupcake/FrontController?action=login" method="post">
                    <input type="submit" value="Log in" />
                </form>
            </div>
        <div id ="Div1">
            <form action="/Cupcake/FrontController?action=makeLogin" method="post"><br>Username:<br><input type="text" name="username" value=""><br>Login:<br><input type="text" name="password" value=""><br><br><input type="submit" value="Create account"></form>
            <form action="/Cupcake/FrontController?action=login" method="post">
                <input type="submit" value="Log in" />
            </form>
        </div>
    </body>
</html>
