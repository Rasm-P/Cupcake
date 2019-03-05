package Shop;

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
    static ArrayList<lineItems> cart = new ArrayList(); 
  
//    public void addToCart(cupcake cup, int qua){
    public void addToCart(lineItems li){
        for(int i = 0; i < cart.size(); i++){
            if(cart.get(i).getCup().getBottom().equals(li.getCup().getBottom()) && cart.get(i).getCup().getTop().equals(li.getCup().getTop())){
                cart.get(i).editQuantity(li.getQuantity());
            }
        }
        
//        cart.add(new lineItems(qua, cup));
        cart.add(li);
    }
    
    public static ArrayList getCart(){
        return cart;               
    }   
    
//    public static void main(String [] args){
//        Bottoms b = new Bottoms("Choco", 2.0);
//        Toppings t = new Toppings("Banana", 3.0);
//        cupcake c = new cupcake(b, t, "2");
//    }
}
