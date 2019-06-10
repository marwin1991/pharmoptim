package pl.edu.agh.pharmoptim.service;

import com.jcabi.ssh.Shell;
import com.jcabi.ssh.SshByPassword;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.edu.agh.pharmoptim.entity.Job;
import pl.edu.agh.pharmoptim.model.JobStatus;
import pl.edu.agh.pharmoptim.provider.ParametersProvider;
import pl.edu.agh.pharmoptim.repository.JobRepository;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JobDeleteService {

    private JobRepository repository;
    private ParametersProvider parametersProvider;

    public ResponseEntity deleteJob(Long jobId){
        log.info("Cancelling job: " + jobId);

        Optional<Job> jobOptional = repository.findById(jobId);

        if(jobOptional.isPresent()){
            deleteJobAtServer(jobId);
            Job job = jobOptional.get();
            if(job.getStatus().equals(JobStatus.StatusEnum.RUNNING.toString())) {
                job.setStatus(JobStatus.StatusEnum.CANCELLED.toString());
                repository.saveAndFlush(job);
                return ResponseEntity.status(HttpStatus.OK).build();
            } else {
                log.info("Job is not running. Either finished or was cancelled.");
                return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
            }
        } else {
            log.info("Job not found! Cannot cancelled!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


    private void deleteJobAtServer(Long id){
        try {
            Shell shell = new SshByPassword(
                    parametersProvider.getServerAddress(),
                    parametersProvider.getPort(),
                    parametersProvider.getUsername(),
                    parametersProvider.getPassword());
            String cmd = new Shell.Plain(shell).exec(parametersProvider.getDeleteCommand() + " " + id);
            log.info(cmd);
            log.info("Job cancelled!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
