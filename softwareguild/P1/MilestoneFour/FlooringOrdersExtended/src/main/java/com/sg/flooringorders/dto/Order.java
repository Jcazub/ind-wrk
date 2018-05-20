/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import com.sg.flooringorders.dto.Product;

/**
 *
 * @author Jesse
 */
public class Order {
    private int orderNumber;
    private String customerName;
    private BigDecimal area, materialCost = new BigDecimal(0), laborCost = new BigDecimal(0), tax, total;
    private LocalDate date;
    private StateTax stateTax;
    private Product product;
    private HashMap<Integer, IndOrder> orders;

    //delete after refactoring
    public Order(String customerName, Product product, StateTax stateTax, BigDecimal area) {
        this.customerName = customerName;
        this.area = area;
        this.stateTax = stateTax;
        this.product = product;  
        this.materialCost = this.product.getCostPerSqFt().multiply(area).setScale(2, RoundingMode.HALF_UP);
        this.laborCost = this.product.getLaborCostPerSqFt().multiply(area).setScale(2, RoundingMode.HALF_UP);
        this.tax = this.stateTax.getTaxRate().divide(new BigDecimal(100)).multiply(this.materialCost.add(this.laborCost)).setScale(2, RoundingMode.HALF_UP);
        this.total = this.materialCost.add(this.laborCost).add(this.tax);
    }
    
    //new order info
    public Order(String customerName, HashMap<Integer, IndOrder> orders, StateTax stateTax) {
        this.customerName = customerName;
        this.stateTax = stateTax;
        this.orders = orders;
        
        for (IndOrder order : orders.values()) {
            this.materialCost = this.materialCost.add(order.getMaterialCost());
        }
        
        for (IndOrder order : orders.values()) {
            this.laborCost = this.laborCost.add(order.getLaborCost());
        }
       
        this.tax = this.stateTax.getTaxRate().divide(new BigDecimal(100)).multiply(this.materialCost.add(this.laborCost)).setScale(2, RoundingMode.HALF_UP);
        this.total = this.materialCost.add(this.laborCost).add(this.tax);
    }
    
    public Order(Order order) {
        this.customerName = order.getCustomerName();
        this.stateTax = order.getStateTax();
        this.orders = order.getOrders();
        
        for (IndOrder currentOrder : orders.values()) {
            this.materialCost = this.materialCost.add(currentOrder.getMaterialCost());
        }
        
        for (IndOrder currentOrder : orders.values()) {
            this.laborCost = this.laborCost.add(currentOrder.getLaborCost());
        }
       
        this.tax = this.stateTax.getTaxRate().divide(new BigDecimal(100)).multiply(this.materialCost.add(this.laborCost)).setScale(2, RoundingMode.HALF_UP);
        this.total = this.materialCost.add(this.laborCost).add(this.tax);
        this.orderNumber = order.getOrderNumber();
        this.date = order.getDate();
        
    }

    public HashMap<Integer, IndOrder> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<Integer, IndOrder> orders) {
        this.orders = orders;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public void setStateTax(StateTax stateTax) {
        this.stateTax = stateTax;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getArea() {
        return area;
    }

    public BigDecimal getMaterialCost() {
        materialCost = new BigDecimal(0);
        for (IndOrder order : orders.values()) {
            materialCost = materialCost.add(order.getMaterialCost());
        }
        return materialCost;
    }

    public BigDecimal getLaborCost() {
        laborCost = new BigDecimal(0);
        for (IndOrder order : orders.values()) {
            laborCost = laborCost.add(order.getLaborCost());
        }
        return laborCost;
    }

    public BigDecimal getTotal() {
        this.getMaterialCost();
        this.getLaborCost();
        this.getTax();
        return this.total = this.materialCost.add(this.laborCost).add(this.tax);
    }

    public LocalDate getDate() {
        return date;
    }

    public StateTax getStateTax() {
        return stateTax;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getTax() {
        this.getMaterialCost();
        this.getLaborCost();
        return this.tax = this.stateTax.getTaxRate().divide(new BigDecimal(100)).multiply(this.materialCost.add(this.laborCost)).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.orderNumber;
        hash = 31 * hash + Objects.hashCode(this.customerName);
        hash = 31 * hash + Objects.hashCode(this.area);
        hash = 31 * hash + Objects.hashCode(this.materialCost);
        hash = 31 * hash + Objects.hashCode(this.laborCost);
        hash = 31 * hash + Objects.hashCode(this.tax);
        hash = 31 * hash + Objects.hashCode(this.total);
        hash = 31 * hash + Objects.hashCode(this.date);
        hash = 31 * hash + Objects.hashCode(this.stateTax);
        hash = 31 * hash + Objects.hashCode(this.product);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.laborCost, other.laborCost)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.stateTax, other.stateTax)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }
    
//    @Override
//    public String toString() {
//        return "ID: " + orderNumber + " |Customer Name: " + customerName + " |Product: " + product.getProductType() + " |Area: " + area + " |State: " + stateTax.getStateName() + " |Date: " + date + " |Total: " + total;
//    }
    
    @Override
    public String toString() {
        String productsToString = "";
        
        for (IndOrder o : orders.values()) {
            productsToString += " | Item " + o.getOrderNumber() + ": " + o.getProduct().getProductType() + ", " + o.getArea();
        }

        return "Order ID: " + orderNumber + " | Customer Name: " + customerName + " | State: " + stateTax.getStateName() + productsToString + " | Date: " + date + " | Total: " + total;
    }
    
}
