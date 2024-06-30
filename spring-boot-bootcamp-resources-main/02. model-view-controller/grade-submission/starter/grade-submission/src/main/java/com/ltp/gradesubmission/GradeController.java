package com.ltp.gradesubmission;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// this code works insaaAllah

@Controller
public class GradeController {
    
    List<Grade> studentGrades = new ArrayList<>();


    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String name) {

        System.out.println("Name: " + name);

        // Grade grade;
        // Integer studentIndex = getGradeIndex(name); 
        // if (studentIndex != -1) {
        //     grade = studentGrades.get(studentIndex);
        //     System.out.println("Student found: " + grade.getName());
        // } else {
        //     grade = new Grade();
        //     System.out.println("Student not found, empty form returned for: " + name);
        // }
        // model.addAttribute("grade", grade);
        
        model.addAttribute("grade", getGradeIndex(name) != -1 ? studentGrades.get(getGradeIndex(name)) : new Grade());

        return "form";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grade", studentGrades);
        return "grades";
    }

    @PostMapping("/handleSubmit")
    public String submitGrade(Grade grade) {

        Integer studentIndex = getGradeIndex(grade.getName());
        if (studentIndex != -1) {
            studentGrades.set(studentIndex, grade);
            System.out.println("Student updated: " + grade.getName());
        } else {
            studentGrades.add(grade);
            System.out.println("Student added: " + grade.getName());
        }
        
        return "redirect:/grades";
    }
    
    public Integer getGradeIndex(String name) {
        System.out.print("Searching for: " + name);
        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getName().equals(name)) {
                return i;
            }
        }
        System.out.println(" - Grade not found");
        return -1;
    }

}
