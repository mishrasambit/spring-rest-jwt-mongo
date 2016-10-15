package com.saminfo.security.service;

import com.saminfo.security.model.AppUser;

import java.util.List;

/**
 * Created by sambit on 10/15/2016.
 */
public interface AppUserService {
    AppUser loadUserByUsername(String username);

    Long post(AppUser appUser);

    AppUser get(String id);

    AppUser patch(AppUser appUser);

    boolean delete(String id);

    List<AppUser> listAppuser();
}
