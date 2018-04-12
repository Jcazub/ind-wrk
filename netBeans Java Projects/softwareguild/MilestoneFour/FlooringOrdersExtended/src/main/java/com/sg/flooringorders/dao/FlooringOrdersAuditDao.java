/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.dao;

/**
 *
 * @author Jesse
 */
public interface FlooringOrdersAuditDao {
    
    public void writeAuditEntry(String entry, String auditType) throws FlooringOrdersPersistenceException;
    
}
