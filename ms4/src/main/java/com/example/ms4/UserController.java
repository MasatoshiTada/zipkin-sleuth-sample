package com.example.ms4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUser() {
        logger.info("[ms4-controller] 実行されました");
        String user = userService.getUser();
        logger.info("[ms4-controller] メッセージを生成しました : {}", user);
        return user;
    }

}

