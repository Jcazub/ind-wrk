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
public class MultipleEndingsTest {
    
    private MultipleEndings multipleEndings = new MultipleEndings();
    
    public MultipleEndingsTest() {
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
     * Test of multipleEndings method, of class MultipleEndings.
     */
    @Test
    public void testMultipleEndingsEmptyString() throws Exception {
        String test = "";
        
        try {
            multipleEndings.multipleEndings(test);
            fail("Expected Section04UnitTestException");
        } catch (Exception e) {
            return;
        }
   
    }
    
    @Test
    public void testMultipleEndingsStringLength1() throws Exception {
        String test = "a";
        
        try {
            multipleEndings.multipleEndings(test);
            fail("Expected Section04UnitTestException");
        } catch (Exception e) {
            return;
        }
   
    }
    
    @Test
    public void testMultipleEndingsStringLength2() throws Exception {
        String test = "ab";
        
        assertEquals("ababab", multipleEndings.multipleEndings(test));
   
    }
    
    @Test
    public void testMultipleEndingsStringLength4() throws Exception {
        String test = "hello";
        
        assertEquals("lololo", multipleEndings.multipleEndings(test));
   
    }
    
    
    
}
