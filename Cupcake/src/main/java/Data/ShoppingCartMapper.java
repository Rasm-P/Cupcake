/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Rumle
 */
public class ShoppingCartMapper {
    
    public void createOrder(Invoice invoice) {
        
        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            
            for(int i = 0; i < invoice) 

            String query = "INSERT INTO cupcake.orders (username, password, balance) VALUES (?,?,?);";

            PreparedStatement pstmt = connection.prepareStatement(query);
//            Statement statement = connection.createStatement();

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setDouble(3, user.getBalance());
//            statement.executeUpdate(query);
            pstmt.execute();
            connection.close();
        } catch (Exception e) {

            e.getLocalizedMessage();
        
    }
    
    public void 
    
}
