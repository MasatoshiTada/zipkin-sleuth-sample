package com.example.ms2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    private final RestTemplateBuilder restTemplateBuilder;
    private final int stopSeconds;

    public HelloService(RestTemplateBuilder restTemplateBuilder, @Value("${stop.seconds: 0}") int stopSeconds) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.stopSeconds = stopSeconds;
    }

    public String hello() {
        logger.info("[ms2-service] 呼ばれました");
        sleep(stopSeconds);
        RestTemplate restTemplate = restTemplateBuilder.build();
        String message = restTemplate.getForObject("http://localhost:8083/", String.class);
        logger.info("[ms2-service] ms3からメッセージを受け取りました : {}", message);
        return message.toUpperCase();
    }

    private void sleep(int seconds) {
        try {
            logger.info("[ms2-service] {}秒スリープ", seconds);
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {}
    }
}
