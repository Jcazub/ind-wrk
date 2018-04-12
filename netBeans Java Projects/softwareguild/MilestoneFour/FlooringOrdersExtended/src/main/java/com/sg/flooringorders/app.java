/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders;

import com.sg.flooringorders.controller.FlooringOrdersController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jesse
 */
public class app {
    
    public static void main(String[] args) {
        
        final String SETTINGS = "settings.txt";
        String chosenController = "";
        
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(SETTINGS)));
            if (sc.hasNextLine()) {
                String scCurrentLine = sc.nextLine();
                String[] scTokens = scCurrentLine.split(":");
                chosenController = scTokens[1];
            }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        
        
      
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        //create new file reader
       
        
        FlooringOrdersController controller = ctx.getBean(chosenController, FlooringOrdersController.class);
        
        controller.run();
    }
}
