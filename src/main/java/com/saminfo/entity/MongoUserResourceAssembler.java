package com.saminfo.entity;

import com.saminfo.controller.ProfileController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by sambit on 10/15/2016.
 */
public class MongoUserResourceAssembler extends ResourceAssemblerSupport<MongoUser, MongoUserResource> {
    public MongoUserResourceAssembler(){
        super(ProfileController.class, MongoUserResource.class);
    }

    @Override
    public MongoUserResource toResource(MongoUser mongoUser) {
        MongoUserResource mongoUserResource = new MongoUserResource();
        mongoUserResource.setUserId(mongoUser.userId);
        mongoUserResource.setFirstname(mongoUser.firstname);
        mongoUserResource.setLastname(mongoUser.lastname);
        mongoUserResource.setEmail(mongoUser.email);
        //mongoUserResource.setViews(mongoUser.);
        Link link = linkTo(methodOn(ProfileController.class).getProfileById(mongoUser.userId)).withSelfRel();
        mongoUserResource.add(link.withSelfRel());
        return mongoUserResource;
    }
}
