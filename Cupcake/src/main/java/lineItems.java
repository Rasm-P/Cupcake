/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ludvig
 */
public class lineItems {
    String topping;
    String bottom;
    int quantity;
    int fullPrice;
    
    public lineItems(int quantity, String topping, String bottom){
        this.quantity = quantity;
        this.topping = topping;
        this.bottom = bottom;
    }
    
    public int getPrice(){
        
    }
    
    @Override
    public String toString() {
        return "You ordered " + quantity + " cupcakes with topping" + topping + " and bottom " + bottom + " costing " + fullPrice;
    }
}
