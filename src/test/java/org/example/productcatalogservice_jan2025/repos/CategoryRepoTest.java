package org.example.productcatalogservice_jan2025.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice_jan2025.models.Category;
import org.example.productcatalogservice_jan2025.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryRepoTest {
    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    public void testLazyFetchType() {
        Category category = categoryRepo.findById(2L).get();
        System.out.println(category.getName());
        //only after asking the products you will see that a new query is fired on products.
        //in the logs you can easily see that first the category name is printed and then only new query is fired.
        for(Product product : category.getProducts()) {
            System.out.println(product.getDescription());
        }
        return;
    }
    @Test
    @Transactional
    public void testEagerFetchType() {
        Category category = categoryRepo.findById(2L).get();
        //Change the fetch type to eager to see it working.
        //Even before asking the products you will see that a new query is fired on products.
        //in the logs you can easily see that first the query is run and then only category name is printed.
        System.out.println(category.getName());
        for(Product product : category.getProducts()) {
            System.out.println(product.getDescription());
        }
        return;
    }

}