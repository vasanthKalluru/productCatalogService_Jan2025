package org.example.productcatalogservice_jan2025.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_ta")
public class TA extends User{
    private double ratings;
}
