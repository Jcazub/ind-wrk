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
public class CaughtSpeedingTest {
    
    private CaughtSpeeding caughtSpeeding = new CaughtSpeeding();
    
    public CaughtSpeedingTest() {
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
     * Test of caughtSpeeding method, of class CaughtSpeeding.
     */
    @Test
    public void testCaughtSpeeding60() {
        int speed = 60;
        boolean isBirthday = false;
        
        assertEquals(0, caughtSpeeding.caughtSpeeding(speed, isBirthday)); 
    }
    
    @Test
    public void testCaughtSpeeding61NoBirthday() {
        int speed = 61;
        boolean isBirthday = false;
        
        assertEquals(1, caughtSpeeding.caughtSpeeding(speed, isBirthday)); 
    }
    
    @Test
    public void testCaughtSpeeding80NoBirthday() {
        int speed = 80;
        boolean isBirthday = false;
        
        assertEquals(1, caughtSpeeding.caughtSpeeding(speed, isBirthday)); 
    }
    
    @Test
    public void testCaughtSpeeding81NoBirthday() {
        int speed = 81;
        boolean isBirthday = false;
        
        assertEquals(2, caughtSpeeding.caughtSpeeding(speed, isBirthday)); 
    }
    
    @Test
    public void testCaughtSpeeding65Birthday() {
        int speed = 65;
        boolean isBirthday = true;
        
        assertEquals(0, caughtSpeeding.caughtSpeeding(speed, isBirthday)); 
    }
    
    @Test
    public void testCaughtSpeeding66Birthday() {
        int speed = 66;
        boolean isBirthday = true;
        
        assertEquals(1, caughtSpeeding.caughtSpeeding(speed, isBirthday)); 
    }
    
    @Test
    public void testCaughtSpeeding85Birthday() {
        int speed = 85;
        boolean isBirthday = true;
        
        assertEquals(1, caughtSpeeding.caughtSpeeding(speed, isBirthday)); 
    }
    
    @Test
    public void testCaughtSpeeding86Birthday() {
        int speed = 86;
        boolean isBirthday = true;
        
        assertEquals(2, caughtSpeeding.caughtSpeeding(speed, isBirthday)); 
    }
    
    
    
    
    
}
