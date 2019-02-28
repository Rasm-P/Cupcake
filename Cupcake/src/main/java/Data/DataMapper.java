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

    public static User getInfo(String Username) {
        double balance = 0.0;
        String password = "";
        String username = "";
        int id = 0;
        try {

            DBConnector conn = new DBConnector();
            Connection connection = conn.getConnection();
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM user Where username = " + "'" + Username + "'";

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
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        
        if (!"".equals(username))
        {
        User user = new User(id, username, password, balance);
        System.out.println(user.getUserName());
        return user;
        } else {
            System.out.println("User not found!");
            return null;
        }
    }

    public static void main(String[] args) {
        String username = "r";

        System.out.println(getInfo(username));
        
    }
}
