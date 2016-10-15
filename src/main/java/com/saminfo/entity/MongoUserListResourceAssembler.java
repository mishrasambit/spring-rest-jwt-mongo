package com.saminfo.entity;

import com.saminfo.controller.ProfileController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * Created by sambit on 10/15/2016.
 */
public class MongoUserListResourceAssembler  extends ResourceAssemblerSupport<MongoUserList, MongoUserListResource> {
    public MongoUserListResourceAssembler(){
        super(ProfileController.class, MongoUserListResource.class);
    }

    @Override
    public MongoUserListResource toResource(MongoUserList mongoUserList) {
        MongoUserListResource studentListResource = new MongoUserListResource();
        studentListResource.setStudents(new MongoUserResourceAssembler().toResources(mongoUserList.getStudents()));
        return studentListResource;
    }
}
