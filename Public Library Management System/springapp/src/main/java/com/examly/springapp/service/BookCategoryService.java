package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.examly.springapp.model.BookCategory;

public interface BookCategoryService {

    BookCategory addCategory(BookCategory category);

    List<BookCategory> getAllCategories();

    BookCategory getCategoryById(Long id);
    boolean deleteCategory(Long id);

    BookCategory updateCategory(Long id, BookCategory category);

    Page<BookCategory> getCategoriesWithPagination(Pageable pageable);
}
