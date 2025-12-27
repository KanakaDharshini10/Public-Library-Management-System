package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.repository.BookCategoryRepo;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    private BookCategoryRepo repo;

    @Override
    public BookCategory addCategory(BookCategory category) {
        return repo.save(category);
    }

    @Override
    public List<BookCategory> getAllCategories() {
        return repo.findAll();
    }

    @Override
    public BookCategory getCategoryById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public BookCategory updateCategory(Long id, BookCategory category) {
        BookCategory existing = repo.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setCategoryName(category.getCategoryName());
        return repo.save(existing);
    }

    @Override
    public Page<BookCategory> getCategoriesWithPagination(Pageable pageable) {
        return repo.findAll(pageable);
    }
    @Override
public boolean deleteCategory(Long id) {
    if (!repo.existsById(id)) {
        return false;
    }
    repo.deleteById(id);
    return true;
}

}
