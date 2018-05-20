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
public class PosNegTest {
    
    private PosNeg posNeg = new PosNeg();
    
    public PosNegTest() {
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
     * Test of posNeg method, of class PosNeg.
     */
    @Test
    public void testPosNegBothNegFalse() {
        int first = -1;
        int second = -1;
        boolean negative = false;
        
        assertFalse(posNeg.posNeg(first, second, negative));   
    }
    
    @Test
    public void testPosNegBothPosFalse() {
        int first = 1;
        int second = 1;
        boolean negative = false;
        
        assertFalse(posNeg.posNeg(first, second, negative));    
    }
    
    @Test
    public void testPosNegFirstNegSecondPosFalse() {
        int first = -1;
        int second = 1;
        boolean negative = false;
        
        assertTrue(posNeg.posNeg(first, second, negative));    
    }
    
    @Test
    public void testPosNegSecondNegFirstPosFalse() {
        int first = 1;
        int second = -1;
        boolean negative = false;
        
        assertTrue(posNeg.posNeg(first, second, negative));    
    }
    
    
    @Test
    public void testPosNegBothNegTrue() {
        int first = -1;
        int second = -1;
        boolean negative = true;
        
        assertTrue(posNeg.posNeg(first, second, negative));   
    }
    
    @Test
    public void testPosNegBothPosTrue() {
        int first = 1;
        int second = 1;
        boolean negative = true;
        
        assertFalse(posNeg.posNeg(first, second, negative));    
    }
    
    @Test
    public void testPosNegFirstNegSecondPosTrue() {
        int first = -1;
        int second = 1;
        boolean negative = true;
        
        assertFalse(posNeg.posNeg(first, second, negative));    
    }
    
    @Test
    public void testPosNegSecondNegFirstPosTrue() {
        int first = 1;
        int second = -1;
        boolean negative = true;
        
        assertFalse(posNeg.posNeg(first, second, negative));    
    }
    
    
}
