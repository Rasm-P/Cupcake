/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Data.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author rh
 */
public class MakeNewUser {

    private Connection connection = DBConnector.getConnection();

    /**
     * constructor creates a new user
     * 
     * @param idUser
     * @param email
     * @param userName
     * @param password
     * @param balance
     * @return user
     */
    public User generateUser(int idUser, String email, String userName,
            String password, double balance) {
        User user = new User(idUser, userName, password, balance);
        return user;
    }

    /**
     * inserts a new user into SQL database
     * 
     * @param user
     * @throws Exception 
     */
    public void createNewUser(User user) throws Exception {
        try {

            String query = "INSERT INTO cupcake.user (username, password, balance) VALUES (?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setDouble(3, user.getBalance());

            pstmt.executeUpdate();
            pstmt.closeOnCompletion();

        } catch (Exception e) {
            System.out.println("Error in creating user!");
            e.printStackTrace();
        }
    }
}
