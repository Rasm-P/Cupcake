/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Cupcake.Bottoms;
import Cupcake.Toppings;
import Cupcake.cupcake;
import static Data.CupcakeMapper.getOneBottom;
import static Data.CupcakeMapper.getOneToppings;
import static Data.DataMapper.getInfo_Username_Password;
import Shop.lineItems;
import static Users.MakeNewUser.createNewUser;
import Users.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmus2
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        System.out.println("-------------------------");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String topping = request.getParameter("topping");
        String bottom = request.getParameter("bottom");
        String qty = request.getParameter("qty");

        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");

        if (loggedIn == null && username == null && !"makeLogin".equals(action)) {
            System.out.println("0.5");
            //PageLogin.generateLogin(response);
            response.sendRedirect("JSP/login.jsp");
        }
        System.out.println("1");

        if (null == action) {
            //PageMain.generateMain(response);
            response.sendRedirect("JSP/mainPage.jsp");
        } else {
            System.out.println("2");
            switch (action) {
                case "makeLogin":
                    System.out.println(username);
                    System.out.println(password);
                    if (username != null && !"".equals(username) && password != null && !"".equals(password) && getInfo_Username_Password(username, password) == false) {
                        System.out.println("2.5");
                        User u = new User(1, username, password, 0.0);
                        createNewUser(u);
                        //PageLogin.generateLogin(response);
                        response.sendRedirect("JSP/login.jsp");

                        break;
                    } else {
                        System.out.println("2.75");
                        //PageMakeLogin.generateMakeLogin(response);
                        response.sendRedirect("JSP/loginRegistration.jsp");
                        break;
                    }
                case "login":
                    System.out.println("3");
                    if (username != null && password != null && getInfo_Username_Password(username, password) == true) {
                        System.out.println("3.25");
                        session.setAttribute("loggedIn", true);
                        User u = new User(1, username, password, 0.0);
                        session.setAttribute("User", u);
                        //PageLoggedIn.generateLoggedIn(response);
                        response.sendRedirect("JSP/loggedIn.jsp");
                        break;
                    } else {
                        //PageLogin.generateLogin(response);
                        response.sendRedirect("JSP/login.jsp");
                        break;
                    }
                case "logOut":
                    System.out.println("3.5");
                    session.setAttribute("User", null);
                    session.setAttribute("ArrayList<lineItems>", null);
                    session.setAttribute("loggedIn", false);
                    //PageLogin.generateLogin(response);
                    response.sendRedirect("JSP/login.jsp");
                    break;
                case "shop":
                    System.out.println(topping);
                    System.out.println(bottom);
                    System.out.println(qty);
                    if (topping != null && !"".equals(topping) && bottom != null && !"".equals(bottom) && qty != null && !"".equals(qty) && Integer.parseInt(qty) >= 1) {
                        ArrayList<lineItems> arList = new ArrayList<>();

                        Bottoms b = getOneBottom(bottom);
                        Toppings t = getOneToppings(topping);
                        System.out.println(t.toString());
                        System.out.println(b.toString());
                        cupcake c = new cupcake(b, t, b.getPrice() + t.getPrice());

                        lineItems l = new lineItems(Integer.parseInt(qty), c);
                        arList.add(l);

                        if (session.getAttribute("ArrayList<lineItems>") != null) {
                            ArrayList<lineItems> arOld = (ArrayList<lineItems>) session.getAttribute("ArrayList<lineItems>");
                            for (int i = 0; i < arOld.size(); i++) {
                                arList.add(arOld.get(i));
                                session.setAttribute("ArrayList<lineItems>", arList);
                            }
                        } else {
                            session.setAttribute("ArrayList<lineItems>", arList);
                        }

                        System.out.println(session.getAttribute("ArrayList<lineItems>").toString());
                        //PageShop.generateShop(response);
                        response.sendRedirect("JSP/shop.jsp");
                        break;
                    } else {
                        //PageShop.generateShop(response);
                        response.sendRedirect("JSP/shop.jsp");
                    }
                    break;
                case "confirmation":
                    System.out.println("3.95");
                    if (session.getAttribute("ArrayList<lineItems>") != null) {
                        response.sendRedirect("JSP/confirmationPage.jsp");
                        break;
                    } else {
                        response.sendRedirect("JSP/shop.jsp");
                    }
                    break;
            }
        }
        System.out.println("4");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
