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
public class AlarmClockTest {
    
    private AlarmClock alarmClock = new AlarmClock();
    
    public AlarmClockTest() {
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
     * Test of alarmClock method, of class AlarmClock.
     */
    @Test
    public void testAlarmClockMondayNoVac() throws Exception {
        int day = 1;
        boolean vacation = false;
        
        assertEquals("7:00", alarmClock.alarmClock(day, vacation));
        
    }
    
    @Test
    public void testAlarmClockSundayNoVac() throws Exception {
        int day = 0;
        boolean vacation = false;
        
        assertEquals("10:00", alarmClock.alarmClock(day, vacation));
        
    }
    
    @Test
    public void testAlarmClockMondayVac() throws Exception {
        int day = 1;
        boolean vacation = true;
        
        assertEquals("10:00", alarmClock.alarmClock(day, vacation));
        
    }
    
    @Test
    public void testAlarmClockSundayVac() throws Exception {
        int day = 0;
        boolean vacation = true;
        
        assertEquals("OFF", alarmClock.alarmClock(day, vacation));
        
    }
    
    @Test
    public void testAlarmClockDayOutOfBounds() throws Exception {
        int day = 8;
        boolean vacation = true;
        
        try {
            alarmClock.alarmClock(day, vacation);
            fail("Expected Section04UniteTestException");
        } catch (Section04UnitTestException e) {
            return;
        }
        
    }
    
}
