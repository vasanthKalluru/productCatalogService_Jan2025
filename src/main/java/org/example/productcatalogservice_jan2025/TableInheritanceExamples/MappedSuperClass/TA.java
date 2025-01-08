package org.example.productcatalogservice_jan2025.TableInheritanceExamples.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name="msc_ta")
public class TA extends User {
    private double ratings;
}
