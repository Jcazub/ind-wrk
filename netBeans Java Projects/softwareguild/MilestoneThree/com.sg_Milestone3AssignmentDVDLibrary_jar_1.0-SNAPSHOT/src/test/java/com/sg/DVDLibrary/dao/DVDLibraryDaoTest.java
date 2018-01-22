/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DVDLibrary.dao;

import com.sg.DVDLibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jesse
 */
public class DVDLibraryDaoTest {
    
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    private DVDLibraryDao dao = ctx.getBean("DVDLibraryDao", DVDLibraryDao.class);
    
    public DVDLibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<DVD> DVDLibrary = new ArrayList<>();
        
        for (DVD currentDvd : DVDLibrary) {
            dao.removeDVD(currentDvd.getTitle());
        }
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testAddandFindDVD() throws Exception {
        DVD testDVD = new DVD("TestDVD");
        testDVD.setDirectorName("TestDirector");
        testDVD.setStudio("TestStudio");
        testDVD.setReleaseDate("2017-12-31");
        testDVD.setMpaaRating("R");
        testDVD.setAdditionalNote("This is a test case");
        
        dao.addDVD(testDVD.getTitle(),testDVD);
        
        DVD daoDVD = dao.findDVD(testDVD.getTitle());
        
        assertEquals(testDVD, daoDVD);
    }

    /**
     * Test of removeDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        DVD testDVD = new DVD("TestDVD");
        testDVD.setDirectorName("TestDirector");
        testDVD.setStudio("TestStudio");
        testDVD.setReleaseDate("2017-12-31");
        testDVD.setMpaaRating("R");
        testDVD.setAdditionalNote("This is a test case");
        
        dao.addDVD(testDVD.getTitle(),testDVD);
        
        assertEquals(1, dao.findAllDVDs().size());
        
        DVD daoDVD = dao.removeDVD(testDVD.getTitle());
        
        assertEquals(0, dao.findAllDVDs().size());
        
        assertEquals(testDVD, daoDVD);
    }

    /**
     * Test of editDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testEditDVD() throws Exception {
        DVD testDVD = new DVD("TestDVD");
        testDVD.setDirectorName("TestDirector");
        testDVD.setStudio("TestStudio");
        testDVD.setReleaseDate("2017-12-31");
        testDVD.setMpaaRating("R");
        testDVD.setAdditionalNote("This is a test case");
        
        dao.addDVD(testDVD.getTitle(),testDVD);
        
        DVD daoDVD = dao.editDVD(testDVD.getTitle(), testDVD);
        
        assertEquals(testDVD, daoDVD);  
    }

    /**
     * Test of findAllDVDs method, of class DVDLibraryDao.
     */
    @Test
    public void testFindAllDVDs() throws Exception {
        DVD testDVD = new DVD("TestDVD");
        testDVD.setDirectorName("TestDirector");
        testDVD.setStudio("TestStudio");
        testDVD.setReleaseDate("2017-12-31");
        testDVD.setMpaaRating("R");
        testDVD.setAdditionalNote("This is a test case");
        
        dao.addDVD(testDVD.getTitle(),testDVD);
        
        DVD testDVD2 = new DVD("TestDVD2");
        testDVD2.setDirectorName("TestDirector2");
        testDVD2.setStudio("TestStudio2");
        testDVD2.setReleaseDate("2017-11-30");
        testDVD2.setMpaaRating("PG - 13");
        testDVD2.setAdditionalNote("This is another test case");
        
        dao.addDVD(testDVD2.getTitle(), testDVD2);
        
        List<DVD> testingFindAllDVDs = new ArrayList<>();
        
        // caveat when comparing lists directly, List is ordered
        // "alphabetically. better to just compare size
        testingFindAllDVDs.add(testDVD2);
        testingFindAllDVDs.add(testDVD);
        
        assertEquals(2, dao.findAllDVDs().size());
        assertEquals(testingFindAllDVDs, dao.findAllDVDs());   
    }
    
}
