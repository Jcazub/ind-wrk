/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.ui;

import com.sg.flooringorders.dto.Order;
import com.sg.flooringorders.dto.Product;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Jesse
 */
public class FlooringOrdersView {
    UserIO io;

    public FlooringOrdersView(UserIO io) {
        this.io = io;
    }
    
    public void displayMenu() {
        io.print("1. Display Orders\n"
                + "2. Display Products\n"
                + "3. Add an Order\n"
                + "4. Edit an Order\n"
                + "5. Remove an Order\n"
                + "6. Save Current Session\n"
                + "7. Quit");
    }
    
    public int getUserSelection() {
        return io.readInt("Selection?");
    }
    
    public LocalDate getDateFromUser() {
        return LocalDate.parse(io.readString("Enter Date (YYYY-MM-DD)"));
    }
    
    public void displayOrders(List<Order> orders) {
        orders.stream()
                .forEach(o -> io.print("ID: " + o.getOrderNumber() + ", Customer Name: " + o.getCustomerName() + ", Order Date: " + o.getDate() + ", Material: " + o.getProduct().getProductType() + ", Area: " + o.getArea() + ", Total: " + o.getTotal()));
    }
    
    public void displayOrder(Order order) {
        io.print("Customer Name: " + order.getCustomerName() + ", Order Date: " + order.getDate() + ", Material: " + order.getProduct().getProductType() + ", Area: " + order.getArea() + ", Total: " + order.getTotal());
    }
    
    public void displayProducts(List<Product> products) {
        products.stream()
                .forEach(p -> io.print("ProductName: " + p.getProductType() + ", Material Cost Per Square Foot: " + p.getCostPerSqFt() + ", Labor Cost Per Square Foot: " + p.getLaborCostPerSqFt()));
    }
    
    public String[] getNewOrder() throws InputErrorException {
        String name = io.readString("Customer Name: ");
        String materialName = io.readString("Material: ");
        String state = io.readString("State (i.e. NY): ");
        String area = io.readString("Area: ");
        
        this.newBigDCheck(area);
        
        String[] newOrderDetails = {name, materialName, state, area};
        return newOrderDetails;
    }
    
    public String[] editOrderRequest(Order orderToEdit) {
        String name = "", materialName = "", state = "", area = "";
        
        do {
            int choice = io.readInt("Which field would you like to edit?\n"
                    + "1. Customer Name\n"
                    + "2. Material\n"
                    + "3. State\n"
                    + "4. Area",
                    1, 4);
            
            switch(choice) {
                case 1:
                    name = io.readString("Enter Customer Name (Current: " + orderToEdit.getCustomerName() + "):");
                    break;
                case 2:
                    materialName = io.readString("Enter Material: (Current: " + orderToEdit.getProduct().getProductType() + "):");  
                    break;
                case 3:
                    state = io.readString("Enter State: (Current: " + orderToEdit.getStateTax().getStateName() + "):");
                    break;
                case 4:
                    area = io.readString("Enter Area: (Current: " + orderToEdit.getArea() + "):");
                    break;
            }
        } while (this.verify("Edit more fields?"));
        
        String[] newEditedDetails = {name, materialName, state, area};
        return newEditedDetails;
    }
    
    public String[] getOrderDetails() {
        String date = io.readString("Enter Date (YYYY-MM-DD)");
        String orderNumber = io.readString("Enter order number");
        
        String[] userRequestDetails = {date, orderNumber};
        return userRequestDetails;
    }
    
    public void displayError(String errMessage) {
        io.print("===== ERROR =====");
        io.print(errMessage);
    }
    
    public void displayExitMessage() {
        io.print("Closing Orders...");
    }
    
    public void displayUnknownCommand() {
        io.print("===== Unknown Command =====");
    }
    
    public boolean verify(String message) {
        String verification;
        
        do {
        verification = io.readString(message + " (y/n): ");
        } while(!(verification.equalsIgnoreCase("y") || verification.equalsIgnoreCase("n")));
        
        return verification.equalsIgnoreCase("y");
    }
    
    public void newBigDCheck(String area) throws InputErrorException {
        try {
            new BigDecimal(area);
        } catch (NumberFormatException e) {
            throw new InputErrorException("Input a number");
        }
    }
    
    public void addOrderSuccessBanner() {
        io.print("===== Order was added successfully =====");
    }
    
    public void addOrderAbortedBanner() {
        io.print("===== Add Order Aborted =====");
    }
    
    public void removeOrderSuccessBanner() {
        io.print("===== Order was removed successfully =====");
    }
    
    public void removeOrderAbortedBanner() {
        io.print("===== Remove Order Aborted =====");
    }
    
    public void editedOrderSuccessBanner() {
        io.print("===== Order was edited successfully =====");
    }
    
    public void listingAllOrders(LocalDate date){
        io.print("Listing all orders placed on " + date + ":");
    }
    
    public void listingAllProducts() {
        io.print("Listing all available products: ");
    }
            
    
}
