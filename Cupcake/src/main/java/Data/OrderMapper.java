/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Cupcake.Bottoms;
import Cupcake.Toppings;
import Cupcake.cupcake;
import Shop.Order;
import Shop.lineItems;
import Users.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import sun.util.resources.LocaleData;

/**
 *
 * @author Rumle
 */
public class OrderMapper {
    
    public static void createOrder(Order order) throws Exception {
        
        
        
        
        
        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            
              
                
            

            String query = "INSERT INTO cupcake.lineitems (idBottoms, idtoppings, quantity) VALUES (?,?,?);";

            PreparedStatement pstmt = connection.prepareStatement(query);
//            Statement statement = connection.createStatement();

            pstmt.setString(1, order.getLineitems().get(0).getCup().getBottom().getName());
            pstmt.setString(2, order.getLineitems().get(0).getCup().getTop().getName());
            pstmt.setDouble(3, order.getLineitems().get(0).getQuantity());
//            statement.executeUpdate(query);
            pstmt.execute();
            connection.close();
            
            
            
        } catch (Exception e) {

            e.getLocalizedMessage();
        
    }
    
    
    
}
//    public static void main(String[] args) throws Exception {
//        Bottoms bottom = new Bottoms("Chokolatechip", 10);
//        Toppings top = new Toppings("Vanilla", 12);
//        Cupcake.cupcake cup = new cupcake(bottom, top, "10");
//        User user = new User(100, "Raller", "raller123", 0.0);
//        System.out.println(user.getUserName());
//        List<lineItems> line = new ArrayList<lineItems>();
//        lineItems item = new lineItems(5, cup);
//        
//        line.add(item);
//       
//        
//        Order order = new Order(line, user, 0, LocalDate.now());
//        createOrder(order);
//        System.out.println(order.toString());
//    }
    
    
    
    public static void saveLineitems(cupcake cake) {
         try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            
              
                
            

            String query = "INSERT INTO cupcake.lineitems (bottomname, toppingname, quantity) VALUES (?,?,?);";

            PreparedStatement pstmt = connection.prepareStatement(query);
//            Statement statement = connection.createStatement();

            pstmt.setString(1, cake.getBottom().getName());
            pstmt.setString(2, cake.getTop().getName());
            pstmt.setDouble(3, 1.0);
//            statement.executeUpdate(query);
            pstmt.execute();
            connection.close();
            
            
            
        } catch (Exception e) {

            e.getLocalizedMessage();
        
    }
    }
    public static void main(String[] args) {
        Bottoms bottom = new Bottoms("Chokolatechip", 10);
        Toppings top = new Toppings("Vanilla", 12);
        Cupcake.cupcake cup = new cupcake(bottom, top, "10");
        saveLineitems(cup);
    }
    
}
