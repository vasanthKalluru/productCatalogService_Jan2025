package org.example.productcatalogservice_jan2025.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="st_mentor")
@DiscriminatorValue("2")
public class Mentor extends User {
    private Long hours;
}
