/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cupcake;

/**
 *
 * @author rh
 */
public class Bottoms {

    private String name;
    private double price;

    /**
     * bottom constructor takes a string, name and a double value, price 
     * 
     * @param name
     * @param price 
     */
    public Bottoms(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * returns the name of a bottom
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name for a bottom object
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the price for a bottom object
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * sets the price for a bottom object
     * 
     * @param price 
     */
    public void setPrice(double price) {
        this.price = price;
    }    

    @Override
    public String toString() {
        return name + ", bottom-price: " + price;
    }   
}
