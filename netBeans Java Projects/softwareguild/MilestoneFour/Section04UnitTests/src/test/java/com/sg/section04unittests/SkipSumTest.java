/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

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
public class SkipSumTest {
    
    private SkipSum skipSum = new SkipSum();
    
    public SkipSumTest() {
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
     * Test of skipSum method, of class SkipSum.
     */
    @Test
    public void testSkipSum9() {
        int test1 = 4;
        int test2 = 5;
        
        assertEquals(9, skipSum.skipSum(test1, test2)); 
    }
    
    @Test
    public void testSkipSum10() {
        int test1 = 5;
        int test2 = 5;
        
        assertEquals(20, skipSum.skipSum(test1, test2)); 
    }
    
    @Test
    public void testSkipSum19() {
        int test1 = 4;
        int test2 = 15;
        
        assertEquals(20, skipSum.skipSum(test1, test2)); 
    }
    
    @Test
    public void testSkipSum20() {
        int test1 = 10;
        int test2 = 10;
        
        assertEquals(20, skipSum.skipSum(test1, test2)); 
    }
    
    @Test
    public void testSkipSum21() {
        int test1 = 10;
        int test2 = 11;
        
        assertEquals(21, skipSum.skipSum(test1, test2)); 
    }
    
}
