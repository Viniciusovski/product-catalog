package com.vinicius.productcatalogapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Category {

    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;
}