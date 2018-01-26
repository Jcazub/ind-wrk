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
public class StringSplosionTest {
    
    private StringSplosion stringSplosion = new StringSplosion();
    
    public StringSplosionTest() {
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
     * Test of stringSplosion method, of class StringSplosion.
     */
    @Test
    public void testStringSplosionEmptyString() throws Exception {
        String str = "";
        
        try {
            stringSplosion.stringSplosion(str);
            fail("Expected Section04UnitTestException");
        } catch (Section04UnitTestException e) {
        }
    }
    
    @Test
    public void testStringSplosionEmptyString2() throws Exception {
        String str = " ";
        
        try {
            stringSplosion.stringSplosion(str);
            fail("Expected Section04UnitTestException");
        } catch (Section04UnitTestException e) {
        }
    }
    
    @Test
    public void testStringSplosionStringSize1() throws Exception {
        String str = "a";
        
        assertEquals("a", stringSplosion.stringSplosion(str));
    }
    
    @Test
    public void testStringSplosionStringSize2() throws Exception {
        String str = "ab";
        
        assertEquals("aab", stringSplosion.stringSplosion(str));
    }
    
    @Test
    public void testStringSplosionStringSize3() throws Exception {
        String str = "abc";
        
        assertEquals("aababc", stringSplosion.stringSplosion(str));
    }
    
    @Test
    public void testStringSplosionStringSize4() throws Exception {
        String str = "abcd";
        
        assertEquals("aababcabcd", stringSplosion.stringSplosion(str));
    }
}
