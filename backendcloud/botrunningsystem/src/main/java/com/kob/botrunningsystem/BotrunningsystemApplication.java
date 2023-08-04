package com.kob.botrunningsystem;

import com.kob.botrunningsystem.service.impl.BotRunningServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotrunningsystemApplication {

    public static void main(String[] args) {

        BotRunningServiceImpl.botPool.start(); // 在项目启动之前启动BotRunning线程
        SpringApplication.run(BotrunningsystemApplication.class, args);
    }

}
