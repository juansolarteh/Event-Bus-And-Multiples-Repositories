package com.example.demo.employee.infraestructure;

import com.example.demo.employee.domain.Employee;
import com.example.demo.employee.domain.EmployeeRepository;
import org.springframework.stereotype.Repository;

@Repository("EmployeeOtherTypeRepository")
public class EmployeeOtherTypeRepository implements EmployeeRepository {
    @Override
    public void save(Employee employee) {
        String employeeString = "Employee: " + employee.getIdNumber() + " - " + employee.getName();
        System.out.println(employeeString);
    }
}
