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
public class TrimOneTest {
    
    private TrimOne trimOne = new TrimOne();
    
    public TrimOneTest() {
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
     * Test of trimOne method, of class TrimOne.
     * @throws java.lang.Exception
     */
    @Test
    public void testTrimOneLength1() throws Exception {
        String str = "a";
        
        try {
            trimOne.trimOne(str);
            fail("Expected Section04UnitTestException");
        } catch (Section04UnitTestException e) {
        }
    }
    
    @Test
    public void testTrimOneEmptyString() throws Exception {
        String str = "  ";
        
        try {
            trimOne.trimOne(str);
            fail("Expected Section04UnitTestException");
        } catch (Section04UnitTestException e) {
        }
    }
    
    @Test
    public void testTrimOneLength2WithASpace() throws Exception {
        String str = "a ";
        
        try {
            trimOne.trimOne(str);
            fail("Expected Section04UnitTestException");
        } catch (Section04UnitTestException e) {
        }
    }
    
    @Test
    public void testTrimOneLength2() throws Exception {
        String str = "ab";
        String expected = "";
        
        assertEquals(expected, trimOne.trimOne(str));
    }
    
    @Test
    public void testTrimOneLength3() throws Exception {
        String str = "abc";
        String expected = "b";
        
        assertEquals(expected, trimOne.trimOne(str));
    }
    
    @Test
    public void testTrimOneLength4() throws Exception {
        String str = "abcd";
        String expected = "bc";
        
        assertEquals(expected, trimOne.trimOne(str));
    }
    
}
