package com.example.myfirstspringproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModelClass{

    private String title;
    private String description;
    private double price;
    private String image;
    @ManyToOne
    private Category category;
}
/*

    product ------ category
    1          ->    1
    m            <-     1
    m:1

 */