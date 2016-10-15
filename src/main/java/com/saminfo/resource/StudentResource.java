package com.saminfo.resource;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by sambit on 10/13/2016.
 */
public class StudentResource extends ResourceSupport {
    private int roll;
    private String name;
    private String course;

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
