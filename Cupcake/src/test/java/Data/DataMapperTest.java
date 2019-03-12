/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Shop.Invoice;
import Users.User;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rumle
 */
public class DataMapperTest {
    
    public DataMapperTest() {
    }

    /**
     * Test of getInvoiceFromUsername method, of class DataMapper.
     */
    @Test
    public void testGetInvoiceFromUsername() {
        System.out.println("getInvoiceFromUsername");
        String inputUsername = "";
        DataMapper instance = new DataMapper();
        ArrayList<Invoice> expResult = null;
        ArrayList<Invoice> result = instance.getInvoiceFromUsername(inputUsername);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfoFromUsername method, of class DataMapper.
     */
    @Test
    public void testGetInfoFromUsername() {
        System.out.println("getInfoFromUsername");
        String inputUsername = "";
        String inputPassword = "";
        DataMapper instance = new DataMapper();
        User expResult = null;
        User result = instance.getInfoFromUsername(inputUsername, inputPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo_Username_Password method, of class DataMapper.
     */
    @Test
    public void testGetInfo_Username_Password() {
        System.out.println("getInfo_Username_Password");
        String inputUsername = "";
        String inputPassword = "";
        DataMapper instance = new DataMapper();
        boolean expResult = false;
        boolean result = instance.getInfo_Username_Password(inputUsername, inputPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrder method, of class DataMapper.
     */
    @Test
    public void testCreateOrder() throws Exception {
        System.out.println("createOrder");
        Invoice invoice = null;
        DataMapper instance = new DataMapper();
        instance.createOrder(invoice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToBalance method, of class DataMapper.
     */
    @Test
    public void testAddToBalance() {
        System.out.println("addToBalance");
        User user = null;
        double newMoney = 0.0;
        DataMapper instance = new DataMapper();
        instance.addToBalance(user, newMoney);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFromBalance method, of class DataMapper.
     */
    @Test
    public void testRemoveFromBalance() {
        System.out.println("removeFromBalance");
        User user = null;
        double money = 0.0;
        DataMapper instance = new DataMapper();
        instance.removeFromBalance(user, money);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllInvoicesForCustomer method, of class DataMapper.
     */
    @Test
    public void testGetAllInvoicesForCustomer() throws Exception {
        System.out.println("getAllInvoicesForCustomer");
        String username = "";
        String password = "";
        DataMapper instance = new DataMapper();
        ArrayList<Invoice> expResult = null;
        ArrayList<Invoice> result = instance.getAllInvoicesForCustomer(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserID method, of class DataMapper.
     */
    @Test
    public void testGetUserID() {
        System.out.println("getUserID");
        String username = "";
        String password = "";
        DataMapper instance = new DataMapper();
        int expResult = 0;
        int result = instance.getUserID(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllInvoiceForUser method, of class DataMapper.
     */
    @Test
    public void testGetAllInvoiceForUser() {
        System.out.println("getAllInvoiceForUser");
        String username = "";
        String password = "";
        DataMapper instance = new DataMapper();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getAllInvoiceForUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAdmin method, of class DataMapper.
     */
    @Test
    public void testIsAdmin() {
        System.out.println("isAdmin");
        String username = "";
        String password = "";
        DataMapper instance = new DataMapper();
        boolean expResult = false;
        boolean result = instance.isAdmin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class DataMapper.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        DataMapper instance = new DataMapper();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllInvoices method, of class DataMapper.
     */
    @Test
    public void testGetAllInvoices() throws Exception {
        System.out.println("getAllInvoices");
        DataMapper instance = new DataMapper();
        ArrayList<ArrayList<Invoice>> expResult = null;
        ArrayList<ArrayList<Invoice>> result = instance.getAllInvoices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalanceFromDB method, of class DataMapper.
     */
    @Test
    public void testGetBalanceFromDB() {
        System.out.println("getBalanceFromDB");
        String name = "";
        String password = "";
        DataMapper instance = new DataMapper();
        double expResult = 0.0;
        double result = instance.getBalanceFromDB(name, password);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DataMapper.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        DataMapper.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
