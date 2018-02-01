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
public class FirstHalfTest {
    
    private FirstHalf firstHalf = new FirstHalf();
    
    public FirstHalfTest() {
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
     * Test of firstHalf method, of class FirstHalf.
     */
    @Test
    public void testFirstHalfUnevenLength() throws Exception {
        String test = "cho";
        
        try {
            firstHalf.firstHalf(test);
            fail("Expected Section04UnitTestException");
        } catch (Section04UnitTestException e) {
            return;
        }
    }
    
    @Test
    public void testFirstHalfEvenLength() throws Exception {
        String test = "choo";
        
        assertEquals("ch",firstHalf.firstHalf(test));
    }

    @Test
    public void testFirstHalfEvenLengthCapitalLetter() throws Exception {
        String test = "HelloThere";
        
        assertEquals("Hello",firstHalf.firstHalf(test));
    }
    
}
