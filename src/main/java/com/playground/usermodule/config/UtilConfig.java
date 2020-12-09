package com.playground.usermodule.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * UtilConfig provides beans for Utility classes
 *
 * @author thilak
 * @created 12/4/20
 */
@Configuration
public class UtilConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.playground.usermodule")).build();
    }


    @Bean
    public Timer createUserTimer(MeterRegistry meterRegistry) {
        return Timer.builder("users.createUser.time")
                .description("Time taken to create a User")
                .register(meterRegistry);
    }
}
