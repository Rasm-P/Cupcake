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
    private String price;

    public cupcake(Bottoms bottom, Toppings top, String totalPrice) {
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

    public String getTop() {
        return top.getName();
    }

    public double getPrice(Bottoms bottom, Toppings top) {
       double totalprice = bottom.getPrice() + top.getPrice();
       return totalprice;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
}
