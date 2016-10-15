package com.saminfo.dao;

import com.saminfo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sambit on 10/12/2016.
 */
@Repository("mongoStudentDaoImpl")
public class MongoStudentDaoImpl implements StudentDao  {

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudent(Student student) {

    }
}
