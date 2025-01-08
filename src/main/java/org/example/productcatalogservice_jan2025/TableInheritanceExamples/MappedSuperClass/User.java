package org.example.productcatalogservice_jan2025.TableInheritanceExamples.MappedSuperClass;

import jakarta.persistence.*;


@MappedSuperclass
public abstract class User {
    @Id
    private Long id;
    private String Name;
    private String Email;
}
