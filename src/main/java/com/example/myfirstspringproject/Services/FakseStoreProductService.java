package com.example.myfirstspringproject.Services;

import com.example.myfirstspringproject.DTO.FakeStoreDTO;
import com.example.myfirstspringproject.models.Category;
import com.example.myfirstspringproject.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakseStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    FakseStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreDtoToProduct(FakeStoreDTO fakeStoreDTO) {
        Product product = new Product();
        product.setId(fakeStoreDTO.getId());
        product.setDescription(fakeStoreDTO.getDescription());
        product.setPrice(fakeStoreDTO.getPrice());
        product.setTitle(fakeStoreDTO.getTitle());
        product.setImage(fakeStoreDTO.getImage());

        Category category = new Category();
        category.setDescription(fakeStoreDTO.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreDTO fakeStoreDTO=restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreDTO.class);
        //convert dto into product object

//        assert fakeStoreDTO != null;
        if(fakeStoreDTO==null) return null;
        return convertFakeStoreDtoToProduct(fakeStoreDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
