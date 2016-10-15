package com.saminfo.controller;

import com.saminfo.entity.Student;
import com.saminfo.resource.StudentListResource;
import com.saminfo.resource.StudentResource;
import com.saminfo.resource.assembly.StudentListResourceAssembly;
import com.saminfo.resource.assembly.StudentResourceAssembly;
import com.saminfo.service.StudentService;
import com.saminfo.util.StudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by sambit on 10/12/2016.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<StudentListResource> getAllStudents(){
        StudentList studentList = new StudentList();
        studentList.setStudents(studentService.getAllStudents());
        StudentListResource studentListResource = new StudentListResourceAssembly().toResource(studentList);
        return new ResponseEntity<StudentListResource>(studentListResource, HttpStatus.OK);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<StudentResource> getStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        if(null != student) {
            StudentResource studentResource = new StudentResourceAssembly().toResource(student);
            return new ResponseEntity<StudentResource>(studentResource, HttpStatus.OK);
        }else{
            return new ResponseEntity<StudentResource>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable int id){
        studentService.deleteStudentById(id);
    }
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);

        //use of HATEOAS
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(linkTo(StudentController.class).slash(student.getRoll()).toUri());
        return new ResponseEntity<String>("Student created with id::"+student.getRoll(), httpHeaders, HttpStatus.CREATED);
    }
}
