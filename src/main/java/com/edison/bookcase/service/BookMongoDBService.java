package com.edison.bookcase.service;

import com.edison.bookcase.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookMongoDBService extends MongoRepository<Book, Integer> {

}
