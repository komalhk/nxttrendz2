/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.nxttrendz2.repository;

import java.util.ArrayList;
import com.example.nxttrendz2.model.*;

public interface ProductRepository {
    ArrayList<Product> getProducts();

    Product getProductById(int id);

    Product addProduct(Product product);

    Product updateProduct(int id, Product product);

    void deleteProduct(int id);

    Product getProductCategory(int id);
}