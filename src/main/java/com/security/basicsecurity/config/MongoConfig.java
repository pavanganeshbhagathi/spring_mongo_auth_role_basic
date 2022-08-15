package com.security.basicsecurity.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@AutoConfiguration
@AllArgsConstructor
public class MongoConfig {
    private MongoTemplate mongoTemplate;
    @Bean
    public MongoTemplate Mongoconfig()
    {
        return mongoTemplate;
    }
}
