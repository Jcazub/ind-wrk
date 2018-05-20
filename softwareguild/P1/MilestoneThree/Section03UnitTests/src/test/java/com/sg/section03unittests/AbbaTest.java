/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

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
public class AbbaTest {
    
    Abba abba = new Abba();
    
    public AbbaTest() {
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
     * Test of abba method, of class Abba.
     */
    @Test
    public void testAbba() {
        String a = "Hi";
        String b = "Bye";
        String expectedResult = "HiByeByeHi";
        
        assertEquals(expectedResult, abba.abba(a, b));
    }
    
    @Test
    public void testAbbaEmptyA() {
        String a = "";
        String b = "Bye";
        String expectedResult = "Enter a non-empty input for a";
        
        assertEquals(expectedResult, abba.abba(a, b));
    }
    
    @Test
    public void testAbbaEmptyB() {
        String a = "Hi";
        String b = "";
        String expectedResult = "Enter a non-empty input for b";
        
        assertEquals(expectedResult, abba.abba(a, b));
    }
    
}
