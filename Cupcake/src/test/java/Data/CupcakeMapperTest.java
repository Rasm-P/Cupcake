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
        CupcakeMapper instance = new CupcakeMapper();
        ArrayList<Toppings> result = instance.getToppings();
        assertNotNull(result);
    }

    /**
     * Test of getBottoms method, of class CupcakeMapper.
     */
    @Test
    public void testGetBottoms() {
        CupcakeMapper instance = new CupcakeMapper();
        ArrayList<Bottoms> result = instance.getBottoms();
        assertNotNull(result);
    }

    /**
     * Test of getOneToppings method, of class CupcakeMapper.
     */
    @Test
    public void testGetOneToppings() {
        String toppingname = "Chocolate";
        CupcakeMapper instance = new CupcakeMapper();
        Toppings expResult = new Toppings("Chocolate", 0);
        Toppings result = instance.getOneToppings(toppingname);
        assertEquals(expResult.getName(), result.getName());
        
    }

    /**
     * Test of getOneBottom method, of class CupcakeMapper.
     */
    @Test
    public void testGetOneBottom() {
        String Bottomname = "Nutmeg";
        CupcakeMapper instance = new CupcakeMapper();
        Bottoms expResult = new Bottoms("Nutmeg", 0);
        Bottoms result = instance.getOneBottom(Bottomname);
        assertEquals(expResult.getName(), result.getName());
        
    }

    /**
     * Test of getTopPriceFromName method, of class CupcakeMapper.
     */
    @Test
    public void testGetTopPriceFromName() {
        String top = "Chocolate";
        CupcakeMapper instance = new CupcakeMapper();
        double expResult = 5.0;
        double result = instance.getTopPriceFromName(top);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of getBottomPriceFromName method, of class CupcakeMapper.
     */
    @Test
    public void testGetBottomPriceFromName() {
        String bottom = "Vanilla";
        CupcakeMapper instance = new CupcakeMapper();
        double expResult = 5.0;
        double result = instance.getBottomPriceFromName(bottom);
        assertEquals(expResult, result, 0.0);
        
    }
    
}
