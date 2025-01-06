package org.example.productcatalogservice_jan2025.services;

import org.example.productcatalogservice_jan2025.models.Product;
import org.example.productcatalogservice_jan2025.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        return product.orElse(null);
    }
    @Override
    public Product createProduct(Product product){
        return productRepo.save(product);
    }
    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
