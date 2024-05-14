package com.busejavadev.gradesubmission;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

//POJO class
public class Grade {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Subject cannot be blank")
    private String subject;
    @Score
    private String score;
    private String id;

    public Grade(String name, String subject, String score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /* 
    @Override
    public String toString() {
        return "{"
                + "name='" + getName() + "'" + ", "
                + "subject='" + getSubject() + "'" + ", "
                + "score='" + getScore() + "'" +
        "}";
    } */
}
