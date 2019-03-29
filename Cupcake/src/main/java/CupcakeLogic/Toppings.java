/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CupcakeLogic;

/**
 *
 * @author rh
 */
public class Toppings {
    private String name;
    private double price;

    /**
     * creates a toppng object with a string, name and a double value, price
     * 
     * @param name
     * @param price 
     */
    public Toppings(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * returns the name of a topping object
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name for a topping object
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the price for a topping object
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * sets the price for a topping object
     * 
     * @param price 
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", topping-price: " + price;
    }  
}
