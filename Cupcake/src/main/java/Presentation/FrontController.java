/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import static Data.DataMapper.getInfo_Username_Password;
import static Users.MakeNewUser.createNewUser;
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
        /* Check for login and so on... */
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
               
        if (loggedIn == null && username == null) {
            System.out.println("0.5");
            PageLogin.generateLogin(response);
        }
        System.out.println("1");
   
        System.out.println("1.2");
        if (null == action) {
            PageMain.generateMain(response);
        } else {
            System.out.println("2");
            switch (action) {
                case "makeLogin":
                    System.out.println("2.5");
                    if (username != null && password != null && getInfo_Username_Password(username, password) == false) {
                        User u = new User(1, username, password, 0.0);
                        createNewUser(u);
                        PageLogin.generateLogin(response);
                        break;
                    } else {
                        PageMakeLogin.generateMakeLogin(response);
                        break;
                    }
                case "login":
                    System.out.println("3");
                    if (username != null && password != null && getInfo_Username_Password(username, password) == true) {
                        System.out.println("3.25");
                        session.setAttribute("loggedIn", true);
                        PageLoggedIn.generateLoggedIn(response);
                        break;
                    } else {
                        PageLogin.generateLogin(response);
                        break;
                    }
                case "logOut":
                    System.out.println("3.5");
                    session.setAttribute("loggedIn", false);
                    PageLogin.generateLogin(response);
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