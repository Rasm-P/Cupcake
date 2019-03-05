<<<<<<< HEAD
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
public class Toppings {
    private String name;
    private double price;

=======

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
public class Toppings {
    private String name;
    private double price;

>>>>>>> 9da7a381734e0924a0bc510faea8aa7fa5756a97
    public Toppings(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", price " + price;
    }
    
    
    
<<<<<<< HEAD
}
=======
}
>>>>>>> 9da7a381734e0924a0bc510faea8aa7fa5756a97
