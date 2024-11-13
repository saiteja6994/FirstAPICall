package com.example.myfirstspringproject.DemoInheritance.MappedSuperClass.JoinedTable.TablePerClass.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "msc_Mentor")
public class Mentor extends User{
    private double mentorRating;
}
