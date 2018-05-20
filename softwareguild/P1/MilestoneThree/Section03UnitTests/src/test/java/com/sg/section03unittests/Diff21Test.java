/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesse
 */
public class Diff21Test {
    
    Diff21 diff21 = new Diff21();
    
    public Diff21Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of diff21 method, of class Diff21.
     */
    @Test
    public void testDiff21over21() {
        int n = 23;
        
        assertEquals(4, diff21.diff21(n));  
    }
    
    @Test
    public void testDiff21under21() {
        int n = 10;
        
        assertEquals(11, diff21.diff21(n));  
    }
    
    @Test
    public void testDiff21exact21() {
        int n = 21;
        
        assertEquals(0, diff21.diff21(n));  
    }
    
    @Test
    public void testDiff21zero() {
        int n = 0;
        
        assertEquals(21, diff21.diff21(n));  
    }
    
    @Test
    public void testDiff21negativeNum() {
        int n = -5;
        
        assertEquals(26, diff21.diff21(n));  
    }
    
    
}
