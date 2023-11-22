package com.example.demo.employee.infraestructure.controllers;

import com.example.demo.employee.application.EmployeeRecorder;
import com.example.demo.employee.domain.EmployeeRepository;
import com.example.demo.shared.domain.eventBus.EventPublisher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean("employeeRecorderList")
    public EmployeeRecorder employeeRecorderList(@Qualifier("EmployeeListRepository") EmployeeRepository employeeRepository,
                                                 EventPublisher eventPublisher) {
        return new EmployeeRecorder(employeeRepository, eventPublisher);
    }

    @Bean("employeeRecorderLog")
    public EmployeeRecorder employeeRecorderLog(@Qualifier("EmployeeOtherTypeRepository") EmployeeRepository employeeRepository,
                                                EventPublisher eventPublisher) {
        return new EmployeeRecorder(employeeRepository, eventPublisher);
    }
}
