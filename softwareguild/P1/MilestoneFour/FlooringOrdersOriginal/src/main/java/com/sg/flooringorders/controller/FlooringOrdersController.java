/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.controller;

import com.sg.flooringorders.dao.FlooringOrdersPersistenceException;
import com.sg.flooringorders.ui.InputErrorException;
import com.sg.flooringorders.dto.Order;
import com.sg.flooringorders.dto.Product;
import com.sg.flooringorders.dto.StateTax;
import com.sg.flooringorders.service.FlooringOrdersServiceLayer;
import com.sg.flooringorders.service.FlooringOrdersValidationException;
import com.sg.flooringorders.service.InvalidStateCodeException;
import com.sg.flooringorders.service.NoOrdersOnGivenDateException;
import com.sg.flooringorders.service.OrderAlreadyExistsException;
import com.sg.flooringorders.service.OrderDoesNotExistException;
import com.sg.flooringorders.service.ProductNotListedException;
import com.sg.flooringorders.ui.FlooringOrdersView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Jesse
 */
public class FlooringOrdersController {
    
    private FlooringOrdersView view;
    private FlooringOrdersServiceLayer service;

    public FlooringOrdersController(FlooringOrdersView view, FlooringOrdersServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        
        boolean keepGoing = true;
        
        try {
            loadEverything();
        
            while (keepGoing) {
                displayMenu();
                int selection = userSelection();
                switch (selection) {
                    case 1:
                        displayOrders();
                        break;
                    case 2:
                        displayProducts();
                        break;
                    case 3:
                        addOrder();
                        break;
                    case 4:
                        editOrder();
                        break;
                    case 5:
                        removeOrder();
                        break;
                    case 6:
                        saveCurrentSession();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        displayUnknownCommand();
                }
            }
            
            saveCurrentSession();
        } catch (FlooringOrdersPersistenceException e) {
            view.displayError(e.getMessage());
        }
        displayExitMessage();  
    }
    
    private void displayMenu() {
        view.displayMenu();
    }
    
    private int userSelection() {
        return view.getUserNumberSelection("Selection?");
    }
    
    private void displayOrders() {
        
        try {
            LocalDate ld = view.getDateFromUser();
            List<Order> orders = service.getOrdersByDate(ld);
            view.listingAllOrders(ld);
            view.displayOrders(orders);
        } catch (NoOrdersOnGivenDateException | InputErrorException e) {
            view.displayError(e.getMessage());
        }

    }
    
    private void displayProducts() {
        List<Product> productList = service.getProductList();
        view.listingAllProducts();
        view.displayProducts(productList);
    }
    
    private void addOrder() {
        boolean hasFixableErrors = false;
        
        do {
            
            try {
                String[] addOrderDetails = view.getNewOrder();
                Product material = service.findProduct(addOrderDetails[1]);
                StateTax stateTax = service.findStateTax(addOrderDetails[2]);
                Order newOrder = new Order(addOrderDetails[0], material, stateTax, new BigDecimal(addOrderDetails[3]));
                newOrder.setDate(LocalDate.now());
                view.displayOrder(newOrder);
                boolean verification = view.verify("Are you sure you want to add this order?");
                if (verification) {
                    service.addOrder(newOrder);
                    view.addOrderSuccessBanner();
                } else {
                    view.addOrderAbortedBanner();
                }
                hasFixableErrors = false;  
            } catch (ProductNotListedException | InvalidStateCodeException | FlooringOrdersValidationException | InputErrorException | NumberFormatException e) {
                view.displayError(e.getMessage());
                hasFixableErrors = true;
            } catch (OrderAlreadyExistsException e) {
                view.displayError(e.getMessage());
                hasFixableErrors = false;
            }
        } while (hasFixableErrors);

    }
    
    private Order getEditedOrder() {
        boolean hasMaterialError;
        boolean hasStateTaxError;
        boolean hasLocationError = false;
        boolean hasBigDecimalError;
        Order orderToEdit = null;
        boolean verification = false;

        do {
            try {
                LocalDate date = view.getDateFromUser();
                List<Order> orders = service.getOrdersByDate(date);
                view.displayOrders(orders);
                int orderNumber = view.getUserNumberSelection("Enter Order Number: ");
                Order orderReference = service.findOrder(date, orderNumber);
                orderToEdit = new Order(orderReference);
                hasLocationError = false;
            } catch (OrderDoesNotExistException | InputErrorException | NoOrdersOnGivenDateException e) {
                view.displayError(e.getMessage());
                hasLocationError = true;
            }
            
            if (hasLocationError) {
                verification = view.verify("Input Order Details Again?");
            }
            
        } while (hasLocationError && verification);
         
        if (!hasLocationError && orderToEdit != null) {
            do {
                hasMaterialError = false;
                hasStateTaxError = false;
                hasBigDecimalError = false;
                view.displayOrder(orderToEdit);
                String[] editOrderDetails = view.editOrderRequest(orderToEdit);

                for (int i = 0; i < editOrderDetails.length; i++) {
                    switch(i) {
                        case 0:
                            if (editOrderDetails[i].trim().length() != 0) {
                                orderToEdit.setCustomerName(editOrderDetails[i]);
                            }
                            break;
                        case 1:
                            if (editOrderDetails[i].trim().length() != 0) {
                                try {
                                    Product material = service.findProduct(editOrderDetails[i]);
                                    orderToEdit.setProduct(material);
                                    hasMaterialError = false;
                                } catch (ProductNotListedException e) {
                                    view.displayError(e.getMessage());
                                    hasMaterialError = true;
                                }
                            }
                            break;
                        case 2:
                            if (editOrderDetails[i].trim().length() != 0) {
                                try {
                                    StateTax stateTax = service.findStateTax(editOrderDetails[i]);
                                    orderToEdit.setStateTax(stateTax);
                                    hasStateTaxError = false;
                                } catch (InvalidStateCodeException e) {
                                    view.displayError(e.getMessage());
                                    hasStateTaxError = true;
                                }
                            }
                            break;
                        case 3:
                            if (editOrderDetails[i].trim().length() != 0) {
                                try {
                                    //view.newBigDCheck(editOrderDetails[i]);
                                    orderToEdit.setArea(new BigDecimal(editOrderDetails[i]));
                                    hasBigDecimalError = false;
                                } catch (NumberFormatException e) {
                                    view.displayError(e.getMessage());
                                    hasBigDecimalError = true;
                                }
                                
                            }
                            break;
                        default:
                    }
                }
            } while (hasMaterialError || hasStateTaxError || hasBigDecimalError);
      
        }
         return orderToEdit;
        
    }
    
        
    private void removeOrder() {
        boolean inputError = false;
         
        do {
                try {
                LocalDate date = view.getDateFromUser();
                List<Order> orders = service.getOrdersByDate(date);
                view.displayOrders(orders);
                int orderNumber = view.getUserNumberSelection("Enter Order Number: ");
                inputError = false;
                Order orderToRemove = service.findOrder(date, orderNumber);
                view.displayOrder(orderToRemove);
                boolean verification = view.verify("Are you sure you want to delete this order?");
                if (verification) {
                    service.removeOrder(date, orderNumber);
                    view.removeOrderSuccessBanner();
                } else {
                    view.removeOrderAbortedBanner();
                }     
            } catch (OrderDoesNotExistException | NoOrdersOnGivenDateException e) {
                view.displayError(e.getMessage());
            } catch (InputErrorException e) {
                view.displayError(e.getMessage());
                inputError = true;
            }
        } while (inputError);
        

    }
    
    private void editOrder() {
        boolean hasValidationError = false;
        Order orderToEdit = null;
        
        do {
            orderToEdit = getEditedOrder();
            
            try {
                if (orderToEdit != null) {
                    view.displayOrder(orderToEdit);
                    boolean verification = view.verify("Are you sure you want to edit this order?");
                    if (verification) {
                        service.editOrder(orderToEdit);
                        hasValidationError = false;
                        view.editedOrderSuccessBanner(); 
                    } else {
                        view.editedOrderAbortedBanner();
                    }     
                }
            } catch (OrderDoesNotExistException e) {
                view.displayError(e.getMessage());
                hasValidationError = false;
            } catch (FlooringOrdersValidationException e) {
                view.displayError(e.getMessage());
                hasValidationError = true;
            }
            
            
        } while (hasValidationError);
        
        
    }
    
    private void saveCurrentSession() throws FlooringOrdersPersistenceException {
        
        service.exportOrders();

    }
    
    private void loadEverything() throws FlooringOrdersPersistenceException {
        
        service.importOrders();
        
    }
    
    private void displayExitMessage() {
        view.displayExitMessage();
    }
    
    private void displayUnknownCommand() {
        view.displayUnknownCommand();
    }
    
}
