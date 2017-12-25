/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercisestudentquizscores;

import java.util.Collection;
import java.util.Set;

/**
 *
 * @author Jesse
 */
public class App {
    public static void main(String[] args) {
        MainUserIO mainUserIO = new MainUserIO();
        StudentQuizGrades studentQuizGrades = new StudentQuizGrades();
        String response = "";
        Set<String> allStudents;
        Collection<Integer> studentGrades;
        ;
        mainUserIO.print("Welcome to the Teacher Portal!", true);
        
        do {
            mainUserIO.print("\nWhat would you like to do? You can add a student, remove a student, view all students, view a student's grades, view a student's average or exit this program?: ", true);
            response = mainUserIO.readString("add, remove view all, view grades, view average, or exit?: ");
            switch (response) {
                case "add": 
                    studentQuizGrades.addStudent(mainUserIO.readString("Student's name?: "));
                    break;
                case "remove":
                    studentQuizGrades.removeStudent(mainUserIO.readString("Student's name?: "));
                    break;
                case "view all":
                    allStudents = studentQuizGrades.viewStudents();
                    for (String s : allStudents) {
                        mainUserIO.print(s + " ");
                    }
                    break;
                case "view grades":
                    studentGrades = studentQuizGrades.viewStudentGrades(mainUserIO.readString("Student's name?: "));
                    for (int s : studentGrades) {
                        mainUserIO.print(s + " ");
                    }
                    break;
                case "average":
                    mainUserIO.print((studentQuizGrades.calcAverage(mainUserIO.readString("Student's name?: "))) + "");
                    break;
                default:
                    break;
            }
            
            
        } while (!(response.equalsIgnoreCase("exit")));
        
        mainUserIO.print("Thank you for using the Teacher Portal!", true);
        
    }
}
