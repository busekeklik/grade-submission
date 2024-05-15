package com.busejavadev.gradesubmission.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.busejavadev.gradesubmission.pojo.Grade;

@Repository // now Spring boot will register a GradeRepository class as a bean
public class GradeRepository {

    private List<Grade> studentGrades = new ArrayList<>(); //tightly coupled

    public Grade getGrade(int index) {
        return studentGrades.get(index);
    }

    public void addGrade(Grade grade) {
        studentGrades.add(grade);
    }

    public void updateGrade(int index, Grade grade) {
        studentGrades.set(index, grade);
    }

    public List<Grade> getGrades() {
        return studentGrades;
    }
}
