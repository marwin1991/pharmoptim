package pl.edu.agh.pharmoptim.callback.provider;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UploadParameterProvider {

    @Value( "${pharmoptim.upload.dir}" )
    private String dir;

}
