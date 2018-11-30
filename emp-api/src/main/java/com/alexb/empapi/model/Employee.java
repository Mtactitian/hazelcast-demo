package com.alexb.empapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String id;

    private String name;

    private String job;

    private String department;

    private Double salary;
}
