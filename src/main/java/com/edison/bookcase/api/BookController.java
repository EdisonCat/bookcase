package com.edison.bookcase.api;

import com.edison.bookcase.model.Book;
import com.edison.bookcase.service.BookMongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookcase/mongodb")
public class BookController {

    private final BookMongoDBService bookService;

    @Autowired
    public BookController(BookMongoDBService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.insert(book);
    }

    @GetMapping(path = "all")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping(path = "{bookId}")
    public Book getBookById(@PathVariable("bookId") Integer bookId) {
        if(bookService.findById(bookId).isPresent()) return bookService.findById(bookId).get();
        return null;
    }

    @DeleteMapping
    public void deleteAllBooks() {
        bookService.deleteAll();
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBookById(@PathVariable("bookId") Integer bookId) {
        bookService.deleteById(bookId);
    }
}
