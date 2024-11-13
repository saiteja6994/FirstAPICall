package com.example.myfirstspringproject.DemoInheritance.MappedSuperClass.JoinedTable.TablePerClass.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "1")

public class Instructor extends User {
    private String specialization;
}
