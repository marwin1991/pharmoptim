package pl.edu.agh.pharmoptim.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.pharmoptim.entity.Job;
import pl.edu.agh.pharmoptim.model.JobResultsOrError;
import pl.edu.agh.pharmoptim.model.JobStatus;
import pl.edu.agh.pharmoptim.repository.JobRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JobResultService {

    private JobRepository repository;

    public List<JobResultsOrError> getResults(List<Integer> jobIds) {
        List<JobResultsOrError> results = new ArrayList<>();
        log.info("Getting results for jobs.");
        jobIds.forEach(jobId -> {
            log.info("Getting result for job: " + jobId);
            Optional<Job> jobOptional = repository.findById(Long.valueOf(jobId));

            if (jobOptional.isPresent()) {
                String error = "";

                Job job = jobOptional.get();

                if (job.getStatus().equals(JobStatus.StatusEnum.RUNNING.toString()))
                    error = "Job is still running!";

                if (job.getStatus().equals(JobStatus.StatusEnum.ERROR.toString()))
                    error = "Job finished with unexpected error!";

                if (job.getStatus().equals(JobStatus.StatusEnum.CANCELLED.toString()))
                    error = "Job was canceled!";

                results.add(
                        new JobResultsOrError()
                                .id(jobId)
                                .population(job.getPathToPopulation())
                                .newDf(job.getPathToNewDf())
                                .error(error)
                );
            } else {
                results.add(
                        new JobResultsOrError()
                                .id(jobId)
                                .population("")
                                .newDf("")
                                .error("Job with this ID not found!")
                );
            }
        });

        return results;
    }
}
