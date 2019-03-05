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
public class cupcake {
    private Bottoms bottom;
    private Toppings top;
    private double price;

    public cupcake(Bottoms bottom, Toppings top, double totalPrice) {
        this.bottom = bottom;
        this.top = top;
        this.price = totalPrice;
    }

    public Bottoms getBottom() {
        return bottom;
    }

    public void setBottom(Bottoms bottom) {
        this.bottom = bottom;
    }

    public Toppings getTop() {
        return top;
    }

    public double getPrice(Bottoms bottom, Toppings top) {
       double totalprice = bottom.getPrice() + top.getPrice();
       return totalprice;
    }

    public void setPrice(double price) {
        this.price = price;
    } 

    @Override
    public String toString() {
        return "Bottom " + bottom + ", Top " + top + ", Cupcake-Price " + price;
    }
    
}