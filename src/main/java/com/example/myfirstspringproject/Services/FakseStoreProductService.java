package com.example.myfirstspringproject.Services;

import com.example.myfirstspringproject.DTO.FakeStoreDTO;
import com.example.myfirstspringproject.Exceptions.ProductNotFoundException;
import com.example.myfirstspringproject.models.Category;
import com.example.myfirstspringproject.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public Product getProductById(Long id) throws ProductNotFoundException {
//        int x=1/0;
        FakeStoreDTO fakeStoreDTO=restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreDTO.class);
        //convert dto into product object

//        assert fakeStoreDTO != null;
        if(fakeStoreDTO==null) {
            throw new ProductNotFoundException(id,"Entered "+id+" is out of bound");
        }
        return convertFakeStoreDtoToProduct(fakeStoreDTO);
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreDTO[] fakeStoreDTOSList=restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreDTO[].class);
        //convert List of faksestoredto to list of products
        List<Product> response=new ArrayList<>();
        for(FakeStoreDTO fakeStoreDTO:fakeStoreDTOSList){
            response.add(convertFakeStoreDtoToProduct(fakeStoreDTO));
        }

        return response;
    }

    @Override
    public Product replaceProductById(Long id, Product product) {
        FakeStoreDTO fakeStoreDTO=new FakeStoreDTO();
        fakeStoreDTO.setTitle(product.getTitle());
        fakeStoreDTO.setDescription(product.getDescription());
        fakeStoreDTO.setDescription(product.getDescription());
        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreDTO,FakeStoreDTO.class);
        HttpMessageConverterExtractor<FakeStoreDTO> responseExtractor = new HttpMessageConverterExtractor<>(FakeStoreDTO.class, restTemplate.getMessageConverters());
        FakeStoreDTO response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreDtoToProduct(response);
    }

    @Override
    public void deleteProductById(Long id) {
        restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.DELETE, (RequestCallback)null, (ResponseExtractor)null);
    }


}
