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
import java.util.Timer;
import javafx.util.Duration;

public class DataMapper {
    
    

    private Connection connection = DBConnector.getConnection();
    
    /**
    *  @param JavaDoc
    * 
    * This method return an user object from the input og a name and a password
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

            String query = "select orders.lineitems_id from orders where "
                    + "invoice_id = " + invoice_number + ";";

            try (
                    Statement st = connection.createStatement()) {

                ResultSet rs = st.executeQuery(query);
                List<Integer> list = new ArrayList<Integer>();

                while (rs.next()) {

                    lineitems_number = rs.getInt("lineitems_id");
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
                String query = "INSERT INTO cupcake.lineitems (lineitems_id, "
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

    public void addToBalance(User user, double newMoney) {
        String query = "UPDATE cupcake.user SET balance = balance +" + newMoney
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

    public ArrayList<Invoice> getAllInvoicesForCustomer(String username,
            String password) throws Exception { //Giver exceptions på 9
        ArrayList<Invoice> allInvoices = new ArrayList<>();
        Date date = null;
        ArrayList<Integer> invoicesNumbers = getAllInvoiceForUser(username,
                password);
        for (int i = 0; i < invoicesNumbers.size(); i++) {
            shoppingCart cart = new shoppingCart();
            int lineitems_id = 0;
            try {
                String query = "SELECT orders.lineitems_id, orders.orderdate "
                        + "from orders where invoice_id = " + invoicesNumbers.get(
                                i) + ";";
                try (
                        Statement st = connection.createStatement()) {
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        lineitems_id = rs.getInt("lineitems_id");
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
                        + "from lineitems where lineitems_id = " + lineitems_id + ";";
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

    public ArrayList<Integer> getAllInvoiceForUser(String username,
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

    public double getBalanceFromDB(String name, String password) {
        double balance = 0;
        try {
            String query = "SELECT balance from cupcake.user where user.username = "
                    + "'" + name + "'" + " and user.password = " + "'" + password + "'" + ";";
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

    public static void main(String[] args) throws Exception {
        User user = new User(2, "Ditlev", "12345", 2.5);
        DataMapper mapper = new DataMapper();

        long start = System.currentTimeMillis();
        System.out.println(mapper.getAllInvoices().toString());
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        float elapsedTimeSec = elapsedTimeMillis / 1000F;
        System.out.println(elapsedTimeSec);
    }
}
