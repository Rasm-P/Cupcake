package CupcakeLogic;

import CupcakeLogic.Bottoms;
import CupcakeLogic.Toppings;
import CupcakeLogic.cupcake;
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

    /**
     * adds a lineitem to the cart
     * 
     * @param li 
     */
    public void addToCart(lineItems li) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getCup().getBottom().equals(li.getCup().getBottom()) && cart.get(
                    i).getCup().getTop().equals(li.getCup().getTop())) {
                cart.get(i).editQuantity(li.getQuantity());
            }
        }

        cart.add(li);
    }

    /**
     * returns the size of the cart
     * 
     * @return cart.size()
     */
    public int size() {
        return cart.size();
    }

    /**
     * adds lineitem to cart
     * 
     * @param l 
     */
    public void add(lineItems l) {
        cart.add(l);
    }

    /**
     * returns cart
     * 
     * @return cart
     */
    public ArrayList getCart() {
        return cart;
    }

    /**
     * returns lineitem based on index
     * 
     * @param index
     * @return cart.get(index)
     */
    public lineItems get(int index) {
        return cart.get(index);
    }

    /**
     * returns total price of all lineitems in the cart
     * 
     * @return total
     */
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
