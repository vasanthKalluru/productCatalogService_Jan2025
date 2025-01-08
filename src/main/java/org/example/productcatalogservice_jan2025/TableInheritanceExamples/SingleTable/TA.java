package org.example.productcatalogservice_jan2025.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="st_ta")
@DiscriminatorValue("3")
public class TA extends User {
    private double ratings;
}
