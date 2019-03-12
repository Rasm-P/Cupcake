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

    @Override
    public String toString() {
        return "UserId: " + idUser + ", username: " + username + ", password: " + password + ", email: " + email + ", balance: " + balance;
    }
    
   
    
    public static void main(String[] args) {
        User user = new User(1, "Ole", "1234", 112.0);
        
    }
    

 
}

