package com.ltp.gradesubmission;

import java.util.UUID;

public class Grade {
    private String id;
    private String name;
    private String subject;
    private String score;

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }
    // public Grade(String name, String subject, String score) {
    //     this.name = name;
    //     this.subject = subject;
    //     this.score = score;
    // }


    public String getId() {return this.id;}
    public String getName() {return this.name;}
    public String getSubject() {return this.subject;}
    public String getScore() {return this.score;}

    public void setId(String id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setSubject(String subject) {this.subject = subject;}
    public void setScore(String score) {this.score = score;}

}
