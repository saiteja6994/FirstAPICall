package com.example.myfirstspringproject.DemoInheritance.MappedSuperClass.JoinedTable.TablePerClass.TablePerClass;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TA extends User {
    private int SessionsTaken;
    private double avgRating;
}
