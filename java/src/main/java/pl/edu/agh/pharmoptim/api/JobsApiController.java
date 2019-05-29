package pl.edu.agh.pharmoptim.api;

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

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-29T18:58:28.378Z[GMT]")
@Controller
public class JobsApiController implements JobsApi {

    private static final Logger log = LoggerFactory.getLogger(JobsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public JobsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> jobsJobIdDelete(@ApiParam(value = "",required=true) @PathVariable("jobId") Integer jobId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<JobResultsOrError>> jobsJobIdsResultsGet(@ApiParam(value = "",required=true) @PathVariable("jobIds") List<Integer> jobIds) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<JobResultsOrError>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<JobStatus>> jobsJobIdsStatusGet(@ApiParam(value = "",required=true) @PathVariable("jobIds") List<Integer> jobIds) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<JobStatus>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<JobIdOrError>> jobsPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<JobParams> body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<JobIdOrError>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
