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
public class SleepingInTest {
    
    SleepingIn sleepingIn = new SleepingIn();
    
    public SleepingInTest() {
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
     * Test of canSleepIn method, of class SleepingIn.
     */
    @Test
    public void testCanSleepInisWeekdayonVacation() {
        assertTrue(sleepingIn.canSleepIn(true, true));
    }
    
    @Test
    public void testCanSleepInisNotWeekdayonVacation() {
        assertTrue(sleepingIn.canSleepIn(false, true));
    }
    
    @Test
    public void testCanSleepInisWeekdaynotOnVacation() {
        assertFalse(sleepingIn.canSleepIn(true, false));
    }
    
    @Test
    public void testCanSleepInisNotWeekdayNotOnVacation() {
        assertTrue(sleepingIn.canSleepIn(false, false));
    }
    
}
