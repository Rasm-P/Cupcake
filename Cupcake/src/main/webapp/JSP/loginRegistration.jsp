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
                margin: auto;
                text-align: center;
                color: blue;
            }

            h1.solid {
                margin: auto;
                border-left-style: dotted;
                border-right-style: dotted;
                border-top-style: solid;
                border-bottom-style: solid;
                width: 400px;
                text-align: center;
            }
            
            body {
                max-width:vw;
                max-height:vh;
                background-image: url(https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.mrbreakfast.com%2Fimages%2F979_double_chocolate_muffins.jpg&f=1);
            }
            
            p{
                margin: auto;
                text-align: center;
                width:100px;
            }
        </style>
    </head>
    <body>
        <div>
            <h1 class="solid">Login Registration</h1><img src ="https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.XudpHfMmkSpYY9N_uNoEFAHaHy%26pid%3D15.1&f=1" height = "100">
        </div>
        <form action="/Cupcake">
            <input type="submit" value="Go to startpage" />
        </form>   
            <div id ="Div1" class="container">
                <form action="/Cupcake/FrontController?action=makeLogin" method="post">
                    <p style="background-color:Tomato;">Username:</p>
                    <input type="text" name="username" value=""> 
                    <br> 
                    <p style="background-color:Tomato;">Login:</p>
                    <input type="text" name="password" value="">
                    <br><br>
                    <input type="submit" value="Create account">
                </form>
                <form action="/Cupcake/FrontController?action=login" method="post">
                    <input type="submit" value="Log in" />
                </form>
            </div>
    </body>
</html>
