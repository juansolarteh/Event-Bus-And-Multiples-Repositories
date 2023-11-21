package com.example.demo.employee.application;

import com.example.demo.commons.eventBus.domain.EventPublisher;
import com.example.demo.employee.domain.Employee;
import com.example.demo.employee.domain.EmployeeRepository;
import com.example.demo.commons.eventBus.domain.events.EmployeeRecordedEvent;
import jakarta.transaction.Transactional;

public class EmployeeRecorder {
    EmployeeRepository employeeRepository;
    EventPublisher eventPublisher;
    public EmployeeRecorder(EmployeeRepository employeeRepository, EventPublisher eventPublisher){
        this.employeeRepository = employeeRepository;
        this.eventPublisher = eventPublisher;
    }
    @Transactional
    public void record(String idNumber, String name, Integer jobPositionId) {
        employeeRepository.save(new Employee(idNumber, name));
        eventPublisher.publishEvent(new EmployeeRecordedEvent(idNumber, name, jobPositionId));
    }
}
