package pl.edu.agh.pharmoptim.callback.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.agh.pharmoptim.callback.provider.UploadParameterProvider;
import pl.edu.agh.pharmoptim.entity.Job;
import pl.edu.agh.pharmoptim.model.JobStatus;
import pl.edu.agh.pharmoptim.repository.JobRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import static java.lang.System.exit;

@Slf4j
@Service
public class CallbackService {

    private JobRepository repository;
    private final Path fileStorageLocation;

    @Autowired
    public CallbackService(UploadParameterProvider uploadParameterProvider, JobRepository repository) {
        this.fileStorageLocation = Paths.get(uploadParameterProvider.getDir()).toAbsolutePath().normalize();
        this.repository = repository;

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            log.error("Could not create the directory where the uploaded files will be stored.", ex);
            exit(1);
        }
    }

    public void uploadFile(Long jobId, List<MultipartFile> files) {

        Job job;
        Optional<Job> jobOptional = repository.findById(jobId);

        job = jobOptional.orElseGet(() -> Job.builder().id(jobId).build());

        files.forEach(file -> {
            if (file.isEmpty()) {
                log.info("Failed to save empty file");
                return;
            }
            String fileName = storeFile(file);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();

            if(fileName.contains("popu"))
                job.setPathToPopulation(fileDownloadUri);
            else
                job.setPathToNewDf(fileDownloadUri);

        });
        job.setStatus(JobStatus.StatusEnum.DONE.toString());
        repository.saveAndFlush(job);
    }


    private String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                log.error("Sorry! Filename contains invalid path sequence " + fileName);
                return "";
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            log.error("Could not store file " + fileName + ". Please try again!", ex);
            return "";
        }
    }
}
