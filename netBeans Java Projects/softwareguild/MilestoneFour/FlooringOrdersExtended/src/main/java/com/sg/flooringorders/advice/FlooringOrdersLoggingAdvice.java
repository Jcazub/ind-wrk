/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.advice;

import com.sg.flooringorders.dao.FlooringOrdersAuditDao;
import com.sg.flooringorders.dao.FlooringOrdersPersistenceException;
import com.sg.flooringorders.dto.Order;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Jesse
 */
public class FlooringOrdersLoggingAdvice {
    
    FlooringOrdersAuditDao auditDao;
    
    public FlooringOrdersLoggingAdvice(FlooringOrdersAuditDao auditDao) {
        this.auditDao = auditDao;
        
    }
    
    public void createErrorAuditEntry(JoinPoint jp, Throwable ex) {
        Object[] args = jp.getArgs();
        String ErrorFullName = ex.toString();
        String auditEntry = ErrorFullName + ": " + jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg + " ";
        }
  
        try {
            auditDao.writeAuditEntry(auditEntry, "ERROR");
        } catch (FlooringOrdersPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
    public void createOrderAuditEntry(JoinPoint jp, Object retVal) {
        //Object[] args = jp.getArgs();
        
        String auditEntry = jp.getSignature().getName() + ": " + retVal;
        
//        for (Object currentArg : args) {
//            auditEntry += currentArg;
//        }
//  
        try {
            auditDao.writeAuditEntry(auditEntry, "ORDER");
        } catch (FlooringOrdersPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
}
