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
import Users.MakeNewUser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Users.User;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jdk.nashorn.internal.ir.LiteralNode;

/**
 *
 * @author Rasmus2
 */
public class DataMapper {

    public ArrayList<Invoice> getInvoiceFromUsername(String inputUsername) {
        int userId;
        int invoiceId;
        String password;
        double balance;
        String username = "";

        ArrayList<Invoice> invIdList = new ArrayList();

        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT invoice_id, user.* FROM invoice INNER JOIN user ON user.idUser = invoice.idUser WHERE username = " + "'" + inputUsername + "'" + ";";

            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                userId = rs.getInt("idUser");
                username = rs.getString("username");
                password = rs.getString("password");
                balance = rs.getDouble("balance");

                User user = new User(userId, username, password, balance);

                shoppingCart sC;

                while (rs.next()) {
                    //invoiceId = rs.getInt("invoiceId"); 
                    //shoppingCart sC = new shoppingCart();

                    Invoice iV = new Invoice(sC = new shoppingCart(), user, LocalDate.now());

                    invIdList.add(iV);
                }
                connection.close();
            }
        } catch (Exception e) {
            System.err.println("Got an exception! 1");
            System.err.println(e.getMessage());
        }

        if (inputUsername.equals(username)) {
            return invIdList;
        } else {
            System.out.println("User not found!");
            return null;
        }
    }

    public User getInfoFromUsername(String inputUsername, String inputPassword) {
        double balance = 0.0;
        String password = "";
        String username = "";
        int id = 0;
        try {

            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM user Where username = " + "'" + inputUsername + "'" + " and password = " + "'" + inputPassword + "'" + ";";

            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    id = rs.getInt("idUser");
                    username = rs.getString("username");
                    password = rs.getString("password");
                    balance = rs.getDouble("balance");

                }
                connection.close();
            }
        } catch (Exception e) {
            System.err.println("Got an exception! 2");
            System.err.println(e.getMessage());
        }

        if (inputUsername.equals(username)) {
            User user = new User(id, username, password, balance);
            System.out.println(user.getUserName());
            return user;
        } else {
            System.out.println("User not found!");
            return null;
        }
    }

    public boolean getInfo_Username_Password(String inputUsername, String inputPassword) {
        boolean findUser = false;
        double balance = 0.0;
        String password = "";
        String username = "";
        int id = 0;

        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            return false;
        }

        try {

            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM user Where username = " + "'"
                    + inputUsername + "'" + " and password = " + "'" + inputPassword + "'" + ";";

            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    id = rs.getInt("idUser");
                    username = rs.getString("username");
                    password = rs.getString("password");
                    balance = rs.getDouble("balance");

                }
                connection.close();
            }
        } catch (Exception e) {
            System.err.println("Got an exception! 3");
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
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            String query = "select user.idUser from user where username = " + "'" + invoice.getUser().getUserName() + "'" + " and password=" + "'" + invoice.getUser().getPassword() + "'" + ";";
            PreparedStatement pstmt = connection.prepareStatement(query);
            try ( // create the java statement
                    Statement st = connection.createStatement()) {

//            statement.executeUpdate(query);
                pstmt.execute();
                connection.close();
            }
        } catch (Exception e) {

            e.getLocalizedMessage();

        }

        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            String query = "INSERT INTO cupcake.invoice (idUser) VALUES (?);";
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setInt(1, invoice.getUser().getIdUser());

            pstmt.execute();
            connection.close();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            String query = "select invoice.invoice_id from invoice where idUser = " + invoice.getUser().getIdUser() + ";";
            PreparedStatement pstmt = connection.prepareStatement(query);
            try ( // create the java statement
                    Statement st = connection.createStatement()) {

//            statement.executeUpdate(query);
                pstmt.execute();
                connection.close();
            }
        } catch (Exception e) {

            e.getLocalizedMessage();

        }
        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();

            String query = "select invoice.invoice_id from invoice where idUser = " + invoice.getUser().getIdUser() + ";";

            try ( // create the java statement
                    Statement st = connection.createStatement()) {

                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    invoice_number = rs.getInt("invoice_id");

                }

                connection.close();
            }

        } catch (Exception e) {
            System.err.println("Got an exception! 4");
            System.err.println(e.getMessage());
        }

        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            String query = "INSERT INTO cupcake.orders (invoice_id, orderdate) VALUES (?,?);";
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setInt(1, invoice_number);
            pstmt.setDate(2, Date.valueOf(LocalDate.now()));
            pstmt.execute();
            connection.close();
        } catch (Exception ee) {
            ee.getLocalizedMessage();
        }

        try {
            DBConnector conn = new DBConnector();
            Connection connection = DBConnector.getConnection();

            String query = "select orders.lineitems_id from orders where invoice_id = " + invoice_number + ";";

            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);
                List<Integer> list = new ArrayList<Integer>();
                // iterate through the java resultset
                while (rs.next()) {

                    lineitems_number = rs.getInt("lineitems_id");
                    list.add(lineitems_number);

                }
                lineitems_number = Collections.max(list);

                connection.close();
            }

        } catch (Exception es) {
            System.err.println("Got an exception! 5");
            System.err.println(es.getMessage());
        }

        for (int i = 0; i < invoice.getCart().getCart().size(); i++) {
            try {
                DBConnector conn = new DBConnector();
                Connection connection = conn.getConnection();
                String query = "INSERT INTO cupcake.lineitems (lineitems_id, bottomname, toppingname, quantity) VALUES (?,?,?,?);";
                PreparedStatement pstmt = connection.prepareStatement(query);
                ArrayList<lineItems> list = invoice.getCart().getCart();

                pstmt.setInt(1, lineitems_number);
                pstmt.setString(2, list.get(i).getCup().getBottom().getName());
                pstmt.setString(3, list.get(i).getCup().getTop().getName());
                pstmt.setInt(4, list.get(i).getQuantity());
                pstmt.execute();
                connection.close();

            } catch (Exception ew) {

                ew.getLocalizedMessage();

            }
        }
    }

    public void addToBalance(User user, double newMoney) {
        String query = "UPDATE cupcake.user SET balance = balance +" + newMoney + "where idUser= " + user.getIdUser() + ";";
        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.execute();
            connection.close();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

    public void removeFromBalance(User user, double money) {
        String query = "UPDATE cupcake.user SET balance = balance -" + money + "where idUser= " + user.getIdUser() + ";";
        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.execute();
            connection.close();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }

    }

    public ArrayList<Invoice> getAllInvoicesForCustomerFromView(String Username) {
        ArrayList<Invoice> allInvoices = new ArrayList<>();
        ArrayList<Integer> allLineItems = new ArrayList<>();
        int idUser = 0;
        String username = "";
        String password = "";
        int invoiceid = 0;
        int lineitems_id = 0 ;
        shoppingCart cart = new shoppingCart();
         try {

            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            String query = "select * from cupcake.allInvoices2 where username = " + "'" + Username + "';";

            PreparedStatement pstmt = connection.prepareStatement(query);

            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    idUser = rs.getInt("idUser");
                    username = rs.getString("username");
                    invoiceid = rs.getInt("invoice_id");
                    lineitems_id = rs.getInt("lineitems_id");
                    password = rs.getString("password");


                    User user = new User(idUser, username, password, 0.0);


                    
                    
                   
                    

                }
                connection.close();

            }

        } catch (Exception es) {
            System.err.println("Got an exception! 6");
            System.err.println(es.getMessage());
        }
        
        return null;
    }

    public ArrayList<Invoice> getAllInvoicesForCustomer(User user) throws Exception { //Giver exceptions på 9

        ArrayList<Invoice> allInvoices = new ArrayList<>();
        List<Integer> invoicesNumbers = new ArrayList<>();
        int idUser = 0;
        Date date = null;

        try {
            
            Connection connection = DBConnector.getConnection();
            String query = "select user.IdUser from user where username = " + "'" + user.getUserName() + "'" + " and password = " + "'" + user.getPassword() + "'" + ";";

            

            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    idUser = rs.getInt("idUser");

                }
                

            }

        } catch (Exception es) {
            System.err.println("Got an exception! 6");
            System.err.println(es.getMessage());
        }

        try {
            
            Connection connection = DBConnector.getConnection();
            String query = "select invoice.invoice_id from invoice where idUser =" + "'" + idUser + "'" + ";";

            PreparedStatement pstmt = connection.prepareStatement(query);

            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                int invoice_id = 0;

                while (rs.next()) {
                    invoice_id = rs.getInt("invoice_id");
                    invoicesNumbers.add(invoice_id);

                }
                

                
            }

        } catch (Exception a) {
            System.err.println("Got an exception! 7");
            System.err.println(a.getMessage());
        }

        for (int i = 0; i < invoicesNumbers.size(); i++) {
            
            shoppingCart cart = new shoppingCart();
            int lineitems_id = 0;
            ArrayList<cupcake> tempCup = new ArrayList<>();

            try {
                
                Connection connection = DBConnector.getConnection();
                String query = "SELECT orders.lineitems_id, orders.orderdate from orders where invoice_id = " + invoicesNumbers.get(i) + ";";

                

                try ( // create the java statement
                        Statement st = connection.createStatement()) {
                    // execute the query, and get a java resultset
                    ResultSet rs = st.executeQuery(query);

                    // iterate through the java resultset
                    while (rs.next()) {
                        lineitems_id = rs.getInt("lineitems_id");
                        date = rs.getDate("orderdate");

                    }
                    

                }
            } catch (Exception es) {
                System.err.println("Got an exception! 8");
                System.err.println(es.getMessage());
                es.printStackTrace();
            }

            try {
                
                Connection connection = DBConnector.getConnection();
                String query = "SELECT lineitems.bottomname, lineitems.toppingname, lineitems.quantity from lineitems where lineitems_id = " + lineitems_id + ";";

                

                try ( // create the java statement
                        Statement st = connection.createStatement()) {
                    // execute the query, and get a java resultset
                    ResultSet rs = st.executeQuery(query);
                    String bottomname = "";
                    String toppingname = "";
                    double price;
                    

                    int quantity = 0;

                    // iterate through the java resultset
                    while (rs.next()) {
                        CupcakeMapper mapper = new CupcakeMapper();
                        bottomname = rs.getString("bottomname");
                        toppingname = rs.getString("toppingname");
                        quantity = rs.getInt("quantity");
                        //mapper.getBottomPriceFromName(bottomname);
                        
                        Bottoms bottom = new Bottoms(bottomname, 0);

                        Toppings top = new Toppings(toppingname, 0);

                        cupcake cup = new cupcake(bottom, top, 0);
                        lineItems lineitems = new lineItems(quantity, cup);

                        cart.add(lineitems);
                        Invoice invoice = new Invoice(cart, user, date.toLocalDate());
                    allInvoices.add(invoice);

                    }
                    
                    
                    CupcakeMapper cake = new CupcakeMapper();
                    for(int h = 0; h < allInvoices.size(); h++) {
                    for(int q = 0; q < allInvoices.get(h).getCart().getCart().size() ; q++) {
                  double bottomPrice = cake.getBottomPriceFromName(allInvoices.get(h).getCart().get(q).getCup().getBottom().getName());
                  allInvoices.get(h).getCart().get(q).getCup().getBottom().setPrice(bottomPrice);
                  
              }
                    }
              
              for(int a = 0; a < allInvoices.size(); a++) {
              for(int b = 0; b < allInvoices.get(a).getCart().getCart().size() ; b++) {
                  double topPrice = cake.getTopPriceFromName(allInvoices.get(a).getCart().get(b).getCup().getTop().getName());
                  allInvoices.get(a).getCart().get(b).getCup().getTop().setPrice(topPrice);
                  
              }
              }
               for(int x = 0; x < allInvoices.size(); x++) {
                   
                   for(int z = 0; z < allInvoices.get(x).getCart().size(); z++) {
                       
                       double botPrice = allInvoices.get(x).getCart().get(z).getCup().getBottom().getPrice();
                       double topPrice = allInvoices.get(x).getCart().get(z).getCup().getTop().getPrice();
                       allInvoices.get(x).getCart().get(z).setFullPrice(botPrice + topPrice);
                   }
               }     

                    
                    
                }

            } catch (Exception es) {
                System.err.println("Got an exception! 9");
                System.err.println(es.getMessage());
            }

        }
        

    
        return allInvoices;
    }

    public boolean isAdmin(String username, String password) {
        int isAdmin = 0;
        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            String query = "select user.isAdmin from user where username = " + "'" + username + "'" + " and password=" + "'" + password + "'" + ";";
            PreparedStatement pstmt = connection.prepareStatement(query);
            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    isAdmin = rs.getInt("isAdmin");

                }

                connection.close();

            }
        } catch (Exception e) {
            System.err.println("Got an exception! b");
            System.err.println(e.getMessage());

        }
        if (isAdmin == 1) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<User> getAllUsers() {
        ArrayList<Integer> users = new ArrayList<>();
        ArrayList<ArrayList<Invoice>> allInvoices = new ArrayList<>();
        List<Integer> invoicesNumbers = new ArrayList<>();
        ArrayList<User> allUsers = new ArrayList<>();
        int idUser = 0;
        String username = "";
        String password = "";
        double balance = 0.0;

        Date date = null;

        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            String query = "select idUser, username, password, balance from user;";

            PreparedStatement pstmt = connection.prepareStatement(query);

            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    idUser = rs.getInt("idUser");
                    username = rs.getString("username");
                    password = rs.getString("password");
                    balance = rs.getDouble("balance");

                    User user = new User(idUser, username, password, balance);
                    allUsers.add(user);

                }
                connection.close();

            }

        } catch (Exception es) {
            System.err.println("Got an exception! 6");
            System.err.println(es.getMessage());
        }

        return allUsers;
    }

    public ArrayList<ArrayList<Invoice>> getAllInvoices(ArrayList<User> users) throws Exception {
        DataMapper mapper = new DataMapper();
        ArrayList<ArrayList<Invoice>> allInvoices = new ArrayList();
        for (int i = 0; i < users.size(); i++) {
            allInvoices.add(mapper.getAllInvoicesForCustomer(users.get(i)));
        }

        return allInvoices;
    }

    public static void main(String[] args) throws Exception {
        User user = new User(2, "Ditlev", "12345", 2.5);
//        CupcakeMapper cake = new CupcakeMapper();
          DataMapper mapper = new DataMapper();
//          mapper.getAllInvoicesForCustomer(user);
//          ArrayList<Invoice> list = mapper.getAllInvoicesForCustomer(user);
//          System.out.println(list.toString());
//          
//          shoppingCart cart = new shoppingCart();
        ArrayList<ArrayList<Invoice>> list = mapper.getAllInvoices(mapper.getAllUsers());
                  System.out.println(list.toString());
          
          
         
//          mapper.addToBalance(user, 10);
          
//          MakeNewUser newuser = new MakeNewUser();
//          User user = new User(0, "Jorgen", "jorgen123", 100.0);
//          newuser.createNewUser(user);
//          System.out.println(user.toString());
//          mapper.getInfoFromUsername("Jorgen", "jorgen123");
          
//          
//          System.out.println(mapper.getAllInvoices(mapper.getAllUsers()) + "\n");
//        List<Invoice> list = mapper.getAllInvoicesForCustomer(user);

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//            System.out.println(list.get(i).getCart().toString());
//
//        }
//        System.out.println(mapper.isAdmin("Ole", "1234"));
    }
    
        public double getBalanceFromDB(String name, String password) {
        double balance = 0;
         try {

            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT balance from cupcake.user where user.username = " + "'" + name + "'" + " and user.password = " + "'" + password +"'"+ ";";

            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    
                    balance = rs.getDouble("balance");
                    System.out.println("here");

                }

                connection.close();
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        System.out.println(balance);
        return balance;
        
        
//         try {
//            DBConnector conn = new DBConnector();
//            Connection connection = conn.getConnection();
//             Statement st = connection.createStatement(); {
//               
//                ResultSet rs = st.executeQuery(query); 
//            
//            
//            while (rs.next()) {
//                
//                    balance = rs.getDouble("balance");
//                System.out.println(balance);
//                }
//            
//            connection.close();
//         }
//            } catch (Exception e) {
//            e.getLocalizedMessage();
//        
//    }
//         System.out.println(balance);
//         return balance;
        }
}
