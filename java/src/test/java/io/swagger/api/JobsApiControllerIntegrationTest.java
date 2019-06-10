package io.swagger.api;

import pl.edu.agh.pharmoptim.api.JobsApi;
import pl.edu.agh.pharmoptim.model.JobIdOrError;
import pl.edu.agh.pharmoptim.model.JobParams;
import pl.edu.agh.pharmoptim.model.JobResultsOrError;
import pl.edu.agh.pharmoptim.model.JobStatus;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobsApiControllerIntegrationTest {

    @Autowired
    private JobsApi api;

    @Test
    public void jobsJobIdDeleteTest() throws Exception {
        Long jobId = 56L;
        ResponseEntity<Void> responseEntity = api.jobsJobIdDelete(jobId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void jobsJobIdsResultsGetTest() throws Exception {
        List<Integer> jobIds = Arrays.asList(56);
        ResponseEntity<List<JobResultsOrError>> responseEntity = api.jobsJobIdsResultsGet(jobIds);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void jobsJobIdsStatusGetTest() throws Exception {
        List<Integer> jobIds = Arrays.asList(56);
        ResponseEntity<List<JobStatus>> responseEntity = api.jobsJobIdsStatusGet(jobIds);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void jobsPostTest() throws Exception {
        List<JobParams> body = Arrays.asList(new JobParams());
        ResponseEntity<List<JobIdOrError>> responseEntity = api.jobsPost(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
