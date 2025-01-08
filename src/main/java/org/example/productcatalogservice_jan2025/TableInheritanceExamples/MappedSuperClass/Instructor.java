package org.example.productcatalogservice_jan2025.TableInheritanceExamples.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name="msc_instructor")
public class Instructor extends User {
    private String Company;
}
