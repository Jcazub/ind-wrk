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
public class FirstLast6Test {
    
    FirstLast6 firstLast6 = new FirstLast6();
    
    public FirstLast6Test() {
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
     * Test of firstLast6 method, of class FirstLast6.
     */
    @Test
    public void testFirstLast6first6() throws Exception {
        int[] testIntArray = {6,1,0,3,2,4};
        
        assertTrue(firstLast6.firstLast6(testIntArray));
    }
    
    @Test
    public void testFirstLast6last6() throws Exception {
        int[] testIntArray = {8,1,0,3,2,6};
        
        assertTrue(firstLast6.firstLast6(testIntArray));
    }
    
    @Test
    public void testFirstLast6both6() throws Exception {
        int[] testIntArray = {6,1,0,3,2,6};
        
        assertTrue(firstLast6.firstLast6(testIntArray));
    }
    
    @Test
    public void testFirstLast6none6() throws Exception {
        int[] testIntArray = {5,1,0,3,2,4};
        
        assertFalse(firstLast6.firstLast6(testIntArray));
    }
    
    @Test
    public void testFirstLast6mid6() throws Exception {
        int[] testIntArray = {3,1,0,6,2,4};
        
        assertFalse(firstLast6.firstLast6(testIntArray));
    }
    
    @Test
    public void testFirstLast6EmptyArray() throws Exception {
        int[] testIntArray = {};
        
        try {
            firstLast6.firstLast6(testIntArray);
            fail("Expected Section03UnitTestsException");
        } catch (Section03UnitTestsException e) {
            return;
        }
    }
}
