/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz2.controller;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.service.CategoryJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class CategoryController {
    @Autowired
    private CategoryJpaService categoryService;

    @GetMapping("/categories")
    public ArrayList<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@PathVariable("categoryId") int id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") int id) {
        categoryService.deleteCategory(id);
    }
}