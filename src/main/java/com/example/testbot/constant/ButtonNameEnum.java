package com.example.testbot.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ButtonNameEnum {
    BAR ("Бар"),
    KITCHEN ("Кухня");

    private final String name;

}
