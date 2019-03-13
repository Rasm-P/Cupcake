/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rumle
 */
public class DBConnectorTest {
    
    public DBConnectorTest() {
    }

    /**
     * Test of getConnection method, of class DBConnector.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection result = DBConnector.getConnection();
        assertNotNull(result);
        
    }
    
}
