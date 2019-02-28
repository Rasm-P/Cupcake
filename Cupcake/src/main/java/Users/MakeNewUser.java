/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Data.DBConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rh
 */
public class MakeNewUser {
    
    public static User generateUser(int idUser, String email, String userName, String password, String balance)
    {
        User user = new User(idUser, email, userName, password, balance);
        return user;
    }
    
    public static void createNewUser(User user) throws Exception {
        String query = "INSERT INTO cupcake.user (idUser, username, password, balance) VALUES (?,?,?,?);"; 
                
                
//                "INSERT INTO Cupcakes.Users VALUES " + "( ,"
//                + ", " + user.getUserName() + ", " + user.getPassword() + ", " + user.getBalance() + ");";
        try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getPassword());
           // pstmt.setString(4, user.getBalance());
            pstmt.executeQuery();
        } catch(IOException | SQLException e) {
            e.getLocalizedMessage();
        }
    
    }
    
    
    public static void main(String[] args) throws Exception {
        User user = generateUser(0, "HemmingsenYolo@hot.com", "Raller", "raller123", "");
        createNewUser(user);
    }
    
}
