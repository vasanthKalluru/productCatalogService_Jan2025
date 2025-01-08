package org.example.productcatalogservice_jan2025.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_instructor")
public class Instructor extends User{
    private String Company;
}
