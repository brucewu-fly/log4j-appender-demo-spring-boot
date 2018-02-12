package com.aliyun.log4jappenderdemo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    private static final Logger LOGGER = LogManager.getLogger(ExceptionController.class);

    @RequestMapping("/runtimeException")
    public String runtimeException() {
        LOGGER.error(new RuntimeException("RuntimeException happened"));
        return "RuntimeException happened";
    }

    @RequestMapping("/nullPointerException")
    public String nullPointerException() {
        LOGGER.error(new NullPointerException("NullPointerException happened"));
        return "NullPointerException happened";
    }

    @RequestMapping("/classNotFoundException")
    public String classNotFoundException() {
        LOGGER.error(new ClassNotFoundException("ClassNotFoundException happened"));
        return "ClassNotFoundException happened";
    }

}
