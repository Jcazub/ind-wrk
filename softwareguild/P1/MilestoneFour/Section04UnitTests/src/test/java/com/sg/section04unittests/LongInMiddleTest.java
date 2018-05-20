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
public class LongInMiddleTest {
    
    private LongInMiddle longInMiddle = new LongInMiddle();
    
    public LongInMiddleTest() {
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
     * Test of longInMiddle method, of class LongInMiddle.
     * @throws java.lang.Exception
     */
    @Test
    public void testLongInMiddleSameLength() throws Exception {
        String str1 = "test";
        String str2 = "test";
        
        try {
            longInMiddle.longInMiddle(str1, str2);
            fail("Expected Section04UnitTestException");
        } catch (Section04UnitTestException e) {
        }
        
    }
    
    @Test
    public void testLongInMiddleEmptyStrings() throws Exception {
        String str1 = "";
        String str2 = "";
        String expected = "";
        
        assertEquals(expected, longInMiddle.longInMiddle(str1, str2));
    }
    
    @Test
    public void testLongInMiddleEmptyFirst() throws Exception {
        String str1 = "";
        String str2 = "apple";
        String expected = "apple";
        
        assertEquals(expected, longInMiddle.longInMiddle(str1, str2));
    }
    
    @Test
    public void testLongInMiddleEmptySecond() throws Exception {
        String str1 = "grape";
        String str2 = "";
        String expected = "grape";
        
        assertEquals(expected, longInMiddle.longInMiddle(str1, str2));
    }
    
    @Test
    public void testLongInMiddleFirstShort() throws Exception {
        String str1 = "hello";
        String str2 = "goodbye";
        String expected = "hellogoodbyehello";
        
        assertEquals(expected, longInMiddle.longInMiddle(str1, str2));
    }
    
    @Test
    public void testLongInMiddleSecondShort() throws Exception {
        String str1 = "what";
        String str2 = "why";
        String expected = "whywhatwhy";
        
        assertEquals(expected, longInMiddle.longInMiddle(str1, str2));
    }
    
    
    
}
