
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ludvig
 */
public class PageTest {
    public static void generateTest(HttpServletResponse response, String word) throws IOException
    {       
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Test</title>");
            out.println("</head>");
            
            out.println("<body bgcolor=\"#00ff00\">");

            out.println("<h1> Du har valgt </h1>");
            out.println(word);
            
            out.println("</body>");
            out.println("</html>");
        }
    }   
    
}
