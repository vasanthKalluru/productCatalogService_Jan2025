package org.example.productcatalogservice_jan2025.Controllers;

import org.example.productcatalogservice_jan2025.dtos.CategoryDto;
import org.example.productcatalogservice_jan2025.dtos.ProductDto;
import org.example.productcatalogservice_jan2025.models.Category;
import org.example.productcatalogservice_jan2025.models.Product;
import org.example.productcatalogservice_jan2025.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping(path = "/products")
    public List<ProductDto> getAllProducts() {
        return null;
    }

    @GetMapping(path = "/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
        try {
            if(productId<=0)
                throw new RuntimeException("Product not found");

            Product product = productService.getProductById(productId);
            if (product == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(from(product), HttpStatus.OK);
        } catch(RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return null;
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setAmount(product.getAmount());
        productDto.setDescription(product.getDescription());
        productDto.setTitle(product.getTitle());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            Category category = product.getCategory();
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(category.getId());
            categoryDto.setName(category.getName());
            categoryDto.setDescription(category.getDescription());
            productDto.setCategory(categoryDto);
        }

        return productDto;
    }


}
