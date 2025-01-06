package org.example.productcatalogservice_jan2025.services;

import org.example.productcatalogservice_jan2025.dtos.FakeStoreProductDto;
import org.example.productcatalogservice_jan2025.models.Category;
import org.example.productcatalogservice_jan2025.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;


@Service
public class ProductService implements IProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public List<Product> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoListResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();

        if(fakeStoreProductDtoListResponseEntity.getStatusCode().is2xxSuccessful() && fakeStoreProductDtoListResponseEntity.getBody() != null){
            FakeStoreProductDto[] fakeStoreProductDtoList = fakeStoreProductDtoListResponseEntity.getBody();
            for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList){
                products.add(from(fakeStoreProductDto));
            }
        }
        return products;
    }

    public Product getProductById(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",FakeStoreProductDto.class,id);

        if(fakeStoreProductDtoResponseEntity.getStatusCode().is2xxSuccessful() && fakeStoreProductDtoResponseEntity.getBody() != null){
            FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
            return from(fakeStoreProductDto);
        }

        return null;
    }

    public Product createProduct(Product product){
        return null;
    }

    public Product replaceProduct(Long id, Product product){
        FakeStoreProductDto fakeStoreProductDto = from(product);
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = putForEntity("https://fakestoreapi.com/products/"+id,fakeStoreProductDto,FakeStoreProductDto.class);

        if(fakeStoreProductDtoResponseEntity.getStatusCode().is2xxSuccessful() && fakeStoreProductDtoResponseEntity.getBody() != null){
            return from(fakeStoreProductDtoResponseEntity.getBody());
        }

        return null;
    }

    private Product from (FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setAmount(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    private FakeStoreProductDto from (Product product){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getAmount());
        fakeStoreProductDto.setImage(product.getImageUrl());
        if(product.getCategory() != null){
            fakeStoreProductDto.setCategory(product.getCategory().getName());
        }
        return fakeStoreProductDto;
    }


    public <T> ResponseEntity<T> putForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }

}
