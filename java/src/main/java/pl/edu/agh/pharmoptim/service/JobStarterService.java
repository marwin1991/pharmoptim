package pl.edu.agh.pharmoptim.service;

import com.jcabi.ssh.Shell;
import com.jcabi.ssh.SshByPassword;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.pharmoptim.entity.Job;
import pl.edu.agh.pharmoptim.model.JobIdOrError;
import pl.edu.agh.pharmoptim.model.JobParams;
import pl.edu.agh.pharmoptim.model.JobStatus;
import pl.edu.agh.pharmoptim.provider.ParametersProvider;
import pl.edu.agh.pharmoptim.repository.JobRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JobStarterService {

    private JobRepository repository;
    private ParametersProvider parametersProvider;

    public List<JobIdOrError> startJobs(List<JobParams> jobsParams){
        List<JobIdOrError> result = new ArrayList<>();

        jobsParams.forEach(jobParams -> {
            Job job = Job.builder()
                    .oralDose(jobParams.getOralDose())
                    .infDose(jobParams.getInfDose())
                    .infTime(jobParams.getInfTime())
                    .individualCount(jobParams.getIndividualCount())
                    .femaleCount(jobParams.getFemaleCount())
                    .minAge(jobParams.getMinAge())
                    .maxAge(jobParams.getMaxAge())
                    .tEnd(jobParams.getTEnd())
                    .seed(jobParams.getSeed())
                    .status(JobStatus.StatusEnum.RUNNING.toString())
                    .build();

            job = repository.saveAndFlush(job);
            log.info(job.toString());
            result.add(new JobIdOrError().id(job.getId()));
            startJobAtServer(job);
        });

        return result;
    }


    private void startJobAtServer(Job job){
        try {
            Shell shell = new SshByPassword(
                    parametersProvider.getServerAddress(),
                    parametersProvider.getPort(),
                    parametersProvider.getUsername(),
                    parametersProvider.getPassword());
            String cmd = new Shell.Plain(shell).exec(prepareCommand(job));
            log.info(cmd);
            log.info("Job started!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String prepareCommand(Job job){
        return parametersProvider.getStartCommand() + " " +
                job.getId() + " " +
                job.getOralDose() + " " +
                job.getInfDose() + " " +
                job.getInfTime() + " " +
                job.getIndividualCount() + " " +
                job.getFemaleCount() + " " +
                job.getMinAge() + " " +
                job.getMaxAge() + " " +
                job.getTEnd() + " " +
                job.getSeed() + " " +
                parametersProvider.getCallbackAddress();
    }


}
