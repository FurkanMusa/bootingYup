package com.ltp.gradesubmission;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// this code works insaaAllah

@Controller
public class GradeController {
    
    List<Grade> studentGrades = new ArrayList<>();


    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {

        System.out.println("Id: " + id);
        
        Integer studentIndex = getGradeIndex(id);
        model.addAttribute("grade", studentIndex != Constants.NOT_FOUND ? studentGrades.get(studentIndex) : new Grade());

        return "form";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grade", studentGrades);
        return "grades";
    }

    @PostMapping("/handleSubmit")
    public String submitGrade(Grade grade, RedirectAttributes redirectAttributes) {

        Integer studentIndex = getGradeIndex(grade.getId());
        if (studentIndex != Constants.NOT_FOUND) {
            studentGrades.set(studentIndex, grade);
            System.out.println("Student updated: " + grade.getId());
        } else {
            studentGrades.add(grade);
            System.out.println("Student added: " + grade.getId());
            redirectAttributes.addFlashAttribute("status", Constants.STATUS_SUCCESS);
        }

        return "redirect:/grades";
    }
    
    public Integer getGradeIndex(String id) {
        System.out.print("Searching for: " + id);
        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getId().equals(id)) {
                return i;
            }
        }
        System.out.println(" - Id  not found");
        return Constants.NOT_FOUND;
    }

}
