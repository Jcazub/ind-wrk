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
public class SumTest {
    
    private Sum sum = new Sum();
    
    public SumTest() {
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
     * Test of sum method, of class Sum.
     */
    @Test
    public void testSumNull() throws Exception {
        int[] test = null;
        
        try {
            sum.sum(test);
            fail("Expected Section04UnitTestException");
        } catch (Section04UnitTestException e) {
            return;
        } 
    }
    
    @Test
    public void testSumEmptyArray() throws Exception {
        int[] test = {};
  
        assertEquals(0, sum.sum(test));
    }
    
    @Test
    public void testSumNegativeNumbers() throws Exception  {
        int[] test = {-1,-2,-3};
        
        assertEquals(-6, sum.sum(test));
        
    }
    
    @Test
    public void testSumNegativeAndPositiveNumbers() throws Exception  {
        int[] test = {1,2,-3};
        
        assertEquals(0, sum.sum(test));
        
    }
    
    @Test
    public void testSumPositiveNumbers() throws Exception  {
        int[] test = {1,2,3};
        
        assertEquals(6, sum.sum(test));
        
    }
    
    @Test
    public void testSumOneNumber() throws Exception  {
        int[] test = {1};
        
        assertEquals(1, sum.sum(test));
        
    }
    
    
    
}
