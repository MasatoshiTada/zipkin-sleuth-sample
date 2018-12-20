package com.example.ms3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    private final int stopSeconds;

    public HelloService(@Value("${stop.seconds: 0}") int stopSeconds) {
        this.stopSeconds = stopSeconds;
    }

    public String hello() {
        logger.info("[ms3-service] 呼ばれました");
        sleep(stopSeconds);
        return "hello";
    }

    private void sleep(int seconds) {
        try {
            logger.info("[ms3-service] {}秒スリープ", seconds);
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {}
    }
}
