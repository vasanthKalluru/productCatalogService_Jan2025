package org.example.productcatalogservice_jan2025.repos;

import org.example.productcatalogservice_jan2025.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    public List<Product> findProductByAmountBetween(Double low, Double high);

    public List<Product> findProductByIsPrimeSpecificTrue();

    @Query("SELECT p.description from Product p where p.id=?1")
    String findProductDescriptionFromProductId(Long id);


    @Query("SELECT c.name from Category c join Product p on p.category.id = c.id where p.id=:id")
    String findCategoryNameFromProductId(Long id);


}
