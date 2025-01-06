package org.example.productcatalogservice_jan2025.services;

import org.example.productcatalogservice_jan2025.models.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product createProduct(Product product);
    public Product replaceProduct(Long id, Product product);
}
