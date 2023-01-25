package com.example.testbot.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Commands {

    BAR("/bar"),
    KITCHEN("/kitchen"),
    HELP("/help");


    private final String command;
//    private final String nameUkr;

//    public boolean containMessage(String message){
//        return this.nameUkr.equals(message);
//
//    }

}
