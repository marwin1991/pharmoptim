package pl.edu.agh.pharmoptim.callback.api;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.agh.pharmoptim.callback.service.CallbackService;

import java.util.List;


@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CallbackApiController implements CallbackApi {

    private final CallbackService callbackService;

    // To test this endpoint
    //$ curl -v -H "Content-Type: multipart/form-data" -F "files=@./package.json" -F "files=@package-lock.json" -X POST http://localhost:8080/callback/jobs/1
    public ResponseEntity<Void> callbackJobsJobIdPost(@ApiParam(value = "",required=true) @PathVariable("jobId") Long jobId,@ApiParam(value = "") @RequestParam(value="files", required=false) List<MultipartFile> files) {
        callbackService.uploadFile(jobId, files);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
