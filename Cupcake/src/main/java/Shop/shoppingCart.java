<<<<<<< HEAD:Cupcake/src/main/java/shoppingCart.java

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
    static ArrayList<lineItems> cart = new ArrayList(); 
  
    static public void addToCart(cupcake cup, int qua){
        boolean all = true;
        for(int i = 0; i < cart.size(); i++){
            if(cart.get(i).getCup().getBottom().equals(cup.getBottom()) && cart.get(i).getCup().getTop().equals(cup.getTop())){
                cart.get(i).editQuantity(qua);
                
                all = false;
            }                            
        }   
        if(all){
            cart.add(new lineItems(qua, cup));
        }
    }
    
    public static ArrayList getCart(){
        return cart;               
    }   
    
    public static void main(String [] args){
        Bottoms b1 = new Bottoms("Choco", 2.0);
        Toppings t1 = new Toppings("Banana", 3.0);
        cupcake c1 = new cupcake(b1, t1, "5");
        
        Bottoms b2 = new Bottoms("Berry", 4.0);
        cupcake c2 = new cupcake(b2, t1, "7");
        
        addToCart(c1, 4);
        addToCart(c1, 4);
//        addToCart(c1, 7);
        addToCart(c2, 6);
//        addToCart(c2, 6);
        
        for(int i = 0; i<cart.size(); i++){
            System.out.println(cart.get(i).getQuantity());
            System.out.println(cart.get(i).getPrice());
        }
        
//        System.out.println(cart.get(0).getQuantity());
//        System.out.println(cart.get(1).getQuantity());
//        System.out.println(cart.get(2).getQuantity());
    }
}
=======
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
>>>>>>> 31318ebb4c7f67501461dde98bfcf63421e3db47:Cupcake/src/main/java/Shop/shoppingCart.java
