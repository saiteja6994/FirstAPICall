package com.example.myfirstspringproject.DemoInheritance.MappedSuperClass.JoinedTable.TablePerClass.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@DiscriminatorValue(value = "3")

public class TA extends User {
    private int SessionsTaken;
    private double avgRating;
}
