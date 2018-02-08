/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.dao;

import com.sg.flooringorders.dto.Order;
import com.sg.flooringorders.dto.Product;
import com.sg.flooringorders.dto.StateTax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class FlooringOrdersDaoFileImpl implements FlooringOrdersDao {
    
    private HashMap<LocalDate, HashMap> masterOrderList = new HashMap<>();
    //private HashMap<Integer, Order> orderList = new HashMap<>();
    private Map<String, Product> productList = new HashMap<>();
    private Map<String, StateTax> stateList = new HashMap<>();
    private static final String DELIMITER = "::";
    private String mode;

    //delete after testing
//    public FlooringOrdersDaoFileImpl() {
////        masterOrderList.put(LocalDate.now(), orderList);
////        productList.put("Carpet", new Product("Carpet", new BigDecimal("2.25"), new BigDecimal("2.10")));
////        
////        stateList.put("OH", new StateTax("OH", new BigDecimal("6.25")));
//        this.mode = mode;
//    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    
    
    
    @Override
    public Order addOrder(Order orderToAdd) { 
        
        int highestOrderNumber = 0;
        
        HashMap<Integer, Order> tempOrderList = this.getOrderListByDate(orderToAdd.getDate());
        
        if (tempOrderList == null) {
            tempOrderList = new HashMap<>();
        }
        List<Order> orders = new ArrayList(tempOrderList.values());
        
//        int orderSize = orders.size();
//        orderToAdd.setOrderNumber(orderSize + 1);
        
        for (Order order : orders) {
            if (order.getOrderNumber() > highestOrderNumber) {
                highestOrderNumber = order.getOrderNumber();
            }
        }
        
        orderToAdd.setOrderNumber(highestOrderNumber + 1);
        
        tempOrderList.put(orderToAdd.getOrderNumber(), orderToAdd);
        this.saveCurrentWork(orderToAdd.getDate(), tempOrderList);
        
        return orderToAdd;
    }

    @Override
    public Order editOrder(Order orderToEdit) {
        //LocalDate date = LocalDate.now();
        //orderToEdit.setDate(date);
        
        HashMap<Integer, Order> tempOrderList = this.getOrderListByDate(orderToEdit.getDate());

        tempOrderList.put(orderToEdit.getOrderNumber(), orderToEdit);
        this.saveCurrentWork(orderToEdit.getDate(), tempOrderList);
        
        return orderToEdit;
    }

    @Override
    public Order findOrder(LocalDate date, int orderNumber) {
        HashMap<Integer, Order> tempOrderList = this.getOrderListByDate(date);
        return tempOrderList.get(orderNumber);
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) {
        HashMap<Integer, Order> tempOrderList = this.getOrderListByDate(date);
        Order removedOrder = tempOrderList.remove(orderNumber);
        this.saveCurrentWork(date, tempOrderList);
        return removedOrder;
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate date) {
        List<Order> orders = new ArrayList<>();
        HashMap<Integer, Order> tempOrderList = this.getOrderListByDate(date);
        if (tempOrderList != null) {
            orders = new ArrayList(tempOrderList.values());
        }
        return orders;
    }

    private void saveCurrentWork(LocalDate date, HashMap orderList) {
        masterOrderList.put(date, orderList);
    }

    @Override
    public HashMap getOrderListByDate(LocalDate date) {
        return masterOrderList.get(date);
    }


    @Override
    public Product findProduct(String productName) {
        return productList.get(productName);
    }
    
    @Override
    public List<Product> getProductList() {
        return new ArrayList(productList.values());
    }

    @Override
    public StateTax findStateTax(String state) {
        return stateList.get(state);
    }
    
    @Override
    public void exportOrders() throws FlooringOrdersPersistenceException {
       if (this.mode.equals("PROD")) {
            this.writeToProductListFile();
            this.writeToStateTaxListFile();
       }
       
       if (this.mode.equals("PROD") || this.mode.equals("TEST")) {
            this.writeToMasterOrderList();
            this.writeToOrderLists(); 
       }
        
    }
    
    public void loadOrderLists() throws FlooringOrdersPersistenceException {
        Scanner masterScanner, orderScanner;
        String currentMasterLine, currentOrderLine;
        String[] currentOrderTokens;
        HashMap<Integer, Order> tempOrderList;
        
        
        try {
            if (this.mode.equals("TEST")) {
                masterScanner = new Scanner(new BufferedReader (new FileReader("TESTMasterOrderList.txt")));
            } else {
                masterScanner = new Scanner(new BufferedReader (new FileReader("MasterOrderList.txt"))); 
            }
            
        } catch (FileNotFoundException e) {
            throw new FlooringOrdersPersistenceException("Could not load Orders", e);
        }
        
        while (masterScanner.hasNextLine()) {
            currentMasterLine = masterScanner.nextLine();
            tempOrderList = new HashMap<>();
            
            try {
                if (this.mode.equals("TEST")) {
                    orderScanner = new Scanner(new BufferedReader (new FileReader("TESTOrders_" + currentMasterLine + ".txt")));
                } else {
                    orderScanner = new Scanner(new BufferedReader (new FileReader("Orders_" + currentMasterLine + ".txt")));
                }
            
            } catch (FileNotFoundException e) {
            throw new FlooringOrdersPersistenceException("Could not load Orders", e);
            }
            
            while (orderScanner.hasNextLine()) {
                currentOrderLine = orderScanner.nextLine();
                currentOrderTokens = currentOrderLine.split(DELIMITER);
                
                Product product = productList.get(currentOrderTokens[2]);
                StateTax state = stateList.get(currentOrderTokens[3]);
                
                Order order = new Order(currentOrderTokens[1], product, state, new BigDecimal(currentOrderTokens[4]));
                
                order.setDate(LocalDate.parse(currentOrderTokens[5]));
                order.setOrderNumber(Integer.parseInt(currentOrderTokens[0]));
                tempOrderList.put(order.getOrderNumber(), order);
                
            }
            masterOrderList.put(LocalDate.parse(currentMasterLine), tempOrderList);
            orderScanner.close();
            
        }
        
        masterScanner.close();
        
        
    }
    
    public void loadProductList() throws FlooringOrdersPersistenceException {
        Scanner scanner;
        String currentLine;
        String[] currentTokens;
        
        
        try {
            scanner = new Scanner(new BufferedReader (new FileReader("ProductList.txt")));
        } catch (FileNotFoundException e) {
            throw new FlooringOrdersPersistenceException("Could not load Products", e);
        }

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            Product product = new Product(currentTokens[0],new BigDecimal(currentTokens[1]), new BigDecimal(currentTokens[2]));
            
            productList.put(product.getProductType(), product);
        }
        
        scanner.close();
    }
    
    public void loadStateTaxList() throws FlooringOrdersPersistenceException {
        Scanner scanner;
        String currentLine;
        String[] currentTokens;
        
        
        try {
            scanner = new Scanner(new BufferedReader (new FileReader("StateTaxList.txt")));
        } catch (FileNotFoundException e) {
            throw new FlooringOrdersPersistenceException("Could not load Products", e);
        }

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            StateTax stateTax = new StateTax(currentTokens[0],new BigDecimal(currentTokens[1]));
            
            stateList.put(stateTax.getStateName(), stateTax);
        }
        
        scanner.close();
    }
    
    public void writeToProductListFile() throws FlooringOrdersPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter( new FileWriter("ProductList.txt"));
        } catch (IOException e) {
            throw new FlooringOrdersPersistenceException("Cound not record Product List", e);
        }
        
        List<Product> allProducts = new ArrayList<>(productList.values());
        
        for (Product currentProduct : allProducts) {
            out.println(currentProduct.getProductType() + DELIMITER
                + currentProduct.getCostPerSqFt() + DELIMITER
                + currentProduct.getLaborCostPerSqFt());
            out.flush();
        }
        out.close(); 
    }
    
    public void writeToStateTaxListFile() throws FlooringOrdersPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter( new FileWriter("StateTaxList.txt"));
        } catch (IOException e) {
            throw new FlooringOrdersPersistenceException("Cound not record State List", e);
        }
        
        List<StateTax> allStateTaxes = new ArrayList<>(stateList.values());
        
        for (StateTax currentState : allStateTaxes) {
            out.println(currentState.getStateName() + DELIMITER
                + currentState.getTaxRate());
            out.flush();
        }
        out.close(); 
    }
    
    public void writeToMasterOrderList() throws FlooringOrdersPersistenceException {
        PrintWriter out;
        
        try {
            if (this.mode.equals("TEST")) {
                out = new PrintWriter( new FileWriter("TESTMasterOrderList.txt"));
            } else {
                out = new PrintWriter( new FileWriter("MasterOrderList.txt"));
            }     
        } catch (IOException e) {
            throw new FlooringOrdersPersistenceException("Cound not record State List", e);
        }
        
        List<LocalDate> allOrderDates = new ArrayList<>(masterOrderList.keySet());
        
        for (LocalDate orderDate : allOrderDates) {
            out.println(orderDate);
            out.flush();
        }
        out.close();
    }
    
    public void writeToOrderLists() throws FlooringOrdersPersistenceException {
        
    List<LocalDate> allOrderDates = new ArrayList<>(masterOrderList.keySet());
    
    for (LocalDate orderDate : allOrderDates) {
            
        PrintWriter out;
        
        try {
            if (this.mode.equals("TEST")) {
                out = new PrintWriter( new FileWriter("TESTOrders_" + orderDate + ".txt"));
            } else {
                out = new PrintWriter( new FileWriter("Orders_" + orderDate + ".txt"));
            }  
        } catch (IOException e) {
            throw new FlooringOrdersPersistenceException("Cound not record State List", e);
        }
        
        List<Order> orders = this.getOrdersByDate(orderDate);
        
        for (Order order : orders) {
            out.println(order.getOrderNumber() + DELIMITER
                            + order.getCustomerName() + DELIMITER
                            + order.getProduct().getProductType() + DELIMITER
                            + order.getStateTax().getStateName() + DELIMITER
                            + order.getArea() + DELIMITER
                            + order.getDate());
            out.flush();
        }
        
        out.close();
        }
    }

    @Override
    public void importOrders() throws FlooringOrdersPersistenceException {
        this.loadProductList();
        this.loadStateTaxList();
        this.loadOrderLists();
    }
    
    
}
