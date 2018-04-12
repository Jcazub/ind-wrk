/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Jesse
 */
public class IndOrder {
    private int orderNumber;
    private BigDecimal area, materialCost, laborCost;
    private Product product;
    
    public IndOrder(Product product, BigDecimal area) {
        this.area = area;
        this.product = product;
        this.materialCost = this.product.getCostPerSqFt().multiply(this.area).setScale(2, RoundingMode.HALF_UP);
        this.laborCost = this.product.getLaborCostPerSqFt().multiply(this.area).setScale(2, RoundingMode.HALF_UP);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getArea() {
        return area;
    }

    public BigDecimal getMaterialCost() {
        return this.materialCost = this.product.getCostPerSqFt().multiply(this.area).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getLaborCost() {
        return this.laborCost = this.product.getLaborCostPerSqFt().multiply(this.area).setScale(2, RoundingMode.HALF_UP);
    }

    public Product getProduct() {
        return product;
    }
    
    
}
