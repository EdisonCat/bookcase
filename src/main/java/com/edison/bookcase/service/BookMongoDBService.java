package com.edison.bookcase.service;

import com.edison.bookcase.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BookMongoDBService extends MongoRepository<Book, UUID> {

}
