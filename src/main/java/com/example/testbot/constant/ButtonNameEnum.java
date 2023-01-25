package com.example.testbot.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ButtonNameEnum {
    BAR ("Бар"),
    KITCHEN ("Кухня"),
    HELP("Допомога");

    private final String name;

}
