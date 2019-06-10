package pl.edu.agh.pharmoptim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.agh.pharmoptim.provider.AppPropertiesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Pharmoptim{

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Pharmoptim.class);
        application.setDefaultProperties(AppPropertiesProvider.getPropertiesFromSystemEnv());
        application.run(args);
    }
}
