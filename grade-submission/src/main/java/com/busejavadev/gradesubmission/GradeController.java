package com.busejavadev.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class GradeController {

    /*
    List<Grade> studentGrades = Arrays.asList(
        new Grade("John Doe", "Mathematics", "A"),
        new Grade("Jane Doe", "Mathematics", "B"),
        new Grade("John Doe", "Physics", "C")
    );
     */
    
    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model) {
        //model.addAttribute("grades", studentGrades); // now model contains data, we didnt
        model.addAttribute("grades", studentGrades); // now model contains data, we didnt
        return "grades";
    }

    //when a user makes a request on an empty path
    //we want to map this request a handler method gradeForm

    @GetMapping("/")
    public String gradeForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitGrade(Grade grade) {
        // -> debug System.out.println(grade); //Override toString()
        studentGrades.add(grade);
        return "redirect:/grades";
    }
    
}
