package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    // Find books by title
    List<Book> findByTitle(String title);

    // Find books by category name (USED BY TESTS)
    List<Book> findByBookCategory_CategoryName(String categoryName);
}
