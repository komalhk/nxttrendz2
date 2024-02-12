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

import com.example.nxttrendz2.model.Product;
import com.example.nxttrendz2.model.Category;

import com.example.nxttrendz2.service.ProductJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

public class ProductController {
    @Autowired
    private ProductJpaService productService;

    @GetMapping("/categories/products")
    public ArrayList<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/categories/products/{productId}")
    public Product getProductById(@PathVariable("productId") int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/categories/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/categories/products/{productId}")
    public Product updateProduct(@PathVariable("productId") int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/categories/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/{productId}/category")
    public Category getProductCategory(@PathVariable("productId") int id) {
        return productService.getProductCategory(id);
    }
}