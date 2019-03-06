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
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Rasmus2
 */
public class DataMapper {
    
<<<<<<< HEAD
    public static  ArrayList<Invoice> getInvoiceFromUsername(String inputUsername) {
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
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        if(inputUsername.equals(username)) {
            return invIdList;
        } else {
            System.out.println("User not found!");
            return null;
        }
    }
=======
    
>>>>>>> 023be667a7588e2d7b4955f5fa5d5e8159141a4c

    public static User getInfoFromUsername(String inputUsername, String inputPassword) {
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
            System.err.println("Got an exception! ");
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

    public static boolean getInfo_Username_Password(String inputUsername, String inputPassword) {
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
            System.err.println("Got an exception! ");
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
      
//   public static void main(String[] args) {
//       String username = "Rasmus";
//       String password = "1234";
//       System.out.println(getInfo_Username_Password(username, password));
//       
//    }
//   
    
public static void createOrder(Invoice invoice) throws Exception {
        int invoice_number = 0;
        int lineitems_number = 0;
        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            String query = "select user.idUser from user where username = " + "'" + invoice.getUser() + "'" + " and password=" + "'" + invoice.getUser().getPassword() + "'" + ";";
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
        } try {
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
            System.err.println("Got an exception! ");
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
            Connection connection = conn.getConnection();

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
            System.err.println("Got an exception! ");
            System.err.println(es.getMessage());
        }
  
    for(int i = 0; i < invoice.getCart().getCart().size();i++) {
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


<<<<<<< HEAD
//    public static void main(String[] args) {
//        Bottoms bottom = new Bottoms("Chokolatechip", 10);
//        Toppings top = new Toppings("Vanilla", 12);
//        Bottoms bottom1 = new Bottoms("Chokolatechip", 10);
//        Toppings top1 = new Toppings("Vanilla", 12);
//        Bottoms bottom2 = new Bottoms("Chokolatechip", 10);
//        Toppings top2 = new Toppings("Vanilla", 12);
//        
//        cupcake cup = new cupcake(bottom, top, String.valueOf(bottom.getPrice() + top.getPrice()));
//        cupcake cup1 = new cupcake(bottom1, top1, String.valueOf(bottom1.getPrice() + top1.getPrice()));
//        cupcake cup2 = new cupcake(bottom2, top2, String.valueOf(bottom2.getPrice() + top2.getPrice()));
//        
//        lineItems it = new lineItems(2, cup);
//        lineItems it1 = new lineItems(5, cup1);
//        lineItems it2 = new lineItems(10, cup2);
//        Shop.shoppingCart cart = new Shop.shoppingCart();
//        //Invoice invoice = new Invoice(cart, )
//        cart.addToCart(cup, 1);
//        cart.addToCart(cup1, 1);
//        cart.addToCart(cup2, 1);
//        
//        for(int i = 0; i < cart.getCart().size(); i++) {
//            System.out.println(cart.getCart().get(i).toString());
//        }
//        saveShoppingCart(in);
//        Shop.shoppingCart.getCart().add(cup);
//        Shop.shoppingCart.getCart().add(cup1);
//        Shop.shoppingCart.getCart().add(cup2);
=======
    


>>>>>>> 023be667a7588e2d7b4955f5fa5d5e8159141a4c
        
     public static void addToBalance(User user, double newMoney) {
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
    
     public static void removeFromBalance(User user, double money) {
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
<<<<<<< HEAD
        }    
=======
        }
     
    public static ArrayList<Invoice> getAllInvoicesForCustomer(User user) throws Exception {

        ArrayList<Invoice> allInvoices = new ArrayList<>();
        List<Integer> invoicesNumbers = new ArrayList<>();
        int idUser = 0;
        Date date = null;

        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            String query = "select user.IdUser from user where username = " + "'" + user.getUserName() + "'" + " and password = " + "'" + user.getPassword() + "'" + ";";

            PreparedStatement pstmt = connection.prepareStatement(query);

            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    idUser = rs.getInt("idUser");

                }
                connection.close();

            }

        } catch (Exception es) {
            System.err.println("Got an exception! ");
            System.err.println(es.getMessage());
        }

        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
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

                connection.close();
            }

        } catch (Exception a) {
            System.err.println("Got an exception! ");
            System.err.println(a.getMessage());
        }

        for (int i = 0; i < invoicesNumbers.size(); i++) {
            shoppingCart cart = new shoppingCart();
            int lineitems_id = 0;

            try {
                DBConnector conn = new DBConnector();
                Connection connection = conn.getConnection();
                String query = "SELECT orders.lineitems_id, orders.orderdate from orders where invoice_id = " + invoicesNumbers.get(i) + ";";

                PreparedStatement pstmt = connection.prepareStatement(query);

                try ( // create the java statement
                        Statement st = connection.createStatement()) {
                    // execute the query, and get a java resultset
                    ResultSet rs = st.executeQuery(query);

                    // iterate through the java resultset
                    while (rs.next()) {
                        lineitems_id = rs.getInt("lineitems_id");
                        date = rs.getDate("orderdate");

                    }
                    connection.close();

                }
            } catch (Exception es) {
                System.err.println("Got an exception! ");
                System.err.println(es.getMessage());
            }

            try {
                DBConnector conn = new DBConnector();
                Connection connection = conn.getConnection();
                String query = "SELECT lineitems.bottomname, lineitems.toppingname, lineitems.quantity from lineitems where lineitems_id = " + lineitems_id + ";";

                PreparedStatement pstmt = connection.prepareStatement(query);

                try ( // create the java statement
                        Statement st = connection.createStatement()) {
                    // execute the query, and get a java resultset
                    ResultSet rs = st.executeQuery(query);
                    String bottomname = "";
                    String toppingname = "";

                    int quantity = 0;

                    // iterate through the java resultset
                    while (rs.next()) {
                        bottomname = rs.getString("bottomname");
                        toppingname = rs.getString("toppingname");
                        quantity = rs.getInt("quantity");
                        Bottoms bottom = new Bottoms(bottomname, CupcakeMapper.getBottomPriceFromName(bottomname));
                        Toppings top = new Toppings(toppingname, CupcakeMapper.getTopPriceFromName(toppingname));
                        cupcake cup = new cupcake(bottom, top, CupcakeMapper.getBottomPriceFromName(bottomname) + CupcakeMapper.getTopPriceFromName(toppingname));

                        lineItems lineitem = new lineItems(quantity, cup);
                        cart.add(lineitem);

                    }

                    Invoice invoice = new Invoice(cart, user, date.toLocalDate());
                    allInvoices.add(invoice);
                    connection.close();
                }

            } catch (Exception es) {
                System.err.println("Got an exception! ");
                System.err.println(es.getMessage());
            }

        }
        return allInvoices;

    }
    public static void main(String[] args) throws Exception{
        User user = new User(2, "Ditlev", "12345", 2.5);
        List<Invoice> list = getAllInvoicesForCustomer(user);
       
        
        
//        for(int i = 0; i < list.size() ;i++) {
//        
//                for(int j = 0; j < list.get(i).getCart().size(); j++) {
//                    
//                    System.out.println(list.get(j).getCart().get(i).toString());
//        
//        
//    }
//}
//    
}
        
>>>>>>> 023be667a7588e2d7b4955f5fa5d5e8159141a4c
}
