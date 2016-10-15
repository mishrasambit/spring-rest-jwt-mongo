package com.saminfo.security.service;

import com.saminfo.security.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

/**
 * Created by sambit on 10/15/2016.
 */

@Repository(value = "appUserService")
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "appuser";

    @Override
    public AppUser loadUserByUsername(String username) {
        BasicQuery queryForProfileMatchId = new BasicQuery("{ 'username' : '"+username+"'}");
        AppUser appUser = mongoTemplate.findOne(queryForProfileMatchId, AppUser.class);
        System.out.println("AppUserServiceImpl.loadUserByUsername appuser "+appUser);
        return appUser;
    }

    @Override
    public Long post(AppUser appUser) {
        if (!mongoTemplate.collectionExists(AppUser.class)) {
            mongoTemplate.createCollection(AppUser.class);
        }
        long range = 1234567L;
        Random r = new Random();
        long number = (long)(r.nextDouble()*range);
        appUser.setId(number);
        mongoTemplate.insert(appUser, COLLECTION_NAME);
        return appUser.getId();
    }

    @Override
    public AppUser get(String id) {
        BasicQuery queryForProfileMatchId = new BasicQuery("{ '_id' : '"+id+"'}");
        return mongoTemplate.findOne(queryForProfileMatchId, AppUser.class);
    }

    @Override
    public AppUser patch(AppUser appUser) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    public List<AppUser> listAppuser() {
        return mongoTemplate.findAll(AppUser.class, COLLECTION_NAME);
    }
}
