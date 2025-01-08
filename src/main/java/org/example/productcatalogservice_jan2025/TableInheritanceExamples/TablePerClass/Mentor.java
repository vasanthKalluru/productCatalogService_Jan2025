package org.example.productcatalogservice_jan2025.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_mentor")
public class Mentor extends User{
    private Long hours;
}
