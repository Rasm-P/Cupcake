/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Cupcake.Bottoms;
import Cupcake.Toppings;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rh
 */
public class CupcakeMapper {
    private Connection connection = DBConnector.getConnection();

    public ArrayList<Toppings> getToppings() {
        int id = 0;
        String name;
        Double price;
        ArrayList<Toppings> toppings = new ArrayList();

        try {
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM toppings;";

            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    id = rs.getInt("idtoppings");
                    name = rs.getString("toppingname");
                    price = rs.getDouble("price");
                    Toppings top = new Toppings(name, price);
                    toppings.add(top);

                }
                st.closeOnCompletion();
                rs.close();              
            }
        } catch (Exception e) {
            System.err.println("Error in getting toppings from database! ");
            System.err.println(e.getMessage());
        }
        
        return toppings;
    }

    public ArrayList<Bottoms> getBottoms() {
        int id = 0;
        String name;
        Double price;
        ArrayList<Bottoms> bottoms = new ArrayList();

        try {
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM bottoms;";

            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    id = rs.getInt("idBottoms");
                    name = rs.getString("bottomname");
                    price = rs.getDouble("price");
                    Bottoms bot = new Bottoms(name, price);
                    bottoms.add(bot);
                }
                st.closeOnCompletion();
                rs.close();              
            }
        } catch (Exception e) {
            System.err.println("Error in getting bottoms from database! ");
            System.err.println(e.getMessage());
        }
        
        return bottoms;
    }

    public Toppings getOneToppings(String toppingname) {
        int id = 0;
        String name;
        Double price;
        Toppings top = null;

        try {        
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM toppings where toppingname = '" 
                    + toppingname + "' ;";

            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    id = rs.getInt("idtoppings");
                    name = rs.getString("toppingname");
                    price = rs.getDouble("price");
                    top = new Toppings(name, price);
                }
                rs.close();
                st.closeOnCompletion();
            }
        } catch (Exception e) {
            System.err.println("Error in getting topping from database!");
            System.err.println(e.getMessage());
        }
        return top;
    }

    public Bottoms getOneBottom(String Bottomname) {
        int id = 0;
        String name;
        Double price;
        Bottoms bot = null;

        try {
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM bottoms where bottomname = '" 
                    + Bottomname + "' ;";

            // execute the query, and get a java resultset
            try ( // create the java statement
                Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    id = rs.getInt("idBottoms");
                    name = rs.getString("bottomname");
                    price = rs.getDouble("price");
                    bot = new Bottoms(name, price);

                }
                rs.close();
                st.closeOnCompletion();          
            }
        } catch (Exception e) {
            System.err.println("Error in getting topping from database! ");
            System.err.println(e.getMessage());
        }
            
        return bot;
    }
    
    public double getTopPriceFromName(String top) {
        double price = 0.0;
        try {       
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT toppings.price FROM toppings where "
                    + "toppingname=" + "'" + top + "'" + ";";
                       
            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    price = rs.getDouble("price");
                }
                st.closeOnCompletion();
                rs.close();                
            }
        } catch (Exception e) {
            System.err.println("Error in getting price for topping! ");
            System.err.println(e.getMessage());
        }
             
         return price;
    }
    
    public double getBottomPriceFromName(String bottom) {
        double price = 0.0;
        try {
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT bottoms.price FROM bottoms where "
                    + "bottomname=" + "'" + bottom + "'" + ";";
                       
            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    price = rs.getDouble("price");                    
                }
                st.closeOnCompletion();
                rs.close();                
            }
        } catch (Exception e) {
            System.err.println("Error in getting price for bottom!");
            System.err.println(e.getMessage());
        }
        
         return price;         
    }        
}
