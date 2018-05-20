/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.dao;

import com.sg.flooringorders.dto.Order;
import com.sg.flooringorders.dto.Product;
import com.sg.flooringorders.dto.StateTax;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jesse
 */
public interface FlooringOrdersDao {
    
    //Map<int,Order> orderList = new HashMap<>();
    
    Order addOrder(Order orderToAdd);
    
    Order editOrder(Order orderToEdit);
    
    Order findOrder(LocalDate date, int orderNumber);
    
    Order removeOrder(LocalDate date, int orderNumber);
    
    List<Order> getOrdersByDate(LocalDate date);
    
    List<Product> getProductList();
    
    HashMap getOrderListByDate(LocalDate date);
    
    void exportOrders() throws FlooringOrdersPersistenceException;
    
    void importOrders() throws FlooringOrdersPersistenceException;
    
    Product findProduct(String productName);
    
    StateTax findStateTax(String state);
    
}
