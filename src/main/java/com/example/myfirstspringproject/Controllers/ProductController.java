package com.example.myfirstspringproject.Controllers;

import com.example.myfirstspringproject.Services.ProductService;
import com.example.myfirstspringproject.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductByid(@PathVariable("id") Long id){
//         return new Product();
        return productService.getProductById(id);
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }
}
