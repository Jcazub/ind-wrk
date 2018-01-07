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
public class SumDoubleTest {
    
    SumDouble sumDouble = new SumDouble();
    
    public SumDoubleTest() {
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
     * Test of sumDouble method, of class SumDouble.
     */
    @Test
    public void testSumDouble() {
        int a = 2;
        int b = 5;
        
        assertEquals(7, sumDouble.sumDouble(a, b));              
    }
    
    @Test
    public void testSumDoubleNegativeA() {
        int a = -2;
        int b = 5;
        
        assertEquals(3, sumDouble.sumDouble(a, b));              
    }
    
    @Test
    public void testSumDoubleNegativeB() {
        int a = 2;
        int b = -5;
        
        assertEquals(-3, sumDouble.sumDouble(a, b));              
    }
    
    @Test
    public void testSumDoubleDouble() {
        int a = 2;
        int b = 2;
        
        assertEquals(8, sumDouble.sumDouble(a, b));              
    }
    
    @Test
    public void testSumDoubleNegativeDouble() {
        int a = -2;
        int b = -2;
        
        assertEquals(-8, sumDouble.sumDouble(a, b));              
    }
    
}
