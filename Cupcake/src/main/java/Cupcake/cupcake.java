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
    private String bottom;
    private Toppings top;
    private String price;

    public cupcake(String bottom, Toppings top, String price) {
        this.bottom = bottom;
        this.top = top;
        this.price = price;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
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
