package com.saminfo.dao;

import com.saminfo.entity.Student;

import java.util.List;

/**
 * Created by sambit on 10/12/2016.
 */
public interface StudentDao {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    void deleteStudentById(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
