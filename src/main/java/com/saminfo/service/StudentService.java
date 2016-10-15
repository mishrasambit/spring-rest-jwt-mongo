package com.saminfo.service;

import com.saminfo.dao.StudentDao;
import com.saminfo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sambit on 10/12/2016.
 */
@Service
public class StudentService {

    @Autowired
    @Qualifier("fakeStudentDaoImpl")
    private StudentDao studentDao;

    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }
    public Student getStudentById(int id){
        return studentDao.getStudentById(id);
    }

    public void deleteStudentById(int id) {
        studentDao.deleteStudentById(id);
    }

    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }
}
