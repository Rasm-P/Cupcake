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
 * @author Rasmus2
 */
public class DataMapperTryOut 
{
    public static ArrayList<Invoice> getAllInvoicesForCustomer() throws Exception { //Giver exceptions på 9

        ArrayList<Invoice> allInvoices = new ArrayList<>();
        List<Integer> invoicesNumbers = new ArrayList<>();
        int idUser = 0;
        String user = "";
        Date date = null;

        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            String query = "select user.* from user;";

            PreparedStatement pstmt = connection.prepareStatement(query);

            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    idUser = rs.getInt("idUser");
                    user = rs.getString("user");

                }
                connection.close();

            }

        } catch (Exception es) {
            System.err.println("Got an exception! 6");
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
                System.out.println(invoicesNumbers.toString());

                connection.close();
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
                System.err.println("Got an exception! 8");
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
                    double price;

                    int quantity = 0;

                    // iterate through the java resultset
                    while (rs.next()) {
                        CupcakeMapper mapper = new CupcakeMapper();
                        bottomname = rs.getString("bottomname");
                        toppingname = rs.getString("toppingname");
                        quantity = rs.getInt("quantity");
                        mapper.getBottomPriceFromName(bottomname);
                        System.out.println(bottomname);
                        Bottoms bottom = new Bottoms(bottomname, 0);
                        
                        Toppings top = new Toppings(toppingname, 0);
                        
                        cupcake cup = new cupcake(bottom, top, 0);
                        
                        

                        tempCup.add(cup);

                    }
                    
                    for(int j = 0; j < tempCup.size();j++) {
                        CupcakeMapper mapper = new CupcakeMapper();
                        tempCup.get(j).getBottom().setPrice( mapper.getBottomPriceFromName(tempCup.get(j).getBottom().getName()));
                        tempCup.get(j).getTop().setPrice(mapper.getTopPriceFromName(tempCup.get(j).getTop().getName()));
                          mapper.getTopPriceFromName(tempCup.get(j).getTop().getName());
                        tempCup.get(j).setPrice((tempCup.get(j).getPrice(tempCup.get(j).getBottom(), tempCup.get(j).getTop())));
                        lineItems lineitem = new lineItems(quantity, tempCup.get(j));
                        cart.add(lineitem);
                    }

                    Invoice invoice = new Invoice(cart, user, date.toLocalDate());
                    allInvoices.add(invoice);
                    connection.close();
                }

            } catch (Exception es) {
                System.err.println("Got an exception! 9");
                System.err.println(es.getMessage());
            }

        }
        return allInvoices;

    }
    
    public static void main(String[] args) {
        getAllInvoicesForCustomer();
    }
}
