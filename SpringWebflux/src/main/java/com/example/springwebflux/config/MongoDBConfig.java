package com.example.springwebflux.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

@Configuration
public class MongoDBConfig extends AbstractReactiveMongoConfiguration {


    @Override
    protected String getDatabaseName() {
        return "mydb";
    }

    @Override
    public MongoClient reactiveMongoClient(){
        return MongoClients.create();
    }
}
