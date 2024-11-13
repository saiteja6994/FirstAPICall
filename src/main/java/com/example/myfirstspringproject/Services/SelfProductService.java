package com.example.myfirstspringproject.Services;

import com.example.myfirstspringproject.Exceptions.ProductNotFoundException;
import com.example.myfirstspringproject.Repository.ProductRepository;
import com.example.myfirstspringproject.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product replaceProductById(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }
}
