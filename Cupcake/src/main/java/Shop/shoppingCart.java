package Shop;


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
    static ArrayList<lineItems> cart = new ArrayList(); 
  
    public void addToCart(cupcake cup, int qua){
        for(int i = 0; i < cart.size(); i++){
            if(cart.get(i).getCup().getBottom().equals(cup.getBottom()) && cart.get(i).getCup().getTop().equals(cup.getTop())){
                cart.get(i).editQuantity(qua);
            }
        }
        
        cart.add(new lineItems(qua, cup));
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
