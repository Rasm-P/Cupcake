/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CupcakeData;

import CupcakeLogic.Bottoms;
import CupcakeLogic.Toppings;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class CupcakeMapper {
    private Connection connection = DBConnector.getConnection();
    
    /**
     * the method sends a query to the database and ask to get everything
     * from the Topping table
     * @return an arraylist of topping objects
     */

    public ArrayList<Toppings> getToppings() {
        int id = 0;
        String name;
        Double price;
        ArrayList<Toppings> toppings = new ArrayList();

        try { 
            String query = "SELECT * FROM toppings;";
            
            try ( 
                    Statement st = connection.createStatement()) {
                ResultSet rs = st.executeQuery(query);
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

    /**
     * the method sends a query to the database and ask to get everything
     * from the bottom table
     * @return an arraylist of bottom objects
     */
    public ArrayList<Bottoms> getBottoms() {
        int id = 0;
        String name;
        Double price;
        ArrayList<Bottoms> bottoms = new ArrayList();

        try { 
            String query = "SELECT * FROM bottoms;";
                try ( 
                    Statement st = connection.createStatement()) {
                    ResultSet rs = st.executeQuery(query);
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
    
    /**
     * finds the topping in the database with the matching name
     * @param toppingname
     * @return a topping object
     */
    public Toppings getOneToppings(String toppingname) {
        int id = 0;
        String name;
        Double price;
        Toppings top = null;

        try {   String query = "SELECT * FROM toppings where toppingname = '" 
                    + toppingname + "' ;";

            
            try (
                    Statement st = connection.createStatement()) {
                    ResultSet rs = st.executeQuery(query);
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

    /**
     * finds the information of the bottom with the matching name the method
     * is given
     * @param Bottomname
     * @return a bottoms object
     */
    public Bottoms getOneBottom(String Bottomname) {
        int id = 0;
        String name;
        Double price;
        Bottoms bot = null;

        try {
            String query = "SELECT * FROM bottoms where bottomname = '" 
                    + Bottomname + "' ;";
            try ( 
                Statement st = connection.createStatement()) {
                ResultSet rs = st.executeQuery(query);
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
    
    /**
     * this method finds the price of the topping that match the name the method
     * is given
     * @param top
     * @return a double which represent the price of the topping
     */
    public double getTopPriceFromName(String top) {
        double price = 0.0;
        try {       
            String query = "SELECT toppings.price FROM toppings where "
                    + "toppingname=" + "'" + top + "'" + ";";
                       
            
            try ( 
                    Statement st = connection.createStatement()) {
                
                ResultSet rs = st.executeQuery(query);

                
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
    
    /**
     * this method finds the price for the bottom that has the matching bottomname
     * @param bottom
     * @return a double that represent the price of the bottom
     */
    public double getBottomPriceFromName(String bottom) {
        double price = 0.0;
        try {
            String query = "SELECT bottoms.price FROM bottoms where "
                    + "bottomname=" + "'" + bottom + "'" + ";";
            try ( 
                    Statement st = connection.createStatement()) {
               ResultSet rs = st.executeQuery(query);

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
