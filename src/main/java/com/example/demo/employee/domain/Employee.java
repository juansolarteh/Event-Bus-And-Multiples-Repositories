package com.example.demo.employee.domain;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Employee {
    private String idNumber;
    private String name;
    public Employee(String idNumber, String name) {
        this.idNumber = idNumber;
        this.name = name;
    }
}
