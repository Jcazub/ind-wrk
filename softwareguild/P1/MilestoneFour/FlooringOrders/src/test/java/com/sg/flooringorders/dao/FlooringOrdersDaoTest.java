/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.dao;

import com.sg.flooringorders.dto.Order;
import com.sg.flooringorders.dto.Product;
import com.sg.flooringorders.dto.StateTax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jesse
 */
public class FlooringOrdersDaoTest {
    
    
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
    private FlooringOrdersDao dao = ctx.getBean("dao", FlooringOrdersDaoFileImpl.class);
    
    public FlooringOrdersDaoTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() throws FlooringOrdersPersistenceException {
        dao.importOrders();
        Order order1 = new Order("Jesse", dao.findProduct("Wood"), dao.findStateTax("OH"), new BigDecimal(200));
        order1.setDate(LocalDate.parse("2018-01-01"));
        Order order2 = new Order("John", dao.findProduct("Carpet"), dao.findStateTax("IN"), new BigDecimal(100));
        order2.setDate(LocalDate.parse("2018-01-01"));
        
        dao.addOrder(order1);
        dao.addOrder(order2);
    }
    
    @After
    public void tearDown() throws FlooringOrdersPersistenceException {
        
        //remove all orderlists according to masterorderlist
        //clear masterorderlist
        
        List<Integer> tempOrderListKeys = new ArrayList(dao.getOrderListByDate(LocalDate.parse("2018-01-01")).keySet());
        
        for (Integer key : tempOrderListKeys) {
            dao.removeOrder(LocalDate.parse("2018-01-01"), key);
        }
        dao.exportOrders();
       
                
    }

    /**
     * Test of addOrder method, of class FlooringOrdersDao.
     */
    @Test
    public void testAddOrder() {
        Order newOrder = new Order("Brandon", dao.findProduct("Tile"), dao.findStateTax("MI"), new BigDecimal(50));
        newOrder.setDate(LocalDate.parse("2018-01-01"));
        
        dao.addOrder(newOrder);   
        
        assertEquals(newOrder, dao.findOrder(LocalDate.parse("2018-01-01"), 3));
    }

    /**
     * Test of editOrder method, of class FlooringOrdersDao.
     */
    @Test
    public void testEditOrder() {
        Order order2 = new Order("John", dao.findProduct("Tile"), dao.findStateTax("IN"), new BigDecimal(100));
        order2.setDate(LocalDate.parse("2018-01-01"));
        order2.setOrderNumber(2);
        
        dao.editOrder(order2);
        
        assertEquals(order2, dao.findOrder(LocalDate.parse("2018-01-01"), 2));
        
        
    }

    /**
     * Test of findOrder method, of class FlooringOrdersDao.
     */
    @Test
    public void testFindOrder() {
        Order order2 = new Order("John", dao.findProduct("Carpet"), dao.findStateTax("IN"), new BigDecimal(100));
        order2.setDate(LocalDate.parse("2018-01-01"));
        order2.setOrderNumber(2);
        
        assertEquals(order2, dao.findOrder(LocalDate.parse("2018-01-01"), 2));
        
    }

    /**
     * Test of removeOrder method, of class FlooringOrdersDao.
     */
    @Test
    public void testRemoveOrder() {
        dao.removeOrder(LocalDate.parse("2018-01-01"), 2);
        
        assertNull(dao.findOrder(LocalDate.parse("2018-01-01"), 2));
    }

    /**
     * Test of getOrdersByDate method, of class FlooringOrdersDao.
     */
    @Test
    public void testGetOrdersByDate() {
        List orderList = dao.getOrdersByDate(LocalDate.parse("2018-01-01"));
        assertEquals(2, orderList.size());
    }

    /**
     * Test of getProductList method, of class FlooringOrdersDao.
     */
    @Test
    public void testGetProductList() {
        List productList = dao.getProductList();
        
        assertEquals(4, productList.size());
    }

    /**
     * Test of getOrderListByDate method, of class FlooringOrdersDao.
     */
    @Test
    public void testGetOrderListByDate() {
        HashMap orderList = dao.getOrderListByDate(LocalDate.parse("2018-01-01"));
        
        assertNotNull(orderList.get(1));
    }

    /**
     * Test of exportOrders method, of class FlooringOrdersDao.
     */
    @Test
    public void testExportOrders() throws Exception {
        dao.exportOrders();
    }

    /**
     * Test of importOrders method, of class FlooringOrdersDao.
     */
    @Test
    public void testImportOrders() throws Exception {
        dao.importOrders();
    }

    /**
     * Test of findProduct method, of class FlooringOrdersDao.
     */
    @Test
    public void testFindProduct() {
        Product testProduct = new Product("Laminate", new BigDecimal("1.75"), new BigDecimal("2.10"));
        assertEquals(testProduct, dao.findProduct(testProduct.getProductType()));
    }

    /**
     * Test of findStateTax method, of class FlooringOrdersDao.
     */
    @Test
    public void testFindStateTax() {
        StateTax testState = new StateTax("OH", new BigDecimal("6.25"));
        assertEquals(testState, dao.findStateTax(testState.getStateName()));
    }


    
}
