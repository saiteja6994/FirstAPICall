package com.example.myfirstspringproject.Services;

import com.example.myfirstspringproject.Exceptions.ProductNotFoundException;
import com.example.myfirstspringproject.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product replaceProductById(Long id, Product product);
    void deleteProductById(Long id);
}
