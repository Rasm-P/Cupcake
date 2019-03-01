package Shop;

import Cupcake.cupcake;

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
    int quantity;
    int fullPrice;
    cupcake cc;
    
    public lineItems(int quantity, cupcake cc){
        this.quantity = quantity;
        this.cc = cc;
    }
    
    public void editQuantity(int cha){
        this.quantity = quantity + cha;
    }
    
    public cupcake getCup(){
        return this.cc;
    }
    
    public double getPrice(){
        return quantity * cc.getPrice(cc.getBottom(), cc.getTop());
    }
}
