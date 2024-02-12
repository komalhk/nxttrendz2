/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.nxttrendz2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.model.Product;

import com.example.nxttrendz2.repository.CategoryJpaRepository;
import com.example.nxttrendz2.repository.ProductJpaRepository;

import com.example.nxttrendz2.repository.ProductRepository;

@Service
public class ProductJpaService implements ProductRepository {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    public ArrayList<Product> getProducts() {
        List<Product> productList = productJpaRepository.findAll();
        ArrayList<Product> products = new ArrayList<>(productList);
        return products;
    }

    public Product getProductById(int id) {
        try {
            Product product = productJpaRepository.findById(id).get();
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Product addProduct(Product product) {
        Category category = product.getCategory();
        int id = category.getId();

        try {
            category = categoryJpaRepository.findById(id).get();
            product.setCategory(category);
            productJpaRepository.save(product);
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Product updateProduct(int id, Product product) {

        try {
            Product newProduct = productJpaRepository.findById(id).get();

            if(product.getCategory() != null) {
                int id = product.getCategory().getId();
                Category newCategory = categoryJpaRepository.findById(id).get();
                newProduct.setCategory(newCategory);
            }
            if(product.getName() != null) {
                newProduct.setName(product.getName());
            }
            if(product.getDescription() != null) {
                newProduct.setDescription(product.getDescription());
            }
            if(product.getPrice() != 0) {
                newProduct.setPrice(product.getPrice());
            }
        }
    }

    public void deleteProduct(int id) {
        try {
            productJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    public Product getProductCategory(int id) {
        try {
            Product product = productJpaRepository.findById(id).get();
            Category category = product.getCategory();
            return category;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}