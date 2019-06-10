package pl.edu.agh.pharmoptim.callback.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class CallbackApiController implements CallbackApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
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
