package pl.edu.agh.pharmoptim.download.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pl.edu.agh.pharmoptim.callback.provider.UploadParameterProvider;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
public class DownloadService {

    private final Path fileStorageLocation;

    public DownloadService(UploadParameterProvider uploadParameterProvider) {
        this.fileStorageLocation = Paths.get(uploadParameterProvider.getDir()).toAbsolutePath().normalize();
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                log.error("File not found " + fileName);
                return null;
            }
        } catch (MalformedURLException ex) {
            log.error("File not found " + fileName, ex);
            return null;
        }
    }
}
