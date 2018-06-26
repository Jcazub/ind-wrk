/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.service;

import com.sg.flooringorders.dao.FlooringOrdersAuditDao;
import com.sg.flooringorders.dao.FlooringOrdersDao;
import com.sg.flooringorders.dao.FlooringOrdersPersistenceException;
import com.sg.flooringorders.dto.Order;
import com.sg.flooringorders.dto.Product;
import com.sg.flooringorders.dto.StateTax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


public class FlooringOrdersServiceLayerImpl implements FlooringOrdersServiceLayer {
    
    private FlooringOrdersDao dao;

    public FlooringOrdersServiceLayerImpl(FlooringOrdersDao dao) {
        this.dao = dao;
    }

    @Override
    public Order addOrder(Order orderToAdd) throws OrderAlreadyExistsException, FlooringOrdersValidationException {
        //verify if order is already added
        if (orderToAdd.getOrderNumber() > 0) {
            throw new OrderAlreadyExistsException("Order Already Exists");
        }
        
        //verify data is valid
        this.validateData(orderToAdd);
        
        return dao.addOrder(orderToAdd);
    }

    @Override
    public Order editOrder(Order orderToEdit) throws OrderDoesNotExistException, FlooringOrdersValidationException {
        //EDIT
        if (orderToEdit.getOrderNumber() <= 0) {
            throw new OrderDoesNotExistException("Order does not exist in records.");
        }
        
        this.validateData(orderToEdit);
        
        return dao.editOrder(orderToEdit);
    }

    @Override
    public Order findOrder(LocalDate date, int orderNumber) throws OrderDoesNotExistException {
        Order order = dao.findOrder(date, orderNumber);
        
        if (order == null) {
            throw new OrderDoesNotExistException("Order does not exist in records.");
        }
        
        return order;
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws OrderDoesNotExistException {
        Order order = dao.findOrder(date, orderNumber);
        
        if (order == null) {
            throw new OrderDoesNotExistException("Order does not exist in records.");
        }
        
        return dao.removeOrder(date, orderNumber);
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate date) throws NoOrdersOnGivenDateException {
        List<Order> orders = dao.getOrdersByDate(date);
        
        if (orders.isEmpty()) {
            throw new NoOrdersOnGivenDateException("There are no orders for this given date");
        }
        
        return orders;
    }

    @Override
    public void exportOrders() throws FlooringOrdersPersistenceException {
        dao.exportOrders();
    }

    @Override
    public void importOrders() throws FlooringOrdersPersistenceException {
        dao.importOrders();
    }

    @Override
    public Product findProduct(String productName) throws ProductNotListedException {
        Product product = dao.findProduct(productName);
        
        if (product == null) {
            throw new ProductNotListedException("Product Not Listed");
        }
        
        return product;
    }
    
    @Override
    public List<Product> getProductList() {
        return dao.getProductList();
    }

    @Override
    public StateTax findStateTax(String state) throws InvalidStateCodeException {
        StateTax stateTax = dao.findStateTax(state);
        
        if (stateTax == null) {
            throw new InvalidStateCodeException("State Code entered incorrectly");
        }
        
        return stateTax;
    }
    
    private void validateData(Order order) throws FlooringOrdersValidationException {
        if (order.getCustomerName() == null
                || order.getCustomerName().trim().length() == 0
                || order.getCustomerName().contains(":")
                || order.getProduct() == null
                || order.getStateTax() == null
                || order.getArea().compareTo(new BigDecimal(0)) <= 0 
                || order.getDate() == null) {
            
            throw new FlooringOrdersValidationException("ERROR: Data fields for order invalid. Try again.");
                }
    }
    
    
}
