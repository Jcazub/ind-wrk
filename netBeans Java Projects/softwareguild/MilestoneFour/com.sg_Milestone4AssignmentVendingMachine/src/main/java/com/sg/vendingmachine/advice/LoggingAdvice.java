/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.advice;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Jesse
 */
public class LoggingAdvice {
    VendingMachineAuditDao auditDao;
 
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }
 
    public void createAuditEntry(JoinPoint jp, Throwable ex) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ex.toString() + ": ";
        //String exEntry = ex.toString();
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
  
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}
