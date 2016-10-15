package com.saminfo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


/**
 * Created by sambit on 10/15/2016.
 */
@Document(collection = "profiles")
public class MongoUser {
    @Id
    public String userId;
    public String firstname;
    public String lastname;
    public String email;
    public String password;
    private int views;
}
