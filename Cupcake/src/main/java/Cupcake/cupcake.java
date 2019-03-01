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

    public cupcake(Bottoms bottom, Toppings top, String price) {
        this.bottom = bottom;
        this.top = top;
        this.price = price;
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

    public int getPrice(int bottomPrice, int topPrice) {
       int totalprice = bottomPrice + topPrice;
       return totalprice;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
}
