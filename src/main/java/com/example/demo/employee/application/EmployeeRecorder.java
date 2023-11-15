package com.example.demo.employee.application;

import com.example.demo.employee.domain.Employee;
import com.example.demo.employee.domain.EmployeeRepository;
import com.example.demo.eventBus.application.EmployeeRecordedEvent;
import com.example.demo.eventBus.domain.EventBus;
import jakarta.transaction.Transactional;

public class EmployeeRecorder {
    EmployeeRepository employeeRepository;
    EventBus eventBus;
    public EmployeeRecorder(EmployeeRepository employeeRepository, EventBus eventBus){
        this.employeeRepository = employeeRepository;
        this.eventBus = eventBus;
    }
    @Transactional
    public void record(String idNumber, String name, Integer jobPositionId) {
        employeeRepository.save(new Employee(idNumber, name));
        eventBus.publishEvent(new EmployeeRecordedEvent(idNumber, name, jobPositionId));
    }
}
