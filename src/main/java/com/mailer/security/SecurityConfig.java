package com.mailer.security;

import com.ci.commons.security.CommonAuthenticationEntryPoint;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecurityConfig {

    @Bean
    public CommonAuthenticationEntryPoint entryPoint() {
        return new CommonAuthenticationEntryPoint();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
