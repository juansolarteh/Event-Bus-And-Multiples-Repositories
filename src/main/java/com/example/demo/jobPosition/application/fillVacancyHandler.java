package com.example.demo.jobPosition.application;

import com.example.demo.commons.domain.NotFoundException;
import com.example.demo.commons.eventBus.domain.EventSubscriberRegister;
import com.example.demo.commons.eventBus.domain.events.EmployeeRecordedEvent;
import com.example.demo.commons.eventBus.domain.EventSubscriber;
import com.example.demo.commons.eventBus.domain.exceptions.MissingTypeArgumentException;
import com.example.demo.jobPosition.domain.JobPosition;
import com.example.demo.jobPosition.domain.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class fillVacancyHandler extends EventSubscriber<EmployeeRecordedEvent> {
    @Autowired
    JobPositionRepository jobPositionRepository;
    fillVacancyHandler(EventSubscriberRegister eventSubscriberRegister) throws MissingTypeArgumentException {
        super(eventSubscriberRegister);
    }
    @Override
    public void onEvent(EmployeeRecordedEvent event) {
        Optional<JobPosition> jobPosition = jobPositionRepository.getJobPosition(event.getIdJobPosition());
        if (jobPosition.isEmpty()) throw new NotFoundException("Job position doesn't exist");
        jobPosition.get().addVacantPosition();
        jobPositionRepository.updateJobPosition(jobPosition.get());
    }
}
