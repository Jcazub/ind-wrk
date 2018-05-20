/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.service;

import com.sg.flooringorders.dao.FlooringOrdersPersistenceException;
import com.sg.flooringorders.dto.Order;
import com.sg.flooringorders.dto.Product;
import com.sg.flooringorders.dto.StateTax;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Jesse
 */
public interface FlooringOrdersServiceLayer {
    
    Order addOrder(Order orderToAdd) throws OrderAlreadyExistsException, FlooringOrdersValidationException;
    
    Order editOrder(Order orderToEdit) throws OrderDoesNotExistException, FlooringOrdersValidationException;
    
    Order findOrder(LocalDate date, int orderNumber) throws OrderDoesNotExistException;
    
    Order removeOrder(LocalDate date, int orderNumber) throws OrderDoesNotExistException;
    
    List<Order> getOrdersByDate(LocalDate date) throws NoOrdersOnGivenDateException;
    
    List<Product> getProductList();
    
    void exportOrders() throws FlooringOrdersPersistenceException;
    
    void importOrders() throws FlooringOrdersPersistenceException;
    
    Product findProduct(String productName) throws ProductNotListedException;
    
    StateTax findStateTax(String state) throws InvalidStateCodeException;
    
}
