package com.busejavadev.gradesubmission;

import java.util.Arrays;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidator;
import java.util.List;


public class ScoreValidator implements ConstraintValidator<Score, String>{
    List<String>scores = Arrays.asList(
        "A+", "A", "A-",
        "B+", "B", "B-",
        "C+", "C", "C-",
        "D+", "D", "D-",
        "F"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for(String string: scores){
            if(string.equals(value)) return true;
        }
        return false;
    }
}
