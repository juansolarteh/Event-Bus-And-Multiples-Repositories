package com.example.demo.jobPosition.application;

import com.example.demo.shared.application.NotFoundException;
import com.example.demo.shared.domain.eventBus.EventSubscriberRegister;
import com.example.demo.shared.domain.employee.EmployeeRecordedEvent;
import com.example.demo.shared.domain.eventBus.EventSubscriber;
import com.example.demo.shared.domain.eventBus.exceptions.MissingTypeArgumentException;
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
