package Shop;


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
public class PageShop {
    public static void generateShop(HttpServletResponse response) throws IOException
    {       
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Shoppen</title>");
            out.println("</head>");
            
            out.println("<body bgcolor=\"#00ffff\">");

            out.println("<h1> Velkommen til cupcakeshoppen </h1>");
            
            out.println(" <form id=\"addProduct\" action=\"Control\" method=\"POST\">");
            out.println("<input type=\"hidden\" name=\"origin\" value=\"addProduct\">");
            out.println("<table class=\"table table-striped\">");
            out.println("<thead><tr><th>Bottom</th><th>Topping</th><th>Quantity</th><th>Select</th><th></th></tr></thead>");
            out.println("<tbody>");
            out.println(" <tr>");
            out.println("<td><select name=\"bottom\" id=\"bottomSelect\">");
            out.println("<option value=\"0\">Choose bottom</option>");
            out.println("<option value=\"1\">Chocolate: 5.0</option><option value=\"2\">Blueberry: 5.0</option><option value=\"3\">Raspberry: 5.0</option><option value=\"4\">Crispy: 6.0</option><option value=\"5\">Strawberry: 6.0</option><option value=\"6\">Rum/Raisin: 7.0</option><option value=\"7\">Orange: 8.0</option><option value=\"8\">Lemon: 8.0</option>");
            out.println("</select></td>");
            out.println("<td><select name=\"topping\" id=\"toppingSelect\">");
            out.println("<option value=\"0\">Choose topping</option>");
            out.println(" <option value=\"1\">Chocolate: 5.0</option><option value=\"2\">Vanilla: 5.0</option><option value=\"3\">Nutmeg: 5.0</option><option value=\"4\">Pistacio: 6.0</option><option value=\"5\">Almond: 7.0</option>");
            out.println("</select></td>");
            out.println(" <td><input type=\"text\" name=\"qty\" placeholder=\"quantity\" id=\"qtyInput\"></td>");
            out.println("<td><input type=\"submit\" name=\"submit\" value=\"Add to cart\"></td><td><span id=\"errorContainer\"></span></td>");
            out.println("</tr>");
            out.println(" </tbody>");
            out.println("</table>");
            out.println("</form>");
            out.println("<table class=\"table table-striped\"><thead><tr><th>Name</th><th>Quantity</th><th>Price</th><th>Total</th><th>Remove</th></tr></thead><tbody><tr><td><h4>Total price</h4></td><td></td><td></td><td id=\"totalprice\"></td><td><form id=\"checkoutForm\" action=\"Control\" method=\"POST\"><input type=\"hidden\" name=\"origin\" value=\"submitInvoice\"/><input type=\"submit\" value=\"Check out your order\"></form></td></tr>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("<div id=\"errmsg\"></div>");
            out.println(" </div>");
            out.println("</div>");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            
            out.println("</body>");
            out.println("</html>");
        }
    }   
}