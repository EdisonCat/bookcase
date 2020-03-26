package com.edison.bookcase.dao;

import com.edison.bookcase.service.BookMongoDBService;
import com.mongodb.MongoClient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories(basePackageClasses = BookMongoDBService.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookMongoDBService bookRepository) {
        return strings -> {
//            bookRepository.save(new Book(1, "LZSWDNMD", new Date(), "CSB"));
//            bookRepository.save(new Book(2, "LZSWDNMD", new Date(), "CSV"));
            bookRepository.deleteAll();
        };
    }

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(mongoClient(), "bookcase");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }


}
