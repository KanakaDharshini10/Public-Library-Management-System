package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.service.BookCategoryService;

@RestController
@RequestMapping("/api/book-categories")
public class BookCategoryController {

    @Autowired
    private BookCategoryService service;

   
    @PostMapping
    public ResponseEntity<BookCategory> addBookCategory(@RequestBody(required = false) BookCategory category) {
        if (category == null || category.getCategoryName() == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(service.addCategory(category), HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<List<BookCategory>> getAllBookCategories() {
        List<BookCategory> list = service.getAllCategories();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookCategoryById(@PathVariable Long id) {
        BookCategory category = service.getCategoryById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book category not found");
        }
        return ResponseEntity.ok(category);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<BookCategory> updateBookCategory(
            @PathVariable Long id,
            @RequestBody BookCategory category) {

        BookCategory updated = service.updateCategory(id, category);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<BookCategory>> getCategoriesWithPagination(
            @PathVariable int page,
            @PathVariable int size) {

        Page<BookCategory> result = service.getCategoriesWithPagination(
                PageRequest.of(page, size, Sort.by("categoryId").ascending()));

        return ResponseEntity.ok(result);
    }
    
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteBookCategory(@PathVariable Long id) {

    boolean deleted = service.deleteCategory(id);

    if (!deleted) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Book category not found");
    }

    return ResponseEntity.ok("Book category deleted successfully");
}

}
