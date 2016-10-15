package com.saminfo.entity;

/**
 * Created by sambit on 10/12/2016.
 */
public class Student {
    private int roll;
    private String name;
    private String course;

    public Student(){}
    public Student(int roll, String name, String course){
        this.roll = roll;
        this.name = name;
        this.course = course;
        //this.add(linkTo(StudentController.class).slash(this.roll).withSelfRel());
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
