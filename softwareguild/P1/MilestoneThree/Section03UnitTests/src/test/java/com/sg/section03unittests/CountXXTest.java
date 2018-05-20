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
public class CountXXTest {
    
    CountXX countXX = new CountXX();
    
    public CountXXTest() {
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
     * Test of countXX method, of class CountXX.
     */
    @Test
    public void testCountXXone() {
        String str = "abcxx";
        
        assertEquals(1, countXX.countXX(str));
    }
    
    @Test
    public void testCountXXtwo() {
        String str = "abcxxx";
        
        assertEquals(2, countXX.countXX(str));
    }
    
    @Test
    public void testCountXXthree() {
        String str = "xxxx";
        
        assertEquals(3, countXX.countXX(str));
    }
    
    @Test
    public void testCountXXnone() {
        String str = "abc";
        
        assertEquals(0, countXX.countXX(str));
    }
    
    @Test
    public void testCountXXchar() {
        String str = "a";
        
        assertEquals(0, countXX.countXX(str));
    }
    
    @Test
    public void testCountXXEmptyString() {
        String str = "";
        
        assertEquals(0, countXX.countXX(str));
    }
    
}
