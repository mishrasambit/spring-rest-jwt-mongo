package com.saminfo.entity;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sambit on 10/15/2016.
 */
public class MongoUserListResource extends ResourceSupport {
    private List<MongoUserResource> mongoUserResourceList = new ArrayList<MongoUserResource>();
    public List<MongoUserResource> getStudents() {
        return mongoUserResourceList;
    }
    public void setStudents(List<MongoUserResource> mongoUserResourceList) {
        this.mongoUserResourceList = mongoUserResourceList;
    }
}
