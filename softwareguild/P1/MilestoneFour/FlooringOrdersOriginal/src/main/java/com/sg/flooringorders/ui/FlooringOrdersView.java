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
import java.time.format.DateTimeParseException;
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
    
    public int getUserNumberSelection(String prompt) {
        boolean hasError = false;
        int n = 0;
        
        do {
            try {
                n = io.readInt(prompt);
                hasError = false;
            } catch (InputErrorException e) {
                displayError(e.getMessage());
                hasError = true;
            }
        } while (hasError);

        return n;
    }
    
    public LocalDate getDateFromUser() throws InputErrorException {
        LocalDate ld = null;
        
        try {
            ld = LocalDate.parse(io.readString("Enter Date (YYYY-MM-DD)"));
        } catch (DateTimeParseException e) {
            throw new InputErrorException("Please enter a valid date");
        }
        
        
        return ld;
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
        
        //this.newBigDCheck(area);
        
        
        String[] newOrderDetails = {name, materialName, state, area};
        //this.validateData(newOrderDetails);
        return newOrderDetails;
    }
    
    public String[] editOrderRequest(Order orderToEdit) {
        //String name = "", materialName = "", state = "", area = "";
        boolean hasError = false;
        boolean verification = false;
        String[] newEditedDetails = {"","","",""};
        
        do {
            try {
                int choice = io.readInt("Which field would you like to edit?\n"
                    + "1. Customer Name\n"
                    + "2. Material\n"
                    + "3. State\n"
                    + "4. Area",
                    1, 4);
                hasError = false;
                switch(choice) {
                case 1:
                    newEditedDetails[0] = io.readString("Enter Customer Name (Current: " + orderToEdit.getCustomerName() + "):");
                    break;
                case 2:
                    newEditedDetails[1] = io.readString("Enter Material: (Current: " + orderToEdit.getProduct().getProductType() + "):");  
                    break;
                case 3:
                    newEditedDetails[2] = io.readString("Enter State: (Current: " + orderToEdit.getStateTax().getStateName() + "):");
                    break;
                case 4:
                    newEditedDetails[3] = io.readString("Enter Area: (Current: " + orderToEdit.getArea() + "):");
                    break;
            }
               //this.validateData(newEditedDetails);
            } catch (InputErrorException e) {
                displayError(e.getMessage());
                hasError = true;
            }

            
            if (!hasError) {
                verification = this.verify("Edit more fields?");
            }

        } while (verification || hasError);
        
        
        return newEditedDetails;
    }
    
    //Currently not in use
    public String[] getOrderDetails() throws InputErrorException {
        String date = io.readString("Enter Date (YYYY-MM-DD)");
        String orderNumber = io.readString("Enter order number");
        
        if (date.trim().length() == 0
                || orderNumber.trim().length() == 0) {
            throw new InputErrorException("Please don't leave input fields empty.");
        }
        
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
    
//    public void newBigDCheck(String area) throws InputErrorException {
//        try {
//            new BigDecimal(area);
//        } catch (NumberFormatException e) {
//            throw new InputErrorException("Input a number");
//        }
//    }
    
//    public void validateData(String[] strArray) throws InputErrorException {
//        for (String s : strArray) {
//                this.validateData(s);   
//        }
//    }
//    
//    public void validateData(String str) throws InputErrorException {
//        
//        if (str == null) {
//            String[] stringSplit = str.split("");
//        
//            for (String s : stringSplit) {
//                if (s.equals(":")) {
//                    throw new InputErrorException("Cannot use special character :");
//                }
//            }
//        }
//        
//    }
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
    
    public void editedOrderAbortedBanner() {
        io.print("===== Edit Order Aborted =====");
    }
    
    public void listingAllOrders(LocalDate date){
        io.print("Listing all orders placed on " + date + ":");
    }
    
    public void listingAllProducts() {
        io.print("Listing all available products: ");
    }
            
    
}
