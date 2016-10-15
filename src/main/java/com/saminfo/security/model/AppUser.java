package com.saminfo.security.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by sambit on 10/15/2016.
 */
@Document(collection = "appuser")
public class AppUser {

    private Long id;
    private String username;
    private String password;
    private String authorities;
    public AppUser() {
    }

    public AppUser(String username, String password, String authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString(){
        return this.getId()+"::"+this.getAuthorities()+"::"+this.getUsername()+"::"+this.getUsername();
    }
}
