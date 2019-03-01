/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Users.User;

/**
 *
 * @author Rasmus2
 */
public class DataMapper {

    public static User getInfoFromUsername(String inputUsername) {
        double balance = 0.0;
        String password = "";
        String username = "";
        int id = 0;
        try {

            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM user Where username = " + "'" + inputUsername + "'" + ";";

            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    id = rs.getInt("idUser");
                    username = rs.getString("username");
                    password = rs.getString("password");
                    balance = rs.getDouble("balance");

                }
                connection.close();
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        
        if (inputUsername.equals(username))
        {
        User user = new User(id, username, password, balance);
        System.out.println(user.getUserName());
        return user;
        } else {
            System.out.println("User not found!");
            return null;
        }
    }

    
    
    
        public static boolean getInfo_Username_Password(String inputUsername, String inputPassword) {
        boolean findUser = false;
        double balance = 0.0;
        String password = "";
        String username = "";
        int id = 0;
        
        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            return false;
        }
        
        try {

            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM user Where username = " + "'" + 
                    inputUsername + "'"+" and password = " + "'" + inputPassword + "'" + ";";

            // execute the query, and get a java resultset
            try ( // create the java statement
                Statement st = connection.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    id = rs.getInt("idUser");
                    username = rs.getString("username");
                    password = rs.getString("password");
                    balance = rs.getDouble("balance");

                }
                connection.close();
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        
        if (inputUsername.equals(username) && inputPassword.equals(password))
        {
         findUser = true;
        return findUser;
        } else {
            System.out.println("User not found!");
            return findUser;
        }
    }
    
    
    
    
    
    
    
    
    
   public static void main(String[] args) {
       String username = "Ole";
       String password = "1234";
       System.out.println(getInfo_Username_Password(username, password));
       
    }
    
    
    
    
    
    
}
