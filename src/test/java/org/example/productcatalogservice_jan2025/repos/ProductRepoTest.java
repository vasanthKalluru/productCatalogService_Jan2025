package org.example.productcatalogservice_jan2025.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice_jan2025.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductRepoTest {
    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    public void testgetAllProductsByAmount() {
        List<Product> productList = productRepo.findProductByAmountBetween(100.0,200.0);
        for (Product product : productList) {
            System.out.println(product.getTitle()+"    "+product.getAmount());
        }
    }

    @Test
    @Transactional
    public void getProductDescriptionById(){
        System.out.println(productRepo.findProductDescriptionFromProductId((long)1));
    }


    @Test
    public void getCateogryNameFromProductId() {
        System.out.println(productRepo.findCategoryNameFromProductId((long)2));
    }

}