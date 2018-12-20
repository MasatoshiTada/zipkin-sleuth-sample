package com.example.ms1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ms1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ms1Application.class, args);
    }

    @Bean
    public FilterRegistrationBean loggingFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean =
                new FilterRegistrationBean<>(new LoggingFilter());
        registrationBean.setOrder(Integer.MIN_VALUE);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}