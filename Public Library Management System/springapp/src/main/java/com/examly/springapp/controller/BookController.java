package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Book;
import com.examly.springapp.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

   
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = service.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        Book book = service.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book not found with id: " + id);
        }
        return ResponseEntity.ok(book);
    }

   

   
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id,
                                        @RequestBody Book book) {
        Book updatedBook = service.updateBook(id, book);
        if (updatedBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book not found with id: " + id);
        }
        return ResponseEntity.ok(updatedBook);
    }

   
    @GetMapping("/title/{title}")
    public ResponseEntity<?> getBooksByTitle(@PathVariable String title) {
        List<Book> books = service.getBooksByTitle(title);
        if (books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No book found with title: " + title);
        }
        return ResponseEntity.ok(books);
    }

    
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<?> getBooksByCategoryName(@PathVariable String categoryName) {
        List<Book> books = service.getBooksByCategoryName(categoryName);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }

    
    @GetMapping("/page")
    public ResponseEntity<?> getBooksWithPagination(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) String sort) {

        return ResponseEntity.ok(service.getBooksWithPagination(page, size, sort));
    }
}
