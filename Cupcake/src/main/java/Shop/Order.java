package Shop;

import Users.User;
import java.time.LocalDate;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rumle
 */
public class Order {
    private List<lineItems> lineitems;
    private Users.User user;
    private int invoice_id;
    private LocalDate orderDate;

    public Order(List<lineItems> lineitems, User user, int invoice_id, LocalDate orderDate) {
        this.lineitems = lineitems;
        this.user = user;
        this.invoice_id = invoice_id;
        this.orderDate = orderDate;
    }

    public List<lineItems> getLineitems() {
        return lineitems;
    }

    public void setLineitems(List<lineItems> lineitems) {
        this.lineitems = lineitems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    
    

    
    
    
    
            
    
    
}
