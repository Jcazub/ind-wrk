/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesse
 */
public class RotateLeftTest {
    
    private RotateLeft rotateLeft = new RotateLeft();
    
    public RotateLeftTest() {
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
     * Test of rotateLeft method, of class RotateLeft.
     */
    @Test
    public void testRotateLeft1index() throws Exception {
        int[] test = {1};
        int[] expected = {1};
        
        assertArrayEquals(expected, rotateLeft.rotateLeft(test));
    }
    
    @Test
    public void testRotateLeftNull() throws Exception {
        int[] test = null;
        
        try {
           rotateLeft.rotateLeft(test); 
           fail("Expected Section04UnitTestExpection");
        } catch (Section04UnitTestException e) {
        }
        
    }
    
    @Test
    public void testRotateLeft2index() throws Exception {
        int[] test = {1,2};
        int[] expected = {2,1};
        
        assertArrayEquals(expected, rotateLeft.rotateLeft(test));
    }
    
    @Test
    public void testRotateLeft3index() throws Exception {
        int[] test = {1,2,3};
        int[] expected = {2,3,1};
        
        assertArrayEquals(expected, rotateLeft.rotateLeft(test));
    }
    
}
