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
public class Makes10Test {
    
    private Makes10 makes10 = new Makes10();
    
    public Makes10Test() {
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
     * Test of makes10 method, of class Makes10.
     */
    @Test
    public void testMakes10oneis10true() {
        
        assertTrue(makes10.makes10(0,10));
        
    }
    
    @Test
    public void testMakes10false() {
        
        assertFalse(makes10.makes10(9,9));
        
    }
    
    @Test
    public void testMakes10equals10() {
        
        assertTrue(makes10.makes10(5,5));
        
    }
    
    @Test
    public void testMakes10equals10negative() {
        
        assertTrue(makes10.makes10(-5,15));
        
    }
    
}
