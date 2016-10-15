package com.saminfo.dao;

import com.saminfo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sambit on 10/12/2016.
 */

@Repository("fakeStudentDaoImpl")
public class FakeStudentDaoImpl implements StudentDao {
    private static Map<Integer, Student> students;
    static {
        List studentsList = Arrays.asList(
                new Student(1,"Sambit", "MCA"),
                new Student(2,"Swagat", "BA"),
                new Student(3,"Saroj", "MBA"));
        /*students = new HashMap<Integer,Student>(){
            {
                put(1, new Student(1,"Sambit", "MCA"));
                put(2, new Student(2,"Swagat", "BA"));
                put(3, new Student(3,"Saroj", "MBA"));
            }
        };*/
        students = (Map<Integer, Student>) studentsList.stream()
                .collect(
                       Collectors.toMap(
                            Student::getRoll,
                            student -> student
                    ));
                    /*Collectors.toMap(
                            Student::getRoll,
                            student -> student.add(linkTo(StudentController.class).slash(student.getRoll()).withSelfRel())
                    ));*/
    }

    @Override
    public List<Student> getAllStudents(){
        return FakeStudentDaoImpl.students.values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Student getStudentById(int id){
        return FakeStudentDaoImpl.students.get(id);
    }

    @Override
    public void deleteStudentById(int id) {
        FakeStudentDaoImpl.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student studentTemp = students.get(student.getRoll());
        studentTemp.setCourse(student.getCourse());
        studentTemp.setName(student.getName());
        students.put(studentTemp.getRoll(), studentTemp);
    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getRoll(), student);
    }
}
