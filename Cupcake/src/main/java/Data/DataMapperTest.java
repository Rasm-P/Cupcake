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
import Users.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rumle
 */
public class DataMapperTest {
    
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
                es.getStackTrace();
            }

        }
        

    
        return allInvoices;
    }
    public static void main(String[] args) throws Exception {
        User user = new User(2, "Ditlev", "12345", 2.5);
//        CupcakeMapper cake = new CupcakeMapper();
          DataMapperTest mapper = new DataMapperTest();
          mapper.getAllInvoicesForCustomer(user);
    
}
    }
