package com.example.demo.employee.infraestructure;

import com.example.demo.employee.domain.Employee;
import com.example.demo.employee.domain.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("EmployeeListRepository")
public class EmployeeListRepository implements EmployeeRepository {
    List<Employee> employeeList;
    public EmployeeListRepository(){
        employeeList = new ArrayList<>();
    }
    @Override
    public void save(Employee newEmployee) {
        employeeList.add(newEmployee);
    }
}
