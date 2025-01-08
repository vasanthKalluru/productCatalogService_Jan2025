package org.example.productcatalogservice_jan2025.TableInheritanceExamples.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name="msc_mentor")
public class Mentor extends User {
    private Long hours;
}
