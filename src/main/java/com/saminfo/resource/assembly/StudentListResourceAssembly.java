package com.saminfo.resource.assembly;

import com.saminfo.controller.StudentController;
import com.saminfo.resource.StudentListResource;
import com.saminfo.util.StudentList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * Created by sambit on 10/13/2016.
 */
public class StudentListResourceAssembly extends ResourceAssemblerSupport<StudentList, StudentListResource> {
    public StudentListResourceAssembly(){
        super(StudentController.class, StudentListResource.class);
    }

    @Override
    public StudentListResource toResource(StudentList studentList) {
        StudentListResource studentListResource = new StudentListResource();
        studentListResource.setStudents(new StudentResourceAssembly().toResources(studentList.getStudents()));
        return studentListResource;
    }
}
