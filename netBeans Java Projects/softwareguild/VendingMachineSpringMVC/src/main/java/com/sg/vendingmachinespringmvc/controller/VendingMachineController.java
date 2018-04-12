/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.model.VendingMachineDao;
import com.sg.vendingmachinespringmvc.service.VendingMachineServiceLayer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jesse
 */
@Controller
public class VendingMachineController {
    
    private VendingMachineServiceLayer service;
    
    @Inject
    public VendingMachineController(VendingMachineDao dao, VendingMachineServiceLayer service) {
        this.service = service;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String refresh(Model model) {
        model.addAttribute("currentAmount", service.getCurrentAmount());
        model.addAttribute("currentItemSelected", service.getCurrentItemSelected());
        model.addAttribute("change", service.getChange());
        model.addAttribute("items", service.getAllItems());
        model.addAttribute("displayMessage", service.getDisplayMessage());
        return "index";
    }
    
    @RequestMapping(value="/inputCash/{amount}", method=RequestMethod.GET)
    public String inputCash(@PathVariable String amount) {
        BigDecimal addedCashin100 = new BigDecimal(amount);
        BigDecimal addedCash = addedCashin100.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        service.calcTotal(addedCash);
        
        return "redirect:/";
    }
    
    @RequestMapping(value="/makePurchase", method=RequestMethod.GET)
    public String makePurchase() {
        service.makePurchase();
        return "redirect:/";
    }
    
    @RequestMapping(value="/changeReturn", method=RequestMethod.GET)
    public String changeReturn() {
        service.changeReturn();
        return "redirect:/";
    }
    
    @RequestMapping(value="/makeSelection/{itemNumber}", method=RequestMethod.GET)
    public String makeSelection(@PathVariable String itemNumber) {
        int itemNumberConverted = Integer.parseInt(itemNumber);
        service.setCurrentItemSelected(itemNumberConverted);
        return "redirect:/";
    }
    
}
