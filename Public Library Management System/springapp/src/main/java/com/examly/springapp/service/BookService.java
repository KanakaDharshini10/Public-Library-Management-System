package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.examly.springapp.model.Book;

public interface BookService {

    // CREATE
    Book addBook(Book book);

    // READ ALL
    List<Book> getAllBooks();

    // READ BY ID
    Book getBookById(Long id);

    // UPDATE
    Book updateBook(Long id, Book book);

    // SEARCH BY TITLE (USED IN Day12 tests)
    List<Book> getBooksByTitle(String title);

    // SEARCH BY CATEGORY NAME
    List<Book> getBooksByCategoryName(String categoryName);

    Page<Book> getBooksWithPagination(int page, int size, String sort);
}
