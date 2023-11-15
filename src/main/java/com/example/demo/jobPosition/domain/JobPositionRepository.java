package com.example.demo.jobPosition.domain;

import java.util.Optional;

public interface JobPositionRepository {
    void updateJobPosition(JobPosition jobPosition);
    Optional<JobPosition> getJobPosition(int jobPositionId);
}
