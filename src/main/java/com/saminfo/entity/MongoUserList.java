package com.saminfo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sambit on 10/15/2016.
 */
public class MongoUserList {
    private List<MongoUser> users = new ArrayList<MongoUser>();

    public List<MongoUser> getStudents() {
        return users;
    }

    public void setStudents(List<MongoUser> users) {
        this.users = users;
    }
}
