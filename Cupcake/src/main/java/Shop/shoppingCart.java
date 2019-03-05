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
    
    public int size() {
        return cart.size();
    }
    
    public void add(lineItems l){
              
        cart.add(l);
    }
    
    public ArrayList getCart(){
        return cart;               
    } 
    
     public lineItems get(int index){
        return cart.get(index);               
    }
    
    
//    public static void main(String [] args){
//        Bottoms b = new Bottoms("Choco", 2.0);
//        Toppings t = new Toppings("Banana", 3.0);
//        cupcake c = new cupcake(b, t, "2");
//    }
}
