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
public class FrontTimesTest {
    
    FrontTimes frontTimes = new FrontTimes();
    
    public FrontTimesTest() {
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
     * Test of frontTimes method, of class FrontTimes.
     */
    @Test
    public void testFrontTimesStringAndNumber() {
        String str = "Chocolate";
        int n = 3;
        String expectedResult = "ChoChoCho";
        
        assertEquals(expectedResult, frontTimes.frontTimes(str, n));
    }
    
    @Test
    public void testFrontTimesStringAndNegNumber() {
        String str = "Chocolate";
        int n = -3;
        String expectedResult = "Enter a non-negative number.";
        
        assertEquals(expectedResult, frontTimes.frontTimes(str, n));
    }
    
    @Test
    public void testFrontTimesEmptyStringAndNumber() {
        String str = "";
        int n = 3;
        String expectedResult = "Enter a non-empty string.";
        
        assertEquals(expectedResult, frontTimes.frontTimes(str, n));
    }
    
    @Test
    public void testFrontTimesStringLessThanThreeAndNumber() {
        String str = "Hi";
        int n = 3;
        String expectedResult = "HiHiHi";
        
        assertEquals(expectedResult, frontTimes.frontTimes(str, n));
    }
    
     @Test
    public void testFrontTimesStringAndZero() {
        String str = "Chocolate";
        int n = 0;
        String expectedResult = "";
        
        assertEquals(expectedResult, frontTimes.frontTimes(str, n));
    }
}
