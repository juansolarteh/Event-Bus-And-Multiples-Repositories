package com.example.demo.commons.eventBus.domain.events;

import com.example.demo.commons.eventBus.domain.Event;
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