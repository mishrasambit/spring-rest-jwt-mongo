package com.saminfo.resource.assembly;

import com.saminfo.controller.StudentController;
import com.saminfo.entity.Student;
import com.saminfo.resource.StudentResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by sambit on 10/13/2016.
 */
public class StudentResourceAssembly extends ResourceAssemblerSupport<Student, StudentResource>{
     public StudentResourceAssembly(){
         super(StudentController.class, StudentResource.class);
     }

    @Override
    public StudentResource toResource(Student student) {
        StudentResource studentResource = new StudentResource();
        studentResource.setRoll(student.getRoll());
        studentResource.setName(student.getName());
        studentResource.setCourse(student.getCourse());
        Link link = linkTo(methodOn(StudentController.class).getStudentById(student.getRoll())).withSelfRel();
        studentResource.add(link.withSelfRel());
        return studentResource;
    }
}
