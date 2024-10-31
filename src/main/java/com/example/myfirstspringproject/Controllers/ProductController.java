package com.example.myfirstspringproject.Controllers;

import com.example.myfirstspringproject.Exceptions.ProductNotFoundException;
import com.example.myfirstspringproject.Services.ProductService;
import com.example.myfirstspringproject.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductByid(@PathVariable("id") Long id) throws ProductNotFoundException {
//         return new Product();
        Product product= productService.getProductById(id);
        ResponseEntity<Product> response;
//        if(product == null){
//            response=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            return  response;
//        }
        return new ResponseEntity<>(product, HttpStatus.OK);

    }
    @GetMapping()
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
    @PutMapping("/{id}")
    public Product replaceProductById(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.replaceProductById(id, product);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
        productService.deleteProductById(id);
    }
}
