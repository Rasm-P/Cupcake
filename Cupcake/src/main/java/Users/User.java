/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

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
         String query = "SELECT user.balance from cupcake.user where username = " + user.getUserName() + " and password = " + user.getPassword()+ ";";
         System.out.println(query);
         try {
            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
             Statement st = connection.createStatement(); {
               
                ResultSet rs = st.executeQuery(query); 
            
            
            while (rs.next()) {
                
                    balance = rs.getDouble("balance");
                System.out.println(balance);
                }
            
            connection.close();
         }
            } catch (Exception e) {
            e.getLocalizedMessage();
        
    }
         return balance;
        }
    
    public static void main(String[] args) {
        User user = new User(1, "Ole", "1234", 112.0);
        getBalanceFromDB(user);
        
    }
    

    


}

