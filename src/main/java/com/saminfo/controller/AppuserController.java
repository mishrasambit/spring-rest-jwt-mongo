package com.saminfo.controller;

import com.saminfo.security.model.AppUser;
import com.saminfo.security.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sambit on 10/15/2016.
 */
@RestController
@RequestMapping(value="/")
public class AppuserController {


    @Autowired
    @Qualifier("appUserService")
    private AppUserService appUserService;

    @RequestMapping(value="/appuser", method = RequestMethod.GET)
    public List<AppUser> getAllProfile(){
        List<AppUser> mongoUserList = new ArrayList<AppUser>();
        mongoUserList = appUserService.listAppuser();
        System.out.println(mongoUserList);
        return mongoUserList;
    }

    @RequestMapping(value="/appuser/{name}", method = RequestMethod.GET)
    public AppUser getProfileById(@PathVariable String name){
        AppUser appUser = new AppUser();
        appUser = appUserService.loadUserByUsername(name);
        return appUser;
    }
}
