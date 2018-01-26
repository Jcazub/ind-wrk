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
public class CommonEndTest {
    
    private CommonEnd commonEnd = new CommonEnd();
    
    public CommonEndTest() {
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
     * Test of commonEnd method, of class CommonEnd.
     */
    @Test
    public void testCommonEndEmptyArray1() throws Exception {
        
        int[] testArray1 = {};
        int[] testArray2 = {1,2,3};
        
        try {
           commonEnd.commonEnd(testArray1, testArray2);
           fail("Expected Section04UnitTestException");
        } catch (Exception e) {
            return;
        }
        
    }
    
    @Test
    public void testCommonEndEmptyArray2() throws Exception {
        
        int[] testArray1 = {1,2,3};
        int[] testArray2 = {};
        
        try {
           commonEnd.commonEnd(testArray1, testArray2);
           fail("Expected Section04UnitTestException");
        } catch (Exception e) {
            return;
        }
        
    }
    
    @Test
    public void testCommonEndBeginningTrue() throws Exception {
        
        int[] testArray1 = {1,2,3};
        int[] testArray2 = {1,2,4};
        
        assertTrue(commonEnd.commonEnd(testArray1, testArray2));
        
    }
    
    @Test
    public void testCommonEndEndingTrue() throws Exception {
        
        int[] testArray1 = {2,2,4};
        int[] testArray2 = {1,2,4};
        
        assertTrue(commonEnd.commonEnd(testArray1, testArray2));
        
    }
    
    @Test
    public void testCommonEndFalse() throws Exception {
        
        int[] testArray1 = {2,2,5};
        int[] testArray2 = {1,2,4};
        
        assertFalse(commonEnd.commonEnd(testArray1, testArray2));
        
    }
    
    @Test
    public void testCommonEndBeginningTrue1WithArrayLength1() throws Exception {
        
        int[] testArray1 = {2};
        int[] testArray2 = {2,2,4};
        
        assertTrue(commonEnd.commonEnd(testArray1, testArray2));
        
    }
    
    @Test
    public void testCommonEndEndingTrue1WithArrayLength1() throws Exception {
        
        int[] testArray1 = {2};
        int[] testArray2 = {1,3,2};
        
        assertTrue(commonEnd.commonEnd(testArray1, testArray2));
        
    }
    
    @Test
    public void testCommonEndBeginningTrue2WithArrayLength1() throws Exception {
        
        int[] testArray2 = {2};
        int[] testArray1 = {2,2,4};
        
        assertTrue(commonEnd.commonEnd(testArray1, testArray2));
        
    }
    
    @Test
    public void testCommonEndEndingTrue2WithArrayLength1() throws Exception {
        
        int[] testArray2 = {2};
        int[] testArray1 = {1,3,2};
        
        assertTrue(commonEnd.commonEnd(testArray1, testArray2));
        
    }
    
}
