package com.aliyun.log4jappenderdemo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private static final Logger LOGGER = LogManager.getLogger(OrderController.class);

    @RequestMapping("/order")
    public String order(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "item", required = true) String item, @RequestParam(value = "amount", required = false, defaultValue = "1") Integer amount) {
        String requestID = Utils.randomString(10);
        String info = String.format("Place an order successfully. requestID=%s name=%s item=%s amount=%d", requestID, name, item, amount);
        LOGGER.info(info);
        return info;
    }
}
