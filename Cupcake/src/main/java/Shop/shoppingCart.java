package Shop;

import Cupcake.Bottoms;
import Cupcake.Toppings;
import Cupcake.cupcake;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ludvig
 */
public class shoppingCart {
    
    private ArrayList<lineItems> cart = new ArrayList();

    public void addToCart(lineItems li) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getCup().getBottom().equals(li.getCup().getBottom()) && cart.get(
                    i).getCup().getTop().equals(li.getCup().getTop())) {
                cart.get(i).editQuantity(li.getQuantity());
            }
        }

        cart.add(li);
    }

    public int size() {
        return cart.size();
    }

    public void add(lineItems l) {
        cart.add(l);
    }

    public ArrayList getCart() {
        return cart;
    }

    public lineItems get(int index) {
        return cart.get(index);
    }

    public double getToal() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getFullPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "shoppingCart: " + "cart: " + cart;
    }
}
