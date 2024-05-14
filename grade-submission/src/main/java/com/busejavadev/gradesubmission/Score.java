package com.busejavadev.gradesubmission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScoreValidator.class)
public @interface Score {
    //boilerplate code that we need to include
    //according to Spring boot documentation
    //when you're creating a constraint annotation
    //you must always include them
    String message() default "Invalid Letter Grade";
    Class<?>[] groups() default {};
    Class <? extends Payload>[] payload() default {};
}
