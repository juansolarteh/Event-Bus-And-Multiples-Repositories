package com.example.demo.jobPosition.application;

import com.example.demo.commons.domain.NotFoundException;
import com.example.demo.eventBus.domain.events.EmployeeRecordedEvent;
import com.example.demo.eventBus.domain.EventBus;
import com.example.demo.eventBus.domain.EventListener;
import com.example.demo.eventBus.domain.exceptions.MissingTypeArgumentException;
import com.example.demo.jobPosition.domain.JobPosition;
import com.example.demo.jobPosition.domain.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class fillVacancyHandler extends EventListener<EmployeeRecordedEvent> {
    @Autowired
    JobPositionRepository jobPositionRepository;
    fillVacancyHandler(EventBus eventBus) throws MissingTypeArgumentException {
        super(eventBus);
    }
    @Override
    public void onEvent(EmployeeRecordedEvent event) {
        Optional<JobPosition> jobPosition = jobPositionRepository.getJobPosition(event.getIdJobPosition());
        if (jobPosition.isEmpty()) throw new NotFoundException("Job position doesn't exist");
        jobPosition.get().addVacantPosition();
        jobPositionRepository.updateJobPosition(jobPosition.get());
    }
}
