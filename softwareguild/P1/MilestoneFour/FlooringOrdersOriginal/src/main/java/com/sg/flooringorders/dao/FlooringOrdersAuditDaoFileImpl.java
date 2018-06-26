/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


public class FlooringOrdersAuditDaoFileImpl implements FlooringOrdersAuditDao {
    
    //public static final String AUDIT_FILE = "audit.txt";
    
    @Override
    public void writeAuditEntry(String entry, String auditType) throws FlooringOrdersPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter( new FileWriter(auditType + "audit.txt", true));
        } catch (IOException e) {
            throw new FlooringOrdersPersistenceException("Could not persist audit information", e);
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    } 
            
}
