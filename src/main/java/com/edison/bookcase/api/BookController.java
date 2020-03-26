package com.edison.bookcase.api;

import com.edison.bookcase.model.Book;
import com.edison.bookcase.service.BookMongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/bookcase/mongodb")
@CacheConfig(cacheNames = "bookCache")
public class BookController {

    private final BookMongoDBService bookService;

    @Autowired
    public BookController(BookMongoDBService bookService) {
        this.bookService = bookService;
    }

//    @Cacheable(key = "#bookId")
    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.insert(book);
    }

//    @Cacheable(value = "book")
    @GetMapping(path = "all")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @Cacheable(key = "#bookId", value = "book")
    @GetMapping(path = "{bookId}")
    public Book getBookById(@PathVariable("bookId") UUID bookId) {
        if(bookService.findById(bookId).isPresent()) return bookService.findById(bookId).get();
        return null;
    }

    @CacheEvict(allEntries = true)
    @DeleteMapping
    public void deleteAllBooks() {
        bookService.deleteAll();
    }

    @CacheEvict(key = "#bookId")
    @DeleteMapping(path = "{bookId}")
    public void deleteBookById(@PathVariable("bookId") UUID bookId) {
        bookService.deleteById(bookId);
    }
}
