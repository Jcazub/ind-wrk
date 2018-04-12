/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.service;

import com.sg.flooringorders.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
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
public class FlooringOrdersServiceLayerTest {
    
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    private FlooringOrdersServiceLayer service = ctx.getBean("serviceLayer", FlooringOrdersServiceLayerImpl.class);
    
    private LocalDate ld = LocalDate.parse("2018-01-01");
    
    public FlooringOrdersServiceLayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        service.importOrders();
        Order order1 = new Order("Jesse", service.findProduct("Wood"), service.findStateTax("OH"), new BigDecimal(200));
        order1.setDate(LocalDate.parse("2018-01-01"));
        Order order2 = new Order("John", service.findProduct("Carpet"), service.findStateTax("IN"), new BigDecimal(100));
        order2.setDate(LocalDate.parse("2018-01-01"));
        
        service.addOrder(order1);
        service.addOrder(order2);
    }
    
    @After
    public void tearDown() throws Exception {
        //List<Integer> tempOrderListKeys = new ArrayList(dao.getOrderListByDate(LocalDate.parse("2018-01-01")).keySet());
        
        List<Order> orders = service.getOrdersByDate(LocalDate.parse("2018-01-01"));
        
        for (Order order : orders) {
            service.removeOrder(LocalDate.parse("2018-01-01"), order.getOrderNumber());
        }
        service.exportOrders();
    }

    /**
     * Test of addOrder method, of class FlooringOrdersServiceLayer.
     */
    @Test
    public void testAddOrderSuccessful() throws Exception {
        Order newOrder = new Order("Brandon", service.findProduct("Tile"), service.findStateTax("MI"), new BigDecimal(50));
        newOrder.setDate(LocalDate.parse("2018-01-01"));
        
        service.addOrder(newOrder);   
        
        assertEquals(newOrder, service.findOrder(LocalDate.parse("2018-01-01"), 3));
    }
    
    @Test
    public void testAddOrderOrderAlreadyExists() throws Exception {
        Order order2 = new Order("John", service.findProduct("Carpet"), service.findStateTax("IN"), new BigDecimal(100));
        order2.setDate(LocalDate.parse("2018-01-01"));
        order2.setOrderNumber(2);
        
        try {
            service.addOrder(order2);
        } catch (OrderAlreadyExistsException e){
            
        }
           
    }
    
    @Test
    public void testAddOrderOrderValidationError() throws Exception {
        Order newOrder = new Order("", service.findProduct("Tile"), service.findStateTax("MI"), new BigDecimal(50));
        newOrder.setDate(LocalDate.parse("2018-01-01"));
        
        try {
            service.addOrder(newOrder);
        } catch (FlooringOrdersValidationException e){
            
        }
           
    }

    /**
     * Test of editOrder method, of class FlooringOrdersServiceLayer.
     */
    @Test
    public void testEditOrderSuccessful() throws Exception {
        Order order2 = new Order("John", service.findProduct("Tile"), service.findStateTax("IN"), new BigDecimal(100));
        order2.setDate(LocalDate.parse("2018-01-01"));
        order2.setOrderNumber(2);
        
        service.editOrder(order2);
        
        assertEquals(order2, service.findOrder(LocalDate.parse("2018-01-01"), 2));
    }
    
    @Test
    public void testEditOrderOrderDoesNotExist() throws Exception {
        Order newOrder = new Order("Brandon", service.findProduct("Tile"), service.findStateTax("MI"), new BigDecimal(50));
        newOrder.setDate(LocalDate.parse("2018-01-01"));
        
        try {
            service.editOrder(newOrder);
        } catch (OrderDoesNotExistException e) {
            
        }
        
        
    }
    
    @Test
    public void testEditOrderValidationError() throws Exception {
        Order order2 = new Order("", service.findProduct("Tile"), service.findStateTax("IN"), new BigDecimal(100));
        order2.setDate(LocalDate.parse("2018-01-01"));
        order2.setOrderNumber(2);
        
        try {
            service.editOrder(order2);
        } catch (FlooringOrdersValidationException e) {
            
        }
        
        
    }

    /**
     * Test of findOrder method, of class FlooringOrdersServiceLayer.
     */
    @Test
    public void testFindOrderSuccessful() throws Exception {
        Order order2 = new Order("John", service.findProduct("Carpet"), service.findStateTax("IN"), new BigDecimal(100));
        order2.setDate(LocalDate.parse("2018-01-01"));
        order2.setOrderNumber(2);
        
        assertEquals(order2, service.findOrder(ld, 2));
    }
    
     @Test
    public void testFindOrderOrderDoesNotExist() throws Exception {
        try {
            service.findOrder(ld, 3);
        } catch (OrderDoesNotExistException e) {
            
        }
    }


    /**
     * Test of removeOrder method, of class FlooringOrdersServiceLayer.
     */
    @Test
    public void testRemoveOrderSucessful() throws Exception {
        service.removeOrder(ld, 2);
        try {
            service.findOrder(ld, 2);
        } catch (OrderDoesNotExistException e) {
            
        }
    }
    
         @Test
    public void testRemoveOrderOrderDoesNotExist() throws Exception {
        try {
            service.removeOrder(ld, 3);
        } catch (OrderDoesNotExistException e) {
            
        }
    }

    /**
     * Test of getOrdersByDate method, of class FlooringOrdersServiceLayer.
     */
    @Test
    public void testGetOrdersByDateSuccessful() throws Exception {
        assertNotNull(service.getOrdersByDate(ld));
    }
    
    @Test
    public void testGetOrdersByDateNoOrdersOnGivenDate() throws Exception {
        
        try {
            service.getOrdersByDate(LocalDate.parse("2016-01-01"));
        } catch (NoOrdersOnGivenDateException e) {
            
        }
        
    }

    /**
     * Test of getProductList method, of class FlooringOrdersServiceLayer.
     */
    @Test
    public void testGetProductList() {
        assertNotNull(service.getProductList());
    }
    
    /**
     * Test of importOrders method, of class FlooringOrdersServiceLayer.
     */
    @Test
    public void testImportOrders() throws Exception {
        service.importOrders();
        Order order1 = new Order("Jesse", service.findProduct("Wood"), service.findStateTax("OH"), new BigDecimal(200));
        order1.setDate(LocalDate.parse("2018-01-01"));
        service.addOrder(order1);
    }

    /**
     * Test of exportOrders method, of class FlooringOrdersServiceLayer.
     */
    @Test
    public void testExportOrders() throws Exception {
        service.exportOrders();
    }

    

    /**
     * Test of findProduct method, of class FlooringOrdersServiceLayer.
     */
    @Test
    public void testFindProductSuccessful() throws Exception {
        assertNotNull(service.findProduct("Carpet"));
    }
    
    @Test
    public void testFindProductProductNotListed() throws Exception {
        
        try {
            service.findProduct("chocolate");
        } catch (ProductNotListedException e) {
            
        }
        
    }

    /**
     * Test of findStateTax method, of class FlooringOrdersServiceLayer.
     */
    @Test
    public void testFindStateTaxSuccessful() throws Exception {
        assertNotNull(service.findStateTax("OH"));
    }
    
    @Test
    public void testFindStateTaxInvalidStateCode() throws Exception {
        try {
            service.findStateTax("Dalaraan");
        } catch (InvalidStateCodeException e) {
            
        }
    }
    
}
