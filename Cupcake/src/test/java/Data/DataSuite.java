/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Rumle
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Data.DataMapperTest.class, Data.transactionTest.class, Data.DBConnectorTest.class, Data.CupcakeMapperTest.class})
public class DataSuite {
    
}
