package com.kob.matchingsystem;

import com.kob.matchingsystem.service.MatchingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MatchingsystemApplication {

    public static void main(String[] args) {

        MatchingServiceImpl.matchinPool.start();  // 匹配系统启动之前启动匹配线程

        SpringApplication.run(MatchingsystemApplication.class, args);
    }

}
