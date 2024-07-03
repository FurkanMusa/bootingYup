package com.ltp.gradesubmission.service;

import java.util.List;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;

public class GradeService {
    
    private GradeRepository gradeRepo = new GradeRepository();

    public int getGradeIndex(String id) {
        for (int i = 0; i < getGrades().size(); i++) {
            if (getGrades().get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGradeById(String id) {
        int index = getGradeIndex(id);
        return index == Constants.NOT_FOUND ? new Grade() : getGrade(index);
        
    }

    public void submitGrade(Grade grade) {
        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            addGrade(grade);
        } else {
            updateGrade(index, grade);
        }
    }



    // Basic CRUD operations
    public List<Grade> getGrades() {
        return gradeRepo.getGrades();
    }

    public Grade getGrade(int index) {
        return gradeRepo.getGrade(index);
    }

    public void addGrade(Grade grade) {
        gradeRepo.addGrade(grade);
    }

    public void updateGrade(int index, Grade grade) {
        gradeRepo.updateGrade(index, grade);
    } 
    
}
