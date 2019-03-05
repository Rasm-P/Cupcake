<<<<<<< HEAD
package OldCode;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

=======

package OldCode;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

>>>>>>> 9da7a381734e0924a0bc510faea8aa7fa5756a97
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
            out.println("<title>Shop</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cupcakeshop </h1>");
            out.println(" <form>");
            //out.println("<input type=\"hidden\" name=\"origin\" value=\"addProduct\">");
            out.println("<input type=\"hidden\" name=\"action\" value=\"shop\">");
            out.println("<table class=\"table table-striped\">");
            out.println("<thead><tr><th>Topping</th><th>Bottom</th><th>Quantity</th><th>Select</th><th></th></tr></thead>");
            out.println("<tbody>");
            out.println(" <tr>");
            out.println("<td><select name=\"topping\" id=\"toppingSelect\">");
            out.println("<option value=\"0\">Choose topping</option>");
            out.println("<option value=\"Chocolate\">Chocolate: 5.0</option><option value=\"Blueberry\">Blueberry: 5.0</option><option value=\"Raspberry\">Raspberry: 5.0</option><option value=\"Crispy\">Crispy: 6.0</option><option value=\"Strawberry\">Strawberry: 6.0</option><option value=\"Rum/Raisin\">Rum/Raisin: 7.0</option><option value=\"Orange\">Orange: 8.0</option><option value=\"Lemon\">Lemon: 8.0</option>");
            out.println("</select></td>");
            out.println("<td><select name=\"bottom\" id=\"bottomSelect\">");
            out.println("<option value=\"0\">Choose bottom</option>");
            out.println(" <option value=\"Chocolate\">Chocolate: 5.0</option><option value=\"Vanilla\">Vanilla: 5.0</option><option value=\"Nutmeg\">Nutmeg: 5.0</option><option value=\"Pistacio\">Pistacio: 6.0</option><option value=\"Almond\">Almond: 7.0</option>");
            out.println("</td>");
            out.println(" <td><input type=\"text\" name=\"qty\" placeholder=\"quantity\" id=\"qtyInput\"></td>");
            out.println("<td><input type=\"submit\" name=\"submit\" value=\"Add to cart\"></td><td><span id=\"errorContainer\"></span></td>");
            out.println("</tr>");
            out.println(" </tbody>");
            out.println("</table>");
            out.println("<table class=\"table table-striped\"><tbody><tr><td><h4>Total price</h4></td><td></td><td></td><td id=\"totalprice\"></td><td><form id=\"checkoutForm\" action=\"Control\" method=\"POST\"><input type=\"submit\" value=\"Check out your order\"></form></td></tr>");
            //<thead><tr><th>Name</th><th>Quantity</th><th>Price</th><th>Total</th><th>Remove</th></tr></thead>            
            //<input type=\"hidden\" name=\"origin\" value=\"submitInvoice\"/>
            out.println("</form>");
            out.println("</tbody>");
            out.println("</table>");
            //out.println("<div id=\"errmsg\"></div>");
            out.println(" </div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 9da7a381734e0924a0bc510faea8aa7fa5756a97
