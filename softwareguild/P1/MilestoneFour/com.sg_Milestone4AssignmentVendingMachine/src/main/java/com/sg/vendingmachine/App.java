/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jesse
 */
public class App {
    public static void main(String[] args) {
//        UserIO io = new UserIOConsoleImpl();
//        VendingMachineView view = new VendingMachineView(io);
//        VendingMachineDao dao = new VendingMachineDaoFileImpl();
//        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao);
//        VendingMachineController controller = new VendingMachineController(service, view);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        
        controller.run();
    }
}
