package com.saminfo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by sambit on 10/15/2016.
 */
@Repository(value = "mongoUserRepository")
public class MongoUserRepository{
    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "profiles";

    public MongoUser addProfile(MongoUser user) {
        if (!mongoTemplate.collectionExists(MongoUser.class)) {
            mongoTemplate.createCollection(MongoUser.class);
        }
        user.userId = UUID.randomUUID().toString();
        mongoTemplate.insert(user, COLLECTION_NAME);
        return user;
    }
    public List<MongoUser> listUser() {
        return mongoTemplate.findAll(MongoUser.class, COLLECTION_NAME);
    }
    public void deletePerson(MongoUser user) {
        mongoTemplate.remove(user, COLLECTION_NAME);
    }

    public void updatePerson(MongoUser user) {
        mongoTemplate.insert(user, COLLECTION_NAME);
    }

    public MongoUser getProfileById(String id) {
        BasicQuery queryForProfileMatchId = new BasicQuery("{ '_id' : '"+id+"'}");
        return mongoTemplate.findOne(queryForProfileMatchId, MongoUser.class);
    }
}
