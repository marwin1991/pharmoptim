package pl.edu.agh.pharmoptim.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.pharmoptim.entity.Job;
import pl.edu.agh.pharmoptim.model.JobStatus;
import pl.edu.agh.pharmoptim.repository.JobRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JobStatusService {

    private JobRepository repository;

    public List<JobStatus> getStatuses(List<Integer> jobIds){
        List<JobStatus> result = new ArrayList<>();
        log.info("Getting statuses for jobs.");
        jobIds.forEach(jobId -> {
            log.info("Getting status for job: " + jobId);
            Optional<Job> jobOptional = repository.findById(Long.valueOf(jobId));
            if(jobOptional.isPresent()){
                result.add(
                  new JobStatus()
                          .id(jobId).status(JobStatus.StatusEnum.fromValue(jobOptional.get().getStatus()))
                );
            } else {
                result.add(
                        new JobStatus()
                                .id(jobId).status(JobStatus.StatusEnum.NOT_FOUND)
                );
            }
        });
        return result;
    }
}
