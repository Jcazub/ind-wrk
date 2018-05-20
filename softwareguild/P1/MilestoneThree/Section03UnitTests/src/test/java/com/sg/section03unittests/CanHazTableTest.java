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
public class CanHazTableTest {
    
    CanHazTable canHazTable = new CanHazTable();
    
    public CanHazTableTest() {
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
     * Test of canHazTable method, of class CanHazTable.
     */  
    @Test
    public void testCanHazTableBothStylish() {
        int you = 8;
        int date = 8;
        
        assertEquals(2, canHazTable.canHazTable(you, date));
    }
    
    @Test
    public void testCanHazTableYouStylishDateMid() {
        int you = 8;
        int date = 7;
        
        assertEquals(2, canHazTable.canHazTable(you, date));
    }
    
    @Test
    public void testCanHazTableYouStylishDateNot() {
        int you = 8;
        int date = 2;
        
        assertEquals(0, canHazTable.canHazTable(you, date));
    }
    
    @Test
    public void testCanHazTableYouMidStylishDateStylish() {
        int you = 7;
        int date = 8;
        
        assertEquals(2, canHazTable.canHazTable(you, date));
    }
    
    @Test
    public void testCanHazTableYouNotStylishDateStylish() {
        int you = 2;
        int date = 8;
        
        assertEquals(0, canHazTable.canHazTable(you, date));
    }
    
    @Test
    public void testCanHazTableBothMidStylish() {
        int you = 7;
        int date = 7;
        
        assertEquals(1, canHazTable.canHazTable(you, date));
    }
    
    @Test
    public void testCanHazTableBothNotStylish() {
        int you = 2;
        int date = 2;
        
        assertEquals(0, canHazTable.canHazTable(you, date));
    }
    
    @Test
    public void testCanHazTableYouMidStylishDateNot() {
        int you = 7;
        int date = 2;
        
        assertEquals(0, canHazTable.canHazTable(you, date));
    }
    
    @Test
    public void testCanHazTableYouNotDateMidStylish() {
        int you = 2;
        int date = 7;
        
        assertEquals(0, canHazTable.canHazTable(you, date));
    }
    
}
