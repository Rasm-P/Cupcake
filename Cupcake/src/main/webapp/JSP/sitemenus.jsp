<%@page import="Data.DataMapper"%>
<%@page import="Users.User"%>

<%  
    User userLoggedIn = (User) session.getAttribute("User");
%>

<div id="sitemenus">

    <nav id="site">
        <a href=".">Home</a>
        <%
            DataMapper data = new DataMapper();
            if(userLoggedIn != null && data.isAdmin(userLoggedIn.getUserName(),userLoggedIn.getPassword()) == true)
            {
                %>
                    <a href="Controller?command=userslist">Users</a>
                <%
            }
        %>
    </nav>

    <nav id="user">
        
        <%
            if(userLoggedIn == null)
            {
                %>
                    <a href="jsp/userregister.jsp">Register</a>
                    <a href="jsp/userlogin.jsp">Log in</a>
                <%
            }
            else
            {
                %>
                    <a href="jsp/userinfo.jsp"><%= userLoggedIn.getUserName()%></a>
                    <a href="Controller?command=userlogout">Log out</a>
                    <form action="Controller?command=userlogout" method="post">
                        <input type="submit" value="Log out" />
                    </form>
                <%
            }
        %>
        
    </nav>
    
</div>