package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Book;
import com.examly.springapp.model.BookCategory;
import com.examly.springapp.repository.BookCategoryRepo;
import com.examly.springapp.repository.BookRepo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private BookCategoryRepo bookCategoryRepo;

    // CREATE BOOK
    @Override
    public Book addBook(Book book) {
        if (book.getBookCategory() != null &&
            book.getBookCategory().getCategoryId() != null) {

            Long categoryId = book.getBookCategory().getCategoryId();
            BookCategory category = bookCategoryRepo.findById(categoryId).orElse(null);
            book.setBookCategory(category);
        }
        return bookRepo.save(book);
    }

    // GET ALL BOOKS
    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    // GET BOOK BY ID
    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    // UPDATE BOOK
    @Override
    public Book updateBook(Long id, Book book) {
        Book existing = bookRepo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setAvailable(book.isAvailable());

        if (book.getBookCategory() != null &&
            book.getBookCategory().getCategoryId() != null) {

            Long categoryId = book.getBookCategory().getCategoryId();
            BookCategory category = bookCategoryRepo.findById(categoryId).orElse(null);
            existing.setBookCategory(category);
        }

        return bookRepo.save(existing);
    }

    // SEARCH BY TITLE
    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepo.findByTitle(title);
    }

    // SEARCH BY CATEGORY NAME
    @Override
    public List<Book> getBooksByCategoryName(String categoryName) {
        return bookRepo.findByBookCategory_CategoryName(categoryName);
    }
    @Override
public Page<Book> getBooksWithPagination(int page, int size, String sort) {
    Pageable pageable;

    if (sort != null && !sort.isEmpty()) {
        // Example: "title,asc" or "author,desc"
        String[] sortParams = sort.split(",");
        String sortField = sortParams[0];
        Sort.Direction direction = (sortParams.length > 1 && sortParams[1].equalsIgnoreCase("desc"))
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        pageable = PageRequest.of(page, size, Sort.by(direction, sortField));
    } else {
        pageable = PageRequest.of(page, size);
    }

    return bookRepo.findAll(pageable);
}
}
