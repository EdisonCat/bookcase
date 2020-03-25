package com.edison.bookcase.dao;

import com.edison.bookcase.model.Book;
import com.edison.bookcase.service.BookMongoDBService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;

@EnableMongoRepositories(basePackageClasses = BookMongoDBService.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookMongoDBService bookRepository) {
        return strings -> {
            bookRepository.save(new Book(1, "LZSWDNMD", new Date(), "CSB"));
            bookRepository.save(new Book(2, "LZSWDNMD", new Date(), "CSV"));
        };
    }


}
