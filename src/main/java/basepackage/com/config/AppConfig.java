package basepackage.com.config;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
@Configuration
@ComponentScan(basePackages = "basepackage")
public class AppConfig {
    // Your configuration beans here

    @Bean
    public ResourceHttpRequestHandler resourceHttpRequestHandler() {
        ResourceHttpRequestHandler handler = new ResourceHttpRequestHandler();
        handler.setLocations(List.of(new ClassPathResource("/static/")));
        handler.setCacheSeconds(3600); // Set cache duration
        return handler;
    }
}