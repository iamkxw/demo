package com.demo.biz.web;

import com.demo.common.log.AppLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.demo"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        AppLogger.sysLogger.info("---------------------------- Server has successfully started ----------------------------");
    }
}
