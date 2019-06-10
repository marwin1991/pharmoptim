package pl.edu.agh.pharmoptim.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {

    @Bean
    public AbstractRequestLoggingFilter logFilter() {
        RequestLoggingFilter filter = new RequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(false);
        filter.setIncludeClientInfo(true);
        filter.setIncludeHeaders(false);
        filter.setBeforeMessagePrefix("REQUEST START: ");
        filter.setBeforeMessageSuffix("");
        return filter;
    }
}