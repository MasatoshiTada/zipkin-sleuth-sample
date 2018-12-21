package com.example.ms4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final int stopSeconds;

    public UserService(@Value("${stop.seconds: 0}") int stopSeconds) {
        this.stopSeconds = stopSeconds;
    }

    public String getUser() {
        logger.info("[ms4-service] 呼ばれました");
        sleep(stopSeconds);
        return "user01";
    }

    private void sleep(int seconds) {
        try {
            logger.info("[ms4-service] {}秒スリープ", seconds);
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {}
    }
}
