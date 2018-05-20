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
public class InsertWordTest {
    
    private InsertWord insertWord = new InsertWord();
    
    public InsertWordTest() {
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
     * Test of insertWord method, of class InsertWord.
     */
    @Test
    public void testInsertWordWrongSizeContainer() throws Exception {
        String container = "<<>";
        String inside = "whoo";
        
        try {
            insertWord.insertWord(container, inside);
            fail("Expected Section04UnitTestException");
        } catch (Exception e) {
            return;
        }
    }
    
    @Test
    public void testInsertWordWrongSizeContainerWhiteSpace() throws Exception {
        String container = "<< >";
        String inside = "whoo";
        
        try {
            insertWord.insertWord(container, inside);
            fail("Expected Section04UnitTestException");
        } catch (Exception e) {
            return;
        }
    }
    
    @Test
    public void testInsertWordEmptyContainer() throws Exception {
        String container = "    ";
        String inside = "whoo";
        
        try {
            insertWord.insertWord(container, inside);
            fail("Expected Section04UnitTestException");
        } catch (Exception e) {
            return;
        }
    }
    
    @Test
    public void testInsertWordCorrect() throws Exception {
        String container = "<<>>";
        String inside = "whoo";
        
        assertEquals("<<whoo>>",insertWord.insertWord(container, inside));
   
    }
    
    @Test
    public void testInsertWordEmptyInside() throws Exception {
        String container = "<<>>";
        String inside = "";
        
        assertEquals("<<>>",insertWord.insertWord(container, inside));
        
    }
    
}
