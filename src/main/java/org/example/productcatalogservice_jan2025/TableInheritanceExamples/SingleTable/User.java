package org.example.productcatalogservice_jan2025.TableInheritanceExamples.SingleTable;

import jakarta.persistence.*;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name="st_user")
@DiscriminatorColumn(name="user_type",discriminatorType=DiscriminatorType.INTEGER)
public class User {
    @Id
    private Long id;
    private String Name;
    private String Email;
}
