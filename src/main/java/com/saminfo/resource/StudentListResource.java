package com.saminfo.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sambit on 10/13/2016.
 */
public class StudentListResource extends ResourceSupport {
    private List<StudentResource> students = new ArrayList<StudentResource>();
    public List<StudentResource> getStudents() {
        return students;
    }
    public void setStudents(List<StudentResource> students) {
        this.students = students;
    }
}
