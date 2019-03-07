/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnector {

    private static Connection connection = null;

    //Constants
    private static final String IP = "178.62.228.96";
    private static final String PORT = "3306";
    private static String url = "jdbc:mysql://178.62.228.96:3306/cupcake?UseSSL=false";
    public static final String DATABASE = "cupcake";
    private static final String USERNAME = "cupcakeuser";
    private static final String PASSWORD = "password1234";
    private static String driver = "com.mysql.cj.jdbc.Driver";

//    public DBConnector() throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
//
//        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
//    }
    /*
     public DBConnector() throws Exception {
     Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
     String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
     Properties props = new Properties();
     props.put("user", USERNAME);
     props.put("password", PASSWORD);
     props.put("allowMultiQueries", true);
     props.put("useUnicode", true);
     props.put("useJDBCCompliantTimezoneShift", true);
     props.put("useLegacyDatetimeCode", false);
     props.put("serverTimezone", "CET");
     this.connection = DriverManager.getConnection(url, props);
        
     }
     */

    public static Connection getConnection() {

        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return connection;
    }
}


