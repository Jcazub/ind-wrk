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
public class StringTimesTest {
    
    StringTimes stringTimes = new StringTimes();
    
    public StringTimesTest() {
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
     * Test of stringTimes method, of class StringTimes.
     */
    @Test
    public void testStringTimesStringAndNumber() {
        String testString = "Hi";
        int testInt = 3;
        String expectedResult = "HiHiHi";
        
        assertEquals(expectedResult, stringTimes.stringTimes(testString, testInt));
    }
    
    @Test
    public void testStringTimesStringAndZero() {
        String testString = "Hi";
        int testInt = 0;
        String expectedResult = "";
        
        assertEquals(expectedResult, stringTimes.stringTimes(testString, testInt));
    }
    
    @Test
    public void testStringNullStringAndNumber() {
        String testString = "";
        int testInt = 3;
        String expectedResult = "Enter a non-empty string.";
        
        assertEquals(expectedResult, stringTimes.stringTimes(testString, testInt));

    }
    
    @Test
    public void testStringStringAndNegNumber() {
        String testString = "Hi";
        int testInt = -3;
        
        String expectedResult = "Enter a non-negative number.";
        
        assertEquals(expectedResult, stringTimes.stringTimes(testString, testInt));
    }
    
}
