package com.example.ms3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/")
    public String hello() {
        logger.info("[ms3-controller] 実行されました");
        String message = helloService.hello();
        logger.info("[ms3-controller] メッセージを生成しました : {}", message);
        return message;
    }

}

