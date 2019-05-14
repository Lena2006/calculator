/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CalkulatorImpTest {
    @Test
    public void zeroTest() throws Exception {
        double result = new CalkulatorImp().calculator("0");
        assertEquals(0, result, 1e-9);
    }
}
    
   
