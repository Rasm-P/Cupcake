/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Shop.Invoice;
import Shop.shoppingCart;
import Users.User;
import java.time.LocalDate;

/**
 *
 * @author Rasmus2
 */
public class transaction {
    
    private shoppingCart cart;
    private Users.User user;
    private LocalDate date;

    public transaction(shoppingCart cart, User user, LocalDate date) {
        this.cart = cart;
        this.user = user;
        this.date = date;
    }

    public shoppingCart getCart() {
        return cart;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }
    
    
}
