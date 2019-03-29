/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CupcakeLogic;

/**
 *
 * @author rh
 */
public class User {

    private int idUser;
    private String username, password, email;
    private double balance;
    
    /**
     * constructor creates a new user
     * 
     * @param idUser
     * @param userName
     * @param password
     * @param balance 
     */
    public User(int idUser, String userName, String password, Double balance) {
        this.username = userName;
        this.password = password;
        this.balance = balance;
        this.email = email;
        this.idUser = idUser;
    }

    /**
     * returns username
     * 
     * @return username
     */
    public String getUserName() {
        return username;
    }

    /**
     * sets username
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.username = userName;
    }

    /**
     * returns password
     * 
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets password
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * returns balance
     * 
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * sets balance
     * 
     * @param balance 
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * returns email
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets email
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * returns user id
     * 
     * @return idUser
     */
    public int getIdUser() {
        return idUser;
    }

    @Override
    public String toString() {
        return "UserId: " + idUser + ", username: " + username + ", password: " + password + ", email: " + email + ", balance: " + balance;
    }
}
