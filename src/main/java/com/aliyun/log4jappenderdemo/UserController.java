package com.aliyun.log4jappenderdemo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @RequestMapping("/login")
    public String login(@RequestParam(value = "name", required = true) String name) {
        String requestID = Utils.randomString(10);
        LOGGER.info(String.format("User login successfully. requestID=%s name=%s", requestID, name));
        return "Welcome " + name;
    }

    @RequestMapping("/logout")
    public String logout(@RequestParam(value = "name", required = true) String name) {
        String requestID = Utils.randomString(10);
        LOGGER.info(String.format("User logout successfully. requestID=%s name=%s", requestID, name));
        return "Bye " + name;
    }
}