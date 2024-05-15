package com.busejavadev.gradesubmission.service;

import java.util.List;

import com.busejavadev.gradesubmission.pojo.Grade;
import com.busejavadev.gradesubmission.repository.GradeRepository;
import com.busejavadev.gradesubmission.Constants;

public class GradeService {

    GradeRepository gradeRepository = new GradeRepository(); 

    public Grade getGrade(int index) {
        return gradeRepository.getGrade(index);
    }

    public void addGrade(Grade grade) {
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(int index, Grade grade) {
        gradeRepository.updateGrade(index, grade);
    }

    public List<Grade> getGrades() {
        return gradeRepository.getGrades();
    }

    public int getGradeIndex(String id) {
        for (int i = 0; i < gradeRepository.getGrades().size(); i++) {
            if (gradeRepository.getGrades().get(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGradebyId(String id) {
        int index = getGradeIndex(id);
        return index != Constants.NOT_FOUND ? getGrade(index) : new Grade();
    }

    public void submitGrade(Grade grade) {
        int index = getGradeIndex(grade.getId());
        if (index != Constants.NOT_FOUND) {
            updateGrade(index, grade);
        } else {
            addGrade(grade);
        }
    }
}