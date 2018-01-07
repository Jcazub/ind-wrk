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
public class MakeTagsTest {
    
    MakeTags makeTags = new MakeTags();
    
    public MakeTagsTest() {
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
     * Test of makeTags method, of class MakeTags.
     */
    @Test
    public void testMakeTagsI() throws Exception {
        String tag = "i";
        String content = "Yay!";
        String expectedResult = "<i>Yay!</i>";
        
        assertEquals(expectedResult, makeTags.makeTags(tag, content));
    }
    
    @Test
    public void testMakeTagsCite() throws Exception {
        String tag = "cite";
        String content = "Yay!";
        String expectedResult = "<cite>Yay!</cite>";
        
        assertEquals(expectedResult, makeTags.makeTags(tag, content));
    }
    
    @Test
    public void testMakeTagsNoTag() throws Exception {
        String tag = "";
        String content = "Yay!";
        
        try {
            makeTags.makeTags(tag, content);
            fail("Section03UnitTestsException not thrown");
        } catch (Section03UnitTestsException e) {
            return;
        }
        
    }
    
    @Test
    public void testMakeTagsNoContent() throws Exception {
        String tag = "";
        String content = "Yay!";
        
        try {
            makeTags.makeTags(tag, content);
            fail("Section03UnitTestsException not thrown");
        } catch (Section03UnitTestsException e) {
            return;
        }
        
    }
    
}
