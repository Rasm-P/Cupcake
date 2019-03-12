/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Cupcake.Bottoms;
import Cupcake.Toppings;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rumle
 */
public class CupcakeMapperTest {
    
    public CupcakeMapperTest() {
    }

    /**
     * Test of getToppings method, of class CupcakeMapper.
     */
    @Test
    public void testGetToppings() {
        System.out.println("getToppings");
        CupcakeMapper instance = new CupcakeMapper();
        ArrayList<Toppings> expResult = null;
        ArrayList<Toppings> result = instance.getToppings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBottoms method, of class CupcakeMapper.
     */
    @Test
    public void testGetBottoms() {
        System.out.println("getBottoms");
        CupcakeMapper instance = new CupcakeMapper();
        ArrayList<Bottoms> expResult = null;
        ArrayList<Bottoms> result = instance.getBottoms();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOneToppings method, of class CupcakeMapper.
     */
    @Test
    public void testGetOneToppings() {
        System.out.println("getOneToppings");
        String toppingname = "";
        CupcakeMapper instance = new CupcakeMapper();
        Toppings expResult = null;
        Toppings result = instance.getOneToppings(toppingname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOneBottom method, of class CupcakeMapper.
     */
    @Test
    public void testGetOneBottom() {
        System.out.println("getOneBottom");
        String Bottomname = "";
        CupcakeMapper instance = new CupcakeMapper();
        Bottoms expResult = null;
        Bottoms result = instance.getOneBottom(Bottomname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTopPriceFromName method, of class CupcakeMapper.
     */
    @Test
    public void testGetTopPriceFromName() {
        System.out.println("getTopPriceFromName");
        String top = "";
        CupcakeMapper instance = new CupcakeMapper();
        double expResult = 0.0;
        double result = instance.getTopPriceFromName(top);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBottomPriceFromName method, of class CupcakeMapper.
     */
    @Test
    public void testGetBottomPriceFromName() {
        System.out.println("getBottomPriceFromName");
        String bottom = "";
        CupcakeMapper instance = new CupcakeMapper();
        double expResult = 0.0;
        double result = instance.getBottomPriceFromName(bottom);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
