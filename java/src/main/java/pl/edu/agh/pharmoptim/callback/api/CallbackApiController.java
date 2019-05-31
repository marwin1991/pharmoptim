package pl.edu.agh.pharmoptim.callback.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-31T21:23:11.266Z[GMT]")
@Controller
public class CallbackApiController implements CallbackApi {

    private static final Logger log = LoggerFactory.getLogger(CallbackApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CallbackApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


    //$ curl -v -H "Content-Type: multipart/form-data" -F "files=@./package.json" -F "files=@package-lock.json" -X POST http://localhost:8080/callback/jobs/2
    public ResponseEntity<Void> callbackJobsJobIdPost(@ApiParam(value = "",required=true) @PathVariable("jobId") Integer jobId,@ApiParam(value = "") @RequestParam(value="files", required=false) List<MultipartFile> files) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
