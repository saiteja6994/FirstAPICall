package com.example.myfirstspringproject.Config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    //whatever the return type pf the below method please make it as an object and
    //store it in container
    public RestTemplate getrestTemplate() {
        return new RestTemplateBuilder().build();
    }
}
