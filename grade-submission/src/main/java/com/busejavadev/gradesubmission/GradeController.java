package com.busejavadev.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class GradeController {
    
    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model) {
        //model.addAttribute("grades", studentGrades); // now model contains data, we didnt
        model.addAttribute("grades", studentGrades); // now model contains data, we didnt
        return "grades";
    }

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
        int index = getGradeIndex(id);
        model.addAttribute("grade", index != Constants.NOT_FOUND ? studentGrades.get(index) : new Grade());
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) return "form"; // stay in the form if there are errors
        int index = getGradeIndex(grade.getId());
        if (index != Constants.NOT_FOUND) {
            studentGrades.set(index, grade);
        } else{
            studentGrades.add(grade);
        }
        return "redirect:/grades";
    }

    public Integer getGradeIndex(String id) {
        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }   
}
