package com.example.myfirstspringproject.DemoInheritance.MappedSuperClass.JoinedTable.TablePerClass.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "JT_Mentor")
@PrimaryKeyJoinColumn(name = "User_ID")
public class Mentor extends User {
    private double mentorRating;
}
