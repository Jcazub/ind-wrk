/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.testing;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Jesse
 */
public class testingDateAndTime {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.parse("2017-09-22");
        LocalDate now = LocalDate.now();
        
        Period p = ld.until(now);

        System.out.println(p.getDays());
    }
}
