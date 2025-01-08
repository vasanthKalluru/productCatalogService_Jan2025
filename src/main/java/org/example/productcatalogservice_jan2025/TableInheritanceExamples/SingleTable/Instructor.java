package org.example.productcatalogservice_jan2025.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="st_instructor")
@DiscriminatorValue("1")
public class Instructor extends User {
    private String Company;
}
