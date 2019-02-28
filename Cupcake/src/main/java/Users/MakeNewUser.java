/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

/**
 *
 * @author rh
 */
public class MakeNewUser {
    
    public static User generateUser(String email, String userName, String password)
    {
        User user = new User(email, userName, password);
        return user;
    }
    
}
