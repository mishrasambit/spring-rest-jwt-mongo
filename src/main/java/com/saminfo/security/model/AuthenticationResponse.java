package com.saminfo.security.model;

/**
 * Created by sambit on 10/15/2016.
 */
public class AuthenticationResponse {
    private String token;

    public AuthenticationResponse() {
        super();
    }

    public AuthenticationResponse(String token) {
        this.setToken(token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
