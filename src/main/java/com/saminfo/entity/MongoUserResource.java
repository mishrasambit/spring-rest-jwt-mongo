package com.saminfo.entity;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by sambit on 10/15/2016.
 */
public class MongoUserResource extends ResourceSupport {
    private String userId;
    private String firstname;
    private String lastname;
    private String email;
    private int views;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
