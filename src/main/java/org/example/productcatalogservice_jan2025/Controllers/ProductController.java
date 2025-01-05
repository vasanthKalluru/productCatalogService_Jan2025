package org.example.productcatalogservice_jan2025.Controllers;

import org.example.productcatalogservice_jan2025.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping(path = "/products")
    public List<Product> getAllProducts() {
        return null;
    }

    @GetMapping(path = "/products/{id}")
    public Product getProductById(@PathVariable("id") Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setAmount(100.0);
        product.setDescription("Laddu MahaPrasadam");
        product.setTitle("Laddu");
        return product;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return null;
    }


}
