package pl.edu.agh.pharmoptim.provider;

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

    @Value( "${pharmoptim.server.start_command}")
    private String startCommand;

    @Value( "${pharmoptim.server.delete_command}")
    private String deleteCommand;

    @Value( "${pharmoptim.server.callback_address}")
    private String callbackAddress;
}
