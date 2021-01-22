package com.demo.talk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication

@MapperScan(basePackages = {"com.demo.talk.mapper"})
public class TalkWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalkWebsocketApplication.class, args);
    }

}
