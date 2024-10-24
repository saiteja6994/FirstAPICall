package com.example.myfirstspringproject.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
}
