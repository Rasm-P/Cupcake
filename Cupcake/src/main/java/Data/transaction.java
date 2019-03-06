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
public class transaction extends Invoice {

    public transaction(shoppingCart cart, User user, LocalDate date) {
        super(cart, user, date);
    }
}
