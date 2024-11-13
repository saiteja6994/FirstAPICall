package com.example.myfirstspringproject.DemoInheritance.MappedSuperClass.JoinedTable.TablePerClass.SingleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="User_Type",
        discriminatorType = DiscriminatorType.INTEGER
)
@Entity(name = "st_user")
@DiscriminatorValue(value = "0")
public class User {
    @Id
    private Long id;
    private String Name;
    private String email;
    private String password;
}
