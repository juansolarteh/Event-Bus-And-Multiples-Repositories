package com.example.demo.employee.infraestructure.controllers;

import com.example.demo.employee.application.EmployeeRecorder;
import com.example.demo.employee.domain.EmployeeRepository;
import com.example.demo.eventBus.domain.EventBus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean("employeeRecorderList")
    public EmployeeRecorder employeeRecorderList(@Qualifier("EmployeeListRepository") EmployeeRepository employeeRepository,
                                                 EventBus eventBus) {
        return new EmployeeRecorder(employeeRepository, eventBus);
    }

    @Bean("employeeRecorderLog")
    public EmployeeRecorder employeeRecorderLog(@Qualifier("EmployeeOtherTypeRepository") EmployeeRepository employeeRepository,
                                                EventBus eventBus) {
        return new EmployeeRecorder(employeeRepository, eventBus);
    }
}
