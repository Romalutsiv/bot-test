package com.example.testbot;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Config {

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;
}
