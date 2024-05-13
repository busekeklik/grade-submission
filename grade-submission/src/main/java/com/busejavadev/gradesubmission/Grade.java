package com.busejavadev.gradesubmission;

//POJO class
public class Grade {
    private String name;
    private String subject;
    private String score;

    public Grade(String name, String subject, String score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public Grade() {
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
}
