
package Cupcake;

/**
 *
 * @author rh
 */
public class cupcake {
    private Bottoms bottom;
    private Toppings top;
    private double price;

    /**
     * cupcake constructor, requires a bottom and top object and a double value
     * 
     * @param bottom
     * @param top
     * @param totalPrice 
     * 
     */
    public cupcake(Bottoms bottom, Toppings top, double totalPrice) {
        this.bottom = bottom;
        this.top = top;
        this.price = totalPrice;
    }

    /**
     * returns bottom for cupcake object
     * 
     * @return bottom
     */
    public Bottoms getBottom() {
        return bottom;
    }

    /**
     * sets the bottom object for a cupcake object
     * 
     * @param bottom 
     */
    public void setBottom(Bottoms bottom) {
        this.bottom = bottom;
    }

    /**
     * returns the top for a cupcake object
     * 
     * @return top
     */
    public Toppings getTop() {
        return top;
    }

    /**
     * returns the price of a cupcake based on the price of the bottom and top 
     * 
     * @param bottom
     * @param top
     * @return totalprice
     */
    public double getPrice(Bottoms bottom, Toppings top) {
       double totalprice = bottom.getPrice() + top.getPrice();
       return totalprice;
    }

    /**
     * sets the price for a cupcake
     * 
     * @param price 
     */
    public void setPrice(double price) {
        this.price = price;
    } 

    @Override
    public String toString() {
        return "Bottom: " + bottom + ", Top: " + top + ", Cupcake-Price: " + price;
    }  
}
