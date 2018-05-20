/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author jesseazubuike
 */
public class StateCapitals1 {
    
    public static void main(String[] args) {
        
        String[] stateNames = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "FLorida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
        
        String[] stateCapitals = {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "St. Paul", "Jackson","Jefferson City", "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Sante Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"};
        
        HashMap<String, String> statesAndCapitals = new HashMap<>();
        
        for (int i = 0; i < stateNames.length; i++) {
            statesAndCapitals.put(stateNames[i], stateCapitals[i]);
        }
        
        Set<String> stKey = statesAndCapitals.keySet();
        
        Collection<String> stValues = statesAndCapitals.values();
        
        
        System.out.println("STATES:");
        System.out.println("=========");
        for (String s : stKey) {
            System.out.println(s);
    }

        System.out.println("\nCAPITALS:");
        System.out.println("=========");
        for (String s : stValues) {
            System.out.println(s);
        }
        
        System.out.println("\nStates and Capitals");
        System.out.println("=========");
        for (String s : stKey) {
            System.out.println(s + " - " + statesAndCapitals.get(s));
        }
  
    }
    
}
