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
public class MicheviousChildrenTest {
    
    MicheviousChildren micheviousChildren = new MicheviousChildren();
    
    public MicheviousChildrenTest() {
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
     * Test of areWeInTrouble method, of class MicheviousChildren.
     */
    @Test
    public void testAreWeInTroubleaSmileTruebSmileTrue() {
        assertTrue(micheviousChildren.areWeInTrouble(true, true));
    }
    
    @Test
    public void testAreWeInTroubleaSmileTruebSmileFalse() {
        assertFalse(micheviousChildren.areWeInTrouble(true, false));
    }
    
    @Test
    public void testAreWeInTroubleaSmileFalsebSmileTrue() {
        assertFalse(micheviousChildren.areWeInTrouble(false, true));
    }
    
    @Test
    public void testAreWeInTroubleaSmileFalsebSmileFalse() {
        assertTrue(micheviousChildren.areWeInTrouble(false, false));
    }
    
}
