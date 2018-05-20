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
public class PlayOutsideTest {
    
    PlayOutside playOutside = new PlayOutside();
    
    public PlayOutsideTest() {
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
     * Test of playOutside method, of class PlayOutside.
     */
    @Test
    public void testPlayOutside59summer() {
        int temp = 59;
        boolean isSummer = true;
        
        assertFalse(playOutside.playOutside(temp, isSummer));
    }
    
    @Test
    public void testPlayOutside60summer() {
        int temp = 60;
        boolean isSummer = true;
        
        assertTrue(playOutside.playOutside(temp, isSummer));
    }
    
    @Test
    public void testPlayOutside100summer() {
        int temp = 100;
        boolean isSummer = true;
        
        assertTrue(playOutside.playOutside(temp, isSummer));
    }
    
    @Test
    public void testPlayOutside101summer() {
        int temp = 101;
        boolean isSummer = true;
        
        assertFalse(playOutside.playOutside(temp, isSummer));
    }
    
    @Test
    public void testPlayOutside59notSummer() {
        int temp = 59;
        boolean isSummer = false;
        
        assertFalse(playOutside.playOutside(temp, isSummer));
    }
    
    @Test
    public void testPlayOutside60notSummer() {
        int temp = 60;
        boolean isSummer = false;
        
        assertTrue(playOutside.playOutside(temp, isSummer));
    }
    
    @Test
    public void testPlayOutside90notSummer() {
        int temp = 90;
        boolean isSummer = false;
        
        assertTrue(playOutside.playOutside(temp, isSummer));
    }
    
    @Test
    public void testPlayOutside91notSummer() {
        int temp = 91;
        boolean isSummer = false;
        
        assertFalse(playOutside.playOutside(temp, isSummer));
    }
    
}
