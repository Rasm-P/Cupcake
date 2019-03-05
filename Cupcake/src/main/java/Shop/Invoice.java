package Shop;

import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rumle
 */
public class Invoice {
    
    /**
 *
 * @author Rumle
 */

    private shoppingCart cart;
    private Users.User user;
    private LocalDate date;

    public Invoice(shoppingCart cart, Users.User user, LocalDate date) {
        this.cart = cart;
        this.user = user;
        this.date = date;
    }

    public shoppingCart getCart() {
        return cart;
    }

    public void setCart(shoppingCart cart) {
        this.cart = cart;
    }

    public Users.User getUser() {
        return user;
    }

    public void setUser(Users.User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
    
    
}

    
}
