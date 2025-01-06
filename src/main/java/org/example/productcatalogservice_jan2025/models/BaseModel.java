package org.example.productcatalogservice_jan2025.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.aot.generate.GeneratedMethod;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    private long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private State state;
}
