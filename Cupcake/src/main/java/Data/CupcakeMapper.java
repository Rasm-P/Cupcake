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
import java.util.List;

/**
 *
 * @author rh
 */
public class CupcakeMapper {

    public static ArrayList<Toppings> getToppings() {
        int id = 0;
        String name = "";
        Double price = 0.0;
        ArrayList<Toppings> toppings = new ArrayList();
        
         try {

            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM toppings";

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
                
                
                
                
                connection.close();
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
         System.out.println(toppings);
        return toppings;
        }

    
    
    
     public static ArrayList<Bottoms> getBottoms() {
        int id = 0;
        String name = "";
        Double price = 0.0;
        ArrayList<Bottoms> bottoms = new ArrayList();
        
         try {

            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM bottoms";

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

                connection.close();
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
         System.out.println(bottoms);
        return bottoms;
        }

    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        getBottoms();
        
    }
}