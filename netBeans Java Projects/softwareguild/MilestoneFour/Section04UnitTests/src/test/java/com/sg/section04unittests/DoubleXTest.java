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
public class DoubleXTest {
    
    private DoubleX doubleX = new DoubleX();
    
    public DoubleXTest() {
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
     * Test of doubleX method, of class DoubleX.
     */
    @Test
    public void testDoubleXEmptyString() {
        String testString = "";
        
        assertFalse(doubleX.doubleX(testString));
    }
    
    @Test
    public void testDoubleXTrue() {
        String testString = "axxbb";
        
        assertTrue(doubleX.doubleX(testString));
    }
    
    @Test
    public void testDoubleXFalseWithSecondXX() {
        String testString = "axaxxax";
        
        assertFalse(doubleX.doubleX(testString));
    }
    
    @Test
    public void testDoubleXTrueAllXX() {
        String testString = "xxxx";
        
        assertTrue(doubleX.doubleX(testString));
    }
    
    @Test
    public void testDoubleXFalseOneX() {
        String testString = "x";
        
        assertFalse(doubleX.doubleX(testString));
    }
    
    @Test
    public void testDoubleXFalseOneChar() {
        String testString = "a";
        
        assertFalse(doubleX.doubleX(testString));
    }
    
    @Test
    public void testDoubleXFalseCapitalX() {
        String testString = "axaxXax";
        
        assertFalse(doubleX.doubleX(testString));
    }
    
    @Test
    public void testDoubleXFalseLastx() {
        String testString = "abcdx";
        
        assertFalse(doubleX.doubleX(testString));
    }
    
}
