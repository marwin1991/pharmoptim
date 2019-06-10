package pl.edu.agh.pharmoptim.configuration;

import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

public class RequestLoggingFilter extends AbstractRequestLoggingFilter {
    public RequestLoggingFilter() {
    }

    protected void beforeRequest(HttpServletRequest request, String message) {
        this.logger.info(message);
    }

    protected void afterRequest(HttpServletRequest request, String message) {
        this.logger.info("REQUEST END");
    }
}
