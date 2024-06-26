package com.busejavadev.gradesubmission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;


import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.busejavadev.gradesubmission.pojo.Grade;
import com.busejavadev.gradesubmission.service.GradeService;



@Controller
public class GradeController {

    //now, gradecontroller and gradeservice are not tightly coupled
    //instead of creating the object directly inside the class(new ...) = tightly coupled
    //we are injecting the object directly from the Spring container
    //this is called dependency injection
    @Autowired
    GradeService gradeService;

    @GetMapping("/grades")
    public String getGrades(Model model) {
        //model.addAttribute("grades", studentGrades); // now model contains data, we didnt
        model.addAttribute("grades", gradeService.getGrades()); // now model contains data, we didnt
        return "grades";
    }

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("grade", gradeService.getGradebyId(id));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) return "form"; // stay in the form if there are errors
        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }
}
