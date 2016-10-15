package com.saminfo.controller;

import com.saminfo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


/**
 * Created by sambit on 10/15/2016.
 */
@RestController
@RequestMapping(value="/")
public class ProfileController {


    @Autowired
    @Qualifier("mongoUserRepository")
    private MongoUserRepository mongoUserRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> home(){
        return ResponseEntity.ok("success");
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertStudent(@RequestBody MongoUser user){
        MongoUser addedMongoUser = mongoUserRepository.addProfile(user);
        //use of HATEOAS
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(linkTo(ProfileController.class).slash(addedMongoUser.userId).toUri());
        return new ResponseEntity<String>("Student created with id::"+addedMongoUser.userId, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ResponseEntity<MongoUserListResource> getAllProfile(){
        MongoUserList mongoUserList = new MongoUserList();
        mongoUserList.setStudents(mongoUserRepository.listUser());
        MongoUserListResource mongoUserListResource = new MongoUserListResourceAssembler().toResource(mongoUserList);
        return new ResponseEntity<MongoUserListResource>(mongoUserListResource, HttpStatus.OK);
    }

    @RequestMapping(value="/profile/{id}", method = RequestMethod.GET)
    public ResponseEntity<MongoUserResource> getProfileById(@PathVariable String id){
        MongoUser mongoUser = new MongoUser();
        mongoUser = mongoUserRepository.getProfileById(id);
        MongoUserResource mongoUserResource = new MongoUserResourceAssembler().toResource(mongoUser);
        return new ResponseEntity<MongoUserResource>(mongoUserResource, HttpStatus.OK);
    }
}
