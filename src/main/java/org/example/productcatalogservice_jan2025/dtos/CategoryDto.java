package org.example.productcatalogservice_jan2025.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_jan2025.models.Product;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
}
