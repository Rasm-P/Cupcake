/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Cupcake.Toppings;
import Data.DBConnector;
import com.mysql.cj.jdbc.ha.BalanceStrategy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author rh
 */
public class User {
private int idUser;
private String username, password, email;
private double balance;

    public User(int idUser,String userName, String password, Double balance) {
        this.username = userName;
        this.password = password;
        this.balance = balance;
        this.email = email;
        this.idUser = idUser;
    }

    User(int idUser, String email, String userName, String password, String balance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }
    
    

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdUser() {
        return idUser;
    }

    public static double getBalanceFromDB(User user) {
        double balance = 0;
         try {

            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT balance from cupcake.user where user.username = " + "'" + user.getUserName() + "'" + " and user.password = " + "'" +user.getPassword() +"'"+ ";";

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
    
    public static void main(String[] args) {
        User user = new User(1, "Ole", "1234", 112.0);
        getBalanceFromDB(user);
        
    }
    

    


}

