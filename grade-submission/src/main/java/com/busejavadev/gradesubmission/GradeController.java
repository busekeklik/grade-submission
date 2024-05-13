package com.busejavadev.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {
    
    @GetMapping("/grades")
    public String getGrades(Model model) {
        Grade grade = new Grade("John Doe", "Math", "C-");
        model.addAttribute("grade", grade); // now model contains data, we didnt
        return "grades";
    }
}
