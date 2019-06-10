package pl.edu.agh.pharmoptim.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ParametersProvider {

    @Value( "${pharmoptim.server.address}" )
    private String serverAddress;

    @Value( "${pharmoptim.server.port}" )
    private Integer port;

    @Value( "${pharmoptim.server.username}" )
    private String username;

    @Value( "${pharmoptim.server.password}" )
    private String password;
}
