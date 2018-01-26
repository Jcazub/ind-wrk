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
public class EveryOtherTest {
    
    private EveryOther everyOther = new EveryOther();
    
    public EveryOtherTest() {
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
     * Test of everyOther method, of class EveryOther.
     */
    @Test
    public void testEveryOtherOneChar() {
        String test = "a";
        
        assertEquals("a", everyOther.everyOther(test));
        
    }
    
    @Test
    public void testEveryOtherEmptyString() {
        String test = "";
        
        assertEquals("", everyOther.everyOther(test));
        
    }
    
    @Test
    public void testEveryOtherTwoChar() {
        String test = "ab";
        
        assertEquals("a", everyOther.everyOther(test));
        
    }
    
    @Test
    public void testEveryOtherThreeChar() {
        String test = "abc";
        
        assertEquals("ac", everyOther.everyOther(test));
        
    }
    
    @Test
    public void testEveryOtherFourChar() {
        String test = "abcd";
        
        assertEquals("ac", everyOther.everyOther(test));
        
    }
    
    @Test
    public void testEveryOtherFiveChar() {
        String test = "abcde";
        
        assertEquals("ace", everyOther.everyOther(test));
        
    }
    
}
