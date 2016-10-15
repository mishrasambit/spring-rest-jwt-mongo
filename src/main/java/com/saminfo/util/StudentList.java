package com.saminfo.util;

import com.saminfo.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sambit on 10/13/2016.
 */
public class StudentList {
    private List<Student> students = new ArrayList<Student>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
