/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercisestudentquizscores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Jesse
 */
public class StudentQuizGrades {
    
    private HashMap<String, ArrayList> studentQuizGrades = new HashMap<>();
    private MainUserIO mainUserIO = new MainUserIO();
    
    public void addStudent(String student) {
        ArrayList<Integer> quizGrades = new ArrayList<>();
        String addGrades;
        
        mainUserIO.print("Enter student's grades: ", true);
        do {
            quizGrades.add(mainUserIO.readInt("", 0, 100));
            addGrades = mainUserIO.readString("Add another grade? (y/n): ");
        } while (addGrades.equalsIgnoreCase("y"));
        
        studentQuizGrades.put(student, quizGrades);
    }
    
    public void removeStudent(String student) {
        
        if(!studentQuizGrades.keySet().contains(student)) {
            mainUserIO.print("Student not found in databse", true);
            return;
        }
        
        studentQuizGrades.remove(student);
    }
    
    public int calcAverage(String student) {
        int average;
        int total = 0;
        int count = 0;
        
        if(!studentQuizGrades.keySet().contains(student)) {
            mainUserIO.print("Student not found in databse", true);
            return 0;
        }
        
        Collection<Integer> studentGrades = viewStudentGrades(student);
        for (int n : studentGrades) {
            total += n;
            count++;
        }
        average = total/count;
        return average;
    }
    
    public Set viewStudents(){
        
        if (studentQuizGrades.keySet().isEmpty()) {
            return null;
        }
        return studentQuizGrades.keySet();
    }
    
    public Collection viewStudentGrades(String student) {
        
        if(!studentQuizGrades.keySet().contains(student)) {
            mainUserIO.print("Student not found in databse", true);
            return null;
        }
        
        return studentQuizGrades.get(student);
    }
    
}
