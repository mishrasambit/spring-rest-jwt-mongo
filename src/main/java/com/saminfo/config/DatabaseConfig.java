package com.saminfo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by sambit on 10/15/2016.
 */
@Configuration
@ComponentScan(basePackages={"com.saminfo"})
//@EnableMongoRepositories(basePackages = {"com.saminfo"})
public class DatabaseConfig extends AbstractMongoConfiguration {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Bean
    @Override
    public Mongo mongo() throws Exception {
        ServerAddress serverAddress = new ServerAddress("localhost", 27017);
        //MongoCredential credential = MongoCredential.createMongoCRCredential("vivek","sample","vivek".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(4).socketKeepAlive(true).build();
        //Mongo mongo = new MongoClient(serverAddress, Arrays.asList(),options);
        Mongo mongo = new MongoClient(serverAddress,options);
        //mongo.setWriteConcern(WriteConcern.SAFE);
        return mongo;

    }

    @Bean(name="mongoTemplate")
    @Override
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "test");
    }
}
