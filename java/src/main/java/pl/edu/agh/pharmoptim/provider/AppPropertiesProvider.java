package pl.edu.agh.pharmoptim.provider;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Properties;

@Slf4j
public class AppPropertiesProvider {

    public static Properties getPropertiesFromSystemEnv(){
        Properties properties = new Properties();
        Map<String,String> envies = System.getenv();
        log.info("Przekaze parametry:");
        envies.forEach((key, value) -> {
            log.info(key+"="+value);
            properties.put(key,value);
        });
        return properties;
    }
}
