/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnector {

    private static Connection connection = null;

    //Constants
    private static final String IP = "178.62.228.96";
    private static final String PORT = "3306";
    public static final String DATABASE = "cupcake";
    private static final String USERNAME = "cupcakeuser";
    private static final String PASSWORD = "password1234";
    private static String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
    
    public DBConnector() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();        

        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }
    
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                              
                connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException | 
                    InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
