package com.example.demo.jobPosition.infraestructure;

import com.example.demo.jobPosition.domain.JobPosition;
import com.example.demo.jobPosition.domain.JobPositionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JobPositionListRepository implements JobPositionRepository {
    List<JobPosition> jobPositionList;
    public JobPositionListRepository() {
        jobPositionList = new ArrayList<>();
        jobPositionList.add(new JobPosition(20, "demo job position", 10));
    }
    @Override
    public void updateJobPosition(JobPosition jobPosition) {
        int index = jobPositionList.indexOf(jobPosition);
        if (index > 0) jobPositionList.set(index, jobPosition);
        JobPosition updatedJobPosition = jobPositionList.get(0);
        String updatedJobPositionString = "Job Position: " + updatedJobPosition.getId() + " - " +
                updatedJobPosition.getName() + " - vacant positions: " + updatedJobPosition.getVacantPositions();
        System.out.println(updatedJobPositionString);
    }
    @Override
    public Optional<JobPosition> getJobPosition(int jobPositionId){
        return jobPositionList.stream()
                .filter(jobPosition -> jobPosition.getId() == jobPositionId).findFirst();
    }
}
