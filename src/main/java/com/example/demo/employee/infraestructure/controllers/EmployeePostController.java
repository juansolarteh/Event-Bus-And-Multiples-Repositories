package com.example.demo.employee.infraestructure.controllers;

import com.example.demo.employee.application.EmployeeRecorder;
import com.example.demo.employee.domain.EmployeeRepository;
import com.example.demo.employee.infraestructure.EmployeeOtherTypeRepository;
import com.example.demo.employee.infraestructure.dto.EmployeeDTO;
import com.example.demo.eventBus.domain.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("employeeList")
public class EmployeePostController {

    @Qualifier("employeeRecorderList")
    @Autowired
    private EmployeeRecorder employeeRecorder;

    @PostMapping
    public ResponseEntity post(@RequestBody EmployeeDTO employee) {
        employeeRecorder.record(employee.idNumber(), employee.name(), employee.jopPositionId());
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
