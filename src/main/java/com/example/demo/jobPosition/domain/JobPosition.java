package com.example.demo.jobPosition.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JobPosition {
    private Integer id;
    private String name;
    private Integer vacantPositions;

    public JobPosition(Integer id, String name, Integer vacantPositions) {
        this.id = id;
        this.name = name;
        this.vacantPositions = vacantPositions;
    }

    public void addVacantPosition() {
        vacantPositions++;
    }
}
