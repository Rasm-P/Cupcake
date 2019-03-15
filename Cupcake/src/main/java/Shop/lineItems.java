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
    double fullPrice;
    cupcake cc;
    
    /**
     * constructor for lineItems requires an integer value and a cupcake object
     * 
     * @param quantity
     * @param cc 
     */   
    public lineItems(int quantity, cupcake cc){
        this.quantity = quantity;
        this.cc = cc;
    }
    
    /**
     * edits quantity
     * 
     * @param cha 
     */
    public void editQuantity(int cha){
        this.quantity = quantity + cha;
    }
    
    /**
     * returns quantity
     * 
     * @return quantity
     */
    public int getQuantity(){
        return quantity;
    }
    
    /**
     * returns cupcake
     * 
     * @return cc
     */
    public cupcake getCup(){
        return this.cc;
    }
    
    /**
     * returns the full price of a cupcake based on the price of the bottom and topping of the cupcake
     * 
     * @return quantity * cc.getPrice(cc.getBottom(), cc.getTop()) 
     */
    public double getFullPrice(){
        return quantity * cc.getPrice(cc.getBottom(), cc.getTop());
    }

    @Override
    public String toString() {
        return "Quantity: " + quantity + ", Cupcake: " + cc + ", FullPrice: " + getFullPrice();
    }

    /**
     * returns cupcake
     * 
     * @return cc
     */
    public cupcake getCc() {
        return cc;
    }

    /**
     * sets the fullprice
     * 
     * @param fullPrice 
     */
    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }   
}
