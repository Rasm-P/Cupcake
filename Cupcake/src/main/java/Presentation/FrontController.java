/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Cupcake.Bottoms;
import Cupcake.Toppings;
import Cupcake.cupcake;
import Data.CupcakeMapper;
import Data.DataMapper;
import Shop.lineItems;
import Shop.shoppingCart;
import Users.MakeNewUser;
import Users.User;
import java.io.IOException;
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

    private DataMapper data = new DataMapper();
    private CupcakeMapper cupdata = new CupcakeMapper();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String topping = request.getParameter("topping"); //is sent from shop.jsp
        String bottom = request.getParameter("bottom"); //is sent from shop.jsp
        String qty = request.getParameter("qty"); //is sent from shop.jsp
        String amount = request.getParameter("amount");
        String in = request.getParameter("in");
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");

        if (loggedIn == null && username == null && !"makeLogin".equals(action)) {
            response.sendRedirect("JSP/login.jsp");
        }

        if (null == action && session.getAttribute("User") != null) {
            response.sendRedirect("JSP/mainPage.jsp");
        } else {
            switch (action) {
                case "makeLogin":
                    makeLogin(username, password, response);
                    break;
                case "login":
                    login(username, password, session, response);
                    break;
                case "logOut":
                    logOut(session, response);
                    break;
                case "shop":
                    shop(topping, bottom, qty, session, response);
                    break;
                case "confirmation":
                    confirmation(session, response);
                    break;
                case "addmoney":
                    addMoney(amount, session, response);
                    break;
                case "error":
                    error(response);
                    break;
                case "invoice":
                    invoice(in, session, response);
                    break;
                case "admin":
                    adminPage(response);
                    break;
            }
        }
    }
    
    /**
     * Redirects user to adminPage.jsp
     * 
     * @param response
     * @throws IOException 
     */
    private void adminPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("JSP/adminPage.jsp");
    }

    /**
     * Sets the attribute for invoice and redirects to invoice.jsp
     * 
     * @param in
     * @param session
     * @param response
     * @throws IOException 
     */
    private void invoice(String in, HttpSession session,
            HttpServletResponse response) throws IOException {
        session.setAttribute("chosenInvoice", in);
        response.sendRedirect("JSP/invoice.jsp");
    }

    /**
     * Redirects user to the error page
     * 
     * @param response
     * @throws IOException 
     */
    private void error(HttpServletResponse response) throws IOException {
        response.sendRedirect("JSP/error.jsp");
    }
    
    /**
     * Adds a specified amount of money to the account of the user that is currently logged in 
     * and redirects to mainPage.jsp
     * 
     * @param amount
     * @param session
     * @param response
     * @throws NumberFormatException
     * @throws IOException 
     */
    private void addMoney(String amount, HttpSession session,
            HttpServletResponse response) throws NumberFormatException, IOException {
        if (amount != null && !"".equals(amount) && Double.parseDouble(amount) >= 0.0) {

            DataMapper d = new DataMapper();

            User u = (User) session.getAttribute("User");

            d.addToBalance(u, Double.parseDouble(amount));
            User newu = data.getInfoFromUsername(u.getUserName(),
                    u.getPassword());
            session.setAttribute("User", newu);
        }
        response.sendRedirect("JSP/mainPage.jsp");
    }

    /**
     * Redirects the user to confirmationPage.jsp if the user has made an order, 
     * otherwise the user stays in the shop.jsp
     * 
     * @param session
     * @param response
     * @throws IOException 
     */
    private void confirmation(HttpSession session, HttpServletResponse response) throws IOException {
        if (session.getAttribute("ArrayList<lineItems>") != null) {
            response.sendRedirect("JSP/confirmationPage.jsp");

        } else {
            response.sendRedirect("JSP/shop.jsp");
        }
    }
    
    /**
     * Sets an arraylist of lineitems as attribute when making an order in the shop
     * and redirects to shop.jsp
     * 
     * @param topping
     * @param bottom
     * @param qty
     * @param session
     * @param response
     * @throws IOException
     * @throws NumberFormatException 
     */
    private void shop(String topping, String bottom, String qty,
            HttpSession session,
            HttpServletResponse response) throws IOException, NumberFormatException {
        if (topping != null && !"".equals(topping) && bottom != null && !"".equals(
                bottom)
                && qty != null && !"".equals(qty) && Integer.parseInt(qty) >= 1) {
            shoppingCart arList = new shoppingCart();
            Bottoms b = cupdata.getOneBottom(bottom);
            Toppings t = cupdata.getOneToppings(topping);
            cupcake c = new cupcake(b, t, b.getPrice() + t.getPrice());
            lineItems l = new lineItems(Integer.parseInt(qty), c);
            arList.add(l);
            if (session.getAttribute("ArrayList<lineItems>") != null) {
                shoppingCart arOld = (shoppingCart) session.getAttribute(
                        "ArrayList<lineItems>");
                for (int i = 0; i < arOld.size(); i++) {
                    arList.add(arOld.get(i));
                    session.setAttribute("ArrayList<lineItems>", arList);
                }
            } else {
                session.setAttribute("ArrayList<lineItems>", arList);
            }
            response.sendRedirect("JSP/shop.jsp");
        } else {
            response.sendRedirect("JSP/shop.jsp");
        }
    }

    /**
     * Changes all attributes so the user is logged out and redirects to login.jsp
     * 
     * @param session
     * @param response
     * @throws IOException 
     */
    private void logOut(HttpSession session, HttpServletResponse response) throws IOException {
        session.setAttribute("User", null);
        session.setAttribute("ArrayList<lineItems>", null);
        session.setAttribute("loggedIn", false);
        response.sendRedirect("JSP/login.jsp");
    }

    /**
     * Creates a new user and redirects to login.jsp,
     * or redirects one to loginRegistration.jsp
     * 
     * @param username
     * @param password
     * @param response
     * @throws Exception 
     */
    private void makeLogin(String username, String password,
            HttpServletResponse response) throws Exception {
        MakeNewUser mn = new MakeNewUser();
        if (username != null && !"".equals(username) && password != null && !"".equals(
                password)
                && data.getInfo_Username_Password(username, password) == false) {
            User u = new User(1, username, password, 0.0);
            mn.createNewUser(u);
            response.sendRedirect("JSP/login.jsp");
        } else {
            response.sendRedirect("JSP/loginRegistration.jsp");
        }
    }

    /**
     * Logs an existing user in or redirects to login.jsp
     * 
     * @param username
     * @param password
     * @param session
     * @param response
     * @throws IOException 
     */
    private void login(String username, String password, HttpSession session,
            HttpServletResponse response) throws IOException {
        if (username != null && password != null && data.getInfo_Username_Password(
                username, password) == true) {
            session.setAttribute("loggedIn", true);
            double b = data.getBalanceFromDB(username, password);
            User u = new User(1, username, password, b);
            session.setAttribute("User", u);
            response.sendRedirect("JSP/loggedIn.jsp");
        } else {
            response.sendRedirect("JSP/login.jsp");
        }
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
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE,
                    null, ex);
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE,
                    null, ex);
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
