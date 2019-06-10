package pl.edu.agh.pharmoptim.service;

import com.jcabi.ssh.SSH;
import com.jcabi.ssh.Shell;
import com.jcabi.ssh.SshByPassword;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.edu.agh.pharmoptim.model.JobParams;
import pl.edu.agh.pharmoptim.repository.JobRepository;

import java.io.IOException;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JobStarterService {

    private JobRepository repository;
    private ParametersProvider parametersProvider;

    private ResponseEntity startJob(JobParams jobParams){

    }


    private void startJobAtServer(){
        try {
            //Shell shell = new SSH(parametersProvider.getServerAddress(), 22, "username", "key...");
            Shell shell = new SshByPassword(
                    parametersProvider.getServerAddress(),
                    parametersProvider.getPort(),
                    parametersProvider.getUsername(),
                    parametersProvider.getPassword());
            String stdout = new Shell.Plain(shell).exec("tail -f /var/log/kern");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
