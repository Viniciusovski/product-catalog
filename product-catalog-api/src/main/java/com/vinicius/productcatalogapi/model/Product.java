package com.vinicius.productcatalogapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    private String id;
    private String title;
    private String description;
    private Double price;
    private String ownerId;

    @ManyToOne
    private Category category;
}