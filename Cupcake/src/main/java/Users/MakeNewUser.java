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

    public User generateUser(int idUser, String email, String userName,
            String password, double balance) {
        User user = new User(idUser, userName, password, balance);
        return user;
    }

    public void createNewUser(User user) throws Exception {

        try {

            String query = "INSERT INTO cupcake.user (username, password, balance) VALUES (?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(query);
//            Statement statement = connection.createStatement();

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
