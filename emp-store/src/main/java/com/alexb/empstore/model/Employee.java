package com.alexb.empstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "emp")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String id;

    private String name;

    private String job;

    private String department;

    private Double salary;
}
