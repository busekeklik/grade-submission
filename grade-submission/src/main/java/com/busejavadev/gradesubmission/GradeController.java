package com.busejavadev.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



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
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
        //Grade grade;
        model.addAttribute("grade", getGradeIndex(id) != -1000 ? studentGrades.get(getGradeIndex(id)) : new Grade());
        return "form";
        /*if(getGradeIndex(name) != -1000) {
            grade = studentGrades.get(getGradeIndex(name));
        } else {
            grade = new Grade();
        }
        model.addAttribute("grade", grade); */
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {
        int index = getGradeIndex(grade.getId());
        // -> debug System.out.println(grade); //Override toString()
        if (index != -1000) {
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
        return -1000; //"index not found, loose integer"
    }
    
}
