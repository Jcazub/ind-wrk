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
public class MakePiTest {
    
    MakePi makePi = new MakePi();
    
    public MakePiTest() {
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
     * Test of makePi method, of class MakePi.
     */
    @Test
    public void testMakePi1() {
        int n = 1;
        int[] expectedResult = {3};
        
        assertArrayEquals(expectedResult, makePi.makePi(n));
    }
    
    @Test
    public void testMakePi3() {
        int n = 3;
        int[] expectedResult = {3,1,4};
        
        assertArrayEquals(expectedResult, makePi.makePi(n));
    }
    
    @Test
    public void testMakePi10() {
        int n = 10;
        int[] expectedResult = {3,1,4,1,5,9,2,6,5,3};
        
        assertArrayEquals(expectedResult, makePi.makePi(n));
    }
    
    @Test
    public void testMakePi0() {
        int n = 0;
        int[] expectedResult = {};
        
        assertArrayEquals(expectedResult, makePi.makePi(n));
    }
    
}
