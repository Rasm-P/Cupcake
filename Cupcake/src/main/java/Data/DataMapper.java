/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Cupcake.Bottoms;
import Cupcake.Toppings;
import Cupcake.cupcake;
import Shop.Invoice;
import Shop.lineItems;
import Shop.shoppingCart;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Users.User;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataMapper {
    
    

    private Connection connection = DBConnector.getConnection();
    
    /**
     * This method returns a user object from the input of a name and a password of an user.
     * The method send a query to the database and check if there is a user with 
     * the matching username and password. If the user don't exist, it will return null. 
     * 
     * @param inputUsername
     * @param inputPassword
     * @return User object who have the matching username and password
     */

    public User getInfoFromUsername(String inputUsername, String inputPassword) {
        double balance = 0.0;
        String password = "";
        String username = "";
        int id = 0;
        try {

            String query = "SELECT * FROM user Where username = " + "'"
                    + inputUsername + "'" + " and password = " + "'" + inputPassword + "'" + ";";

            try (
                    Statement st = connection.createStatement()) {

                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    id = rs.getInt("idUser");
                    username = rs.getString("username");
                    password = rs.getString("password");
                    balance = rs.getDouble("balance");

                }
                rs.close();
                st.closeOnCompletion();
            }
        } catch (Exception e) {
            System.err.println("Got an Exception in getInfoFromUsername");
            System.err.println(e.getMessage());
        }

        if (inputUsername.equals(username)) {
            User user = new User(id, username, password, balance);

            return user;
        } else {
            System.out.println("User not found!");
            return null;
        }
    }

    /**
     * Return true or false to whether or not there is a user in the database with the given
     * username and password.
     * 
     * @param inputUsername
     * @param inputPassword
     * @return true or false
     */
    public boolean getInfo_Username_Password(String inputUsername,
            String inputPassword) {
        boolean findUser = false;
        double balance = 0.0;
        String password = "";
        String username = "";
        int id = 0;

        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            return false;
        }

        try {

            String query = "SELECT * FROM user Where username = " + "'"
                    + inputUsername + "'" + " and password = " + "'" + inputPassword + "'" + ";";

            try (
                    Statement st = connection.createStatement()) {

                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    id = rs.getInt("idUser");
                    username = rs.getString("username");
                    password = rs.getString("password");
                    balance = rs.getDouble("balance");

                }
                rs.close();
                st.closeOnCompletion();

            }
        } catch (Exception e) {
            System.err.println("Got an exception in getInfo_Username_Password");
            System.err.println(e.getMessage());
        }

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            findUser = true;
            return findUser;
        } else {
            System.out.println("User not found!");
            return findUser;
        }
    }

    
    /**
     * create an invoice in the database. An invoice object consist of an user, a shoppingCart
     * and a date. It inserts the idUser into the invoice table which generate a unused number.
     * the invoice number for the idUser is inserted into the order table along with a orderdate
     * the order_id generate a unique order_id which is inserted into the lineitems table along with
     * all the objects in the shoppingCart.
     * 
     * @param invoice
     * @throws Exception 
     */
    public void createOrder(Invoice invoice) throws Exception {
        int invoice_number = 0;
        int lineitems_number = 0;
        try {

            String query = "select user.idUser from user where username = "
                    + "" + "'" + invoice.getUser().getUserName() + "'" + " and "
                    + "password=" + "'" + invoice.getUser().getPassword() + "'" + ";";
            PreparedStatement pstmt = connection.prepareStatement(query);
            try (
                    Statement st = connection.createStatement()) {

                pstmt.execute();

            }

            pstmt.closeOnCompletion();

        } catch (Exception e) {
            System.err.println("Got an exception in createOrder nr 1");
            e.getLocalizedMessage();

        }

        try {
            String query = "INSERT INTO cupcake.invoice (idUser) VALUES (?);";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, invoice.getUser().getIdUser());
            pstmt.execute();
            pstmt.closeOnCompletion();
        } catch (Exception e) {
            System.err.println("Got an exception in createOrder nr 2");
            e.getLocalizedMessage();
        }
        try {

            String query = "select invoice.invoice_id from invoice where idUser "
                    + "= " + invoice.getUser().getIdUser() + ";";
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.execute();

            pstmt.closeOnCompletion();
        } catch (Exception e) {
            System.err.println("Got an exception in createOrder nr 3");
            e.getLocalizedMessage();

        }
        try {

            String query = "select invoice.invoice_id from invoice where "
                    + "idUser = " + invoice.getUser().getIdUser() + ";";

            try (
                    Statement st = connection.createStatement()) {

                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    invoice_number = rs.getInt("invoice_id");

                }
                rs.close();
                st.closeOnCompletion();

            }

        } catch (Exception e) {
            System.err.println("Got an exception in createOrder nr 4");
            System.err.println(e.getMessage());
        }

        try {
            String query = "INSERT INTO cupcake.orders (invoice_id, orderdate) VALUES (?,?);";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, invoice_number);
            pstmt.setDate(2, Date.valueOf(LocalDate.now()));
            pstmt.execute();
            pstmt.closeOnCompletion();
        } catch (Exception ee) {
            System.err.println("Got an exception in createOrder nr 5");
            ee.getLocalizedMessage();
        }

        try {

            String query = "select orders.order_id from orders where "
                    + "invoice_id = " + invoice_number + ";";

            try (
                    Statement st = connection.createStatement()) {

                ResultSet rs = st.executeQuery(query);
                List<Integer> list = new ArrayList<Integer>();

                while (rs.next()) {

                    lineitems_number = rs.getInt("order_id");
                    list.add(lineitems_number);

                }
                rs.close();
                st.closeOnCompletion();
                lineitems_number = Collections.max(list);

            }

        } catch (Exception es) {
            System.err.println("Got an exception in createOrder nr 6");
            System.err.println(es.getMessage());
        }
        for (int i = 0; i < invoice.getCart().getCart().size(); i++) {
            try {
                String query = "INSERT INTO cupcake.lineitems (order_id, "
                        + "bottomname, toppingname, quantity) VALUES (?,?,?,?);";
                PreparedStatement pstmt = connection.prepareStatement(query);
                ArrayList<lineItems> list = invoice.getCart().getCart();
                pstmt.setInt(1, lineitems_number);
                pstmt.setString(2, list.get(i).getCup().getBottom().getName());
                pstmt.setString(3, list.get(i).getCup().getTop().getName());
                pstmt.setInt(4, list.get(i).getQuantity());
                pstmt.execute();
                pstmt.closeOnCompletion();
            } catch (Exception ew) {
                System.err.println("Got an exception in createOrder nr 7");
                ew.getLocalizedMessage();
            }
        }
    }

    /**
     * adds money to the user in the database who match the given user and idUser.
     * It finds the user from the idUser in the user object.
     * @param user
     * @param money 
     */
    
    public void addToBalance(User user, double money) {
        String query = "UPDATE cupcake.user SET balance = balance +" + money
                + "where idUser= " + user.getIdUser() + ";";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.execute();
            pstmt.closeOnCompletion();
        } catch (Exception e) {
            System.err.println("Got an exception in addToBalance");
            e.getLocalizedMessage();
        }
    }

    /**
     * removes money to the user in the database who match the given user and idUser.
     * It finds the user from the idUser in the user object
     * @param user
     * @param money 
     */
    
    public void removeFromBalance(User user, double money) {
        String query = "UPDATE cupcake.user SET balance = balance -" + money
                + "where idUser= " + user.getIdUser() + ";";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.execute();
            pstmt.closeOnCompletion();
        } catch (Exception e) {
            System.err.println("Got an exception in removeFromBalance");
            e.getLocalizedMessage();
        }

    }

    /**
     * returns an arraylist with all the invoices from user with the matching
     * username and password. 
     * @param username
     * @param password
     * @return Arraylist of invoice objects
     * @throws Exception 
     */
    
    public ArrayList<Invoice> getAllInvoicesForCustomer(String username,
            String password) throws Exception { //Giver exceptions på 9
        ArrayList<Invoice> allInvoices = new ArrayList<>();
        Date date = null;
        ArrayList<Integer> invoicesNumbers = getAllInvoiceIDForUser(username,
                password);
        for (int i = 0; i < invoicesNumbers.size(); i++) {
            shoppingCart cart = new shoppingCart();
            int order_id = 0;
            try {
                String query = "SELECT orders.order_id, orders.orderdate "
                        + "from orders where invoice_id = " + invoicesNumbers.get(
                                i) + ";";
                try (
                        Statement st = connection.createStatement()) {
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        order_id = rs.getInt("order_id");
                        date = rs.getDate("orderdate");
                    }
                    rs.close();
                    st.closeOnCompletion();
                }
            } catch (Exception es) {
                System.err.println("Got an exception in getAllInvoicesForCustomer nr 1");
                System.err.println(es.getMessage());
                es.printStackTrace();
            }

            try {

                String query = "SELECT lineitems.bottomname, "
                        + "lineitems.toppingname, lineitems.quantity "
                        + "from lineitems where order_id = " + order_id + ";";
                try (Statement st = connection.createStatement()) {
                    ResultSet rs = st.executeQuery(query);
                    String bottomname = "";
                    String toppingname = "";
                    int quantity = 0;
                    while (rs.next()) {
                        CupcakeMapper mapper = new CupcakeMapper();
                        bottomname = rs.getString("bottomname");
                        toppingname = rs.getString("toppingname");
                        quantity = rs.getInt("quantity");
                        double botPrice = mapper.getBottomPriceFromName(bottomname);
                        double topPrice = mapper.getTopPriceFromName(toppingname);
                        Bottoms bottom = new Bottoms(bottomname, botPrice);
                        Toppings top = new Toppings(toppingname, topPrice);
                        cupcake cup = new cupcake(bottom, top, botPrice + topPrice);
                        lineItems lineitems = new lineItems(quantity, cup);
                        int idUser = getUserID(username, password);
                        double balance = getBalanceFromDB(username, password);
                        User user = new User(idUser, username, password, balance);
                        cart.add(lineitems);
                        Invoice invoice = new Invoice(cart, user,
                                date.toLocalDate());
                        allInvoices.add(invoice);
                    }

                    rs.close();
                    st.closeOnCompletion();

                }

            } catch (Exception es) {
                System.err.println("Got an exception in getAllInvoicesForCustomer nr 2");
                System.err.println(es.getMessage());
            }

        }

        return allInvoices;
    }

    /**
     * finds the idUser in the database with the matching username and password.
     * @param username
     * @param password
     * @return an unique id for the user
     */
    
    public int getUserID(String username, String password) {
        int idUser = 0;
        try {

            String query = "select user.IdUser from user where username = "
                    + "'" + username + "'" + " and password = " + "'"
                    + password + "'" + ";";

            try (
                    Statement st = connection.createStatement()) {

                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    idUser = rs.getInt("idUser");
                }
                rs.close();
                st.closeOnCompletion();
            }
        } catch (Exception es) {
            System.err.println("Got an exception in getUserID");
            System.err.println(es.getMessage());
        }
        return idUser;
    }

    /**
     * finds all the invoice_id which is created by the user with the given username and password 
     * @param username
     * @param password
     * @return an arraylist of invoice_id
     */
    public ArrayList<Integer> getAllInvoiceIDForUser(String username,
            String password) {
        int idUser = getUserID(username, password);
        ArrayList<Integer> invoicesNumbers = new ArrayList<>();
        try {

            String query = "select invoice.invoice_id from invoice where idUser "
                    + "=" + "'" + idUser + "'" + ";";

            try (
                    Statement st = connection.createStatement()) {

                ResultSet rs = st.executeQuery(query);

                int invoice_id = 0;

                while (rs.next()) {
                    invoice_id = rs.getInt("invoice_id");
                    invoicesNumbers.add(invoice_id);

                }
                rs.close();
                st.closeOnCompletion();
            }
        } catch (Exception a) {
            System.err.println("Got an exception in getAllInvoiceForUser");
            System.err.println(a.getMessage());
        }
        return invoicesNumbers;
    }

    /**
     * checks whether the user with the matching username and password is an admin.
     * @param username
     * @param password
     * @return true or false
     */
    public boolean isAdmin(String username, String password) {
        int isAdmin = 0;
        try {

            String query = "select user.isAdmin from user where username = "
                    + "'" + username + "'" + " and password=" + "'" + password + "'" + ";";

            try (
                    Statement st = connection.createStatement()) {

                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    isAdmin = rs.getInt("isAdmin");
                }
                rs.close();
                st.closeOnCompletion();
            }
        } catch (Exception e) {
            System.err.println("Got an exception in isAdmin");
            System.err.println(e.getMessage());
        }
        if (isAdmin == 1) {
            return true;
        } else {
            return false;
        }
    }

    
    /**
     * finds all the registrated users in the user table in the database.
     * @return an Arraylist of user objects
     */
    public ArrayList<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<>();
        int idUser = 0;
        String username = "";
        String password = "";
        double balance = 0.0;
        try {
            String query = "select idUser, username, password, balance from user;";
            try (Statement st = connection.createStatement()) {
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    idUser = rs.getInt("idUser");
                    username = rs.getString("username");
                    password = rs.getString("password");
                    balance = rs.getDouble("balance");
                    User user = new User(idUser, username, password, balance);
                    allUsers.add(user);
                }
                rs.close();
                st.closeOnCompletion();
            }
        } catch (Exception es) {
            System.err.println("Got an exception in getAllUsers");
            System.err.println(es.getMessage());
        }

        return allUsers;
    }

    /**
     * this method loops through a list of all users and finds all the invoices
     * for that user. 
     * @return an arraylist of arraylist of invoices. Each index of the arraylist consist
     * of all invoices for an user.
     * @throws Exception 
     */
    public ArrayList<ArrayList<Invoice>> getAllInvoices() throws Exception {
        ArrayList<User> users = getAllUsers();
        DataMapper mapper = new DataMapper();
        ArrayList<ArrayList<Invoice>> allInvoices = new ArrayList();
        for (int i = 0; i < users.size(); i++) {
            allInvoices.add(mapper.getAllInvoicesForCustomer(
                    users.get(i).getUserName(), users.get(i).getPassword()));
        }

        return allInvoices;
    }

    
    /**
     * given the username and password the methods find the balance of the user
     * @param name
     * @param password
     * @return a double which represent the current balance of the user
     */
    public double getBalanceFromDB(String username, String password) {
        double balance = 0;
        try {
            String query = "SELECT balance from cupcake.user where user.username = "
                    + "'" + username + "'" + " and user.password = " + "'" + password + "'" + ";";
            try (Statement st = connection.createStatement()) {
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    balance = rs.getDouble("balance");
                }
                rs.close();
                st.closeOnCompletion();

            }
        } catch (Exception e) {
            System.err.println("Got an exception in getBalanceFromDB");
            System.err.println(e.getMessage());
        }
        return balance;
    }
}
