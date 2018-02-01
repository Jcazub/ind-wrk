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
public class NearHundredTest {
    
    private NearHundred nearHundred = new NearHundred();
    
    public NearHundredTest() {
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
     * Test of nearHundred method, of class NearHundred.
     */
    @Test
    public void testNearHundred89() {
        assertFalse(nearHundred.nearHundred(89));
    }
    
    @Test
    public void testNearHundred90() {
        assertTrue(nearHundred.nearHundred(90));
    }
    
    @Test
    public void testNearHundred110() {
        assertTrue(nearHundred.nearHundred(110));
    }
    
    @Test
    public void testNearHundred111() {
        assertFalse(nearHundred.nearHundred(111));
    }
    
    @Test
    public void testNearHundred189() {
        assertFalse(nearHundred.nearHundred(189));
    }
    
    @Test
    public void testNearHundred190() {
        assertTrue(nearHundred.nearHundred(190));
    }
    
    @Test
    public void testNearHundred210() {
        assertTrue(nearHundred.nearHundred(210));
    }
    
    @Test
    public void testNearHundred211() {
        assertFalse(nearHundred.nearHundred(211));
    }
    
    
    
}
