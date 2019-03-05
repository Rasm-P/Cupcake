<<<<<<< HEAD
=======

>>>>>>> 9da7a381734e0924a0bc510faea8aa7fa5756a97
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
public class PageMain {

    public static void generateMain(HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Main landing page!</h1>");
            out.println("<p><a href=\"/Cupcake/FrontController?action=shop\">Shop</a></p>");
            out.println("<p><a href=\"/Cupcake/FrontController?action=logOut\">Logout</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
<<<<<<< HEAD
}
=======
}
>>>>>>> 9da7a381734e0924a0bc510faea8aa7fa5756a97
