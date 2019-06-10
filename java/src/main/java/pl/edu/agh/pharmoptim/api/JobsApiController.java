package pl.edu.agh.pharmoptim.api;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.pharmoptim.model.JobIdOrError;
import pl.edu.agh.pharmoptim.model.JobParams;
import pl.edu.agh.pharmoptim.model.JobResultsOrError;
import pl.edu.agh.pharmoptim.model.JobStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.edu.agh.pharmoptim.service.JobDeleteService;
import pl.edu.agh.pharmoptim.service.JobResultService;
import pl.edu.agh.pharmoptim.service.JobStarterService;
import pl.edu.agh.pharmoptim.service.JobStatusService;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JobsApiController implements JobsApi {

    private final JobStarterService jobStarterService;
    private final JobDeleteService jobDeleteService;
    private final JobResultService jobResultService;
    private final JobStatusService jobStatusService;

    public ResponseEntity<List<JobIdOrError>> jobsPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<JobParams> body) {
        return new ResponseEntity<>(jobStarterService.startJobs(body), HttpStatus.OK);
    }

    public ResponseEntity<Void> jobsJobIdDelete(@ApiParam(value = "",required=true) @PathVariable("jobId") Long jobId) {
        jobDeleteService.deleteJob(jobId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<JobResultsOrError>> jobsJobIdsResultsGet(@ApiParam(value = "",required=true) @PathVariable("jobIds") List<Integer> jobIds) {
        return new ResponseEntity<>(jobResultService.getResults(jobIds), HttpStatus.OK);
    }

    public ResponseEntity<List<JobStatus>> jobsJobIdsStatusGet(@ApiParam(value = "",required=true) @PathVariable("jobIds") List<Integer> jobIds) {
        return new ResponseEntity<>(jobStatusService.getStatuses(jobIds), HttpStatus.OK);
    }
}
