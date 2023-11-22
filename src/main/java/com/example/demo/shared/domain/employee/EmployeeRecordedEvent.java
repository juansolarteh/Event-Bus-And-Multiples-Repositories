package com.example.demo.shared.domain.employee;

import com.example.demo.shared.domain.eventBus.Event;
import lombok.Getter;

@Getter
public class EmployeeRecordedEvent implements Event {
    String idNumber;
    String name;
    Integer idJobPosition;

    public EmployeeRecordedEvent(String idNumber, String name, Integer idJobPosition) {
        this.idNumber = idNumber;
        this.name = name;
        this.idJobPosition = idJobPosition;
    }
}
