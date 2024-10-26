package com.example.myfirstspringproject.Services;

import com.example.myfirstspringproject.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product replaceProductById(Long id, Product product);
}
