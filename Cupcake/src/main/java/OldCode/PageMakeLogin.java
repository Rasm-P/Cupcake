<<<<<<< HEAD:Cupcake/src/main/java/OldCode/PageMakeLogin.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OldCode;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rasmus2
 */
public class PageMakeLogin {

    public static void generateMakeLogin(HttpServletResponse response) throws IOException {
        System.out.println("makeing login");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Make login</h1>");
            out.println("<p>");
            out.println("<form>" +
            "<input type=\"hidden\" name=\"action\" value=\"makeLogin\"><br>" +
            "Username:<br>" +
            "<input type=\"text\" name=\"username\" value=\"\"><br>" +
            "Login:<br>" +
            "<input type=\"text\" name=\"password\" value=\"\"><br><br>" +
            "<input type=\"submit\" value=\"Create account\">" +
            "</form>");
            out.println("</p>");
            out.println("<p><a href=\"/Cupcake/FrontController?action=login\">Log in</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
        System.out.println("made login");
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rasmus2
 */
public class PageMakeLogin {

    public static void generateMakeLogin(HttpServletResponse response) throws IOException {
        System.out.println("makeing login");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Create account!</h1>");
            out.println("<p>");
            out.println("<form>" +
            "<input type=\"hidden\" name=\"action\" value=\"makeLogin\"><br>" +
            "Username:<br>" +
            "<input type=\"text\" name=\"username\" value=\"\"><br>" +
            "Login:<br>" +
            "<input type=\"text\" name=\"password\" value=\"\"><br><br>" +
            "<input type=\"submit\" value=\"Create account\">" +
            "</form>");
            out.println("</p>");
            out.println("<p><a href=\"/Cupcake/FrontController?action=login\">Log in</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
        System.out.println("made login");
    }
    
}
>>>>>>> b364da3fcf4ed35813666b53b94b338289d7b89d:Cupcake/src/main/java/Presentation/PageMakeLogin.java
