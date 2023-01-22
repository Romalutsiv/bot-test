package com.example.testbot.bot.keyboard;

import com.example.testbot.constant.ButtonNameEnum;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Collections;
@Component
public class ReplyKeyboardMaker {

    public ReplyKeyboardMarkup getStartMenu(){
        KeyboardRow row = new KeyboardRow();
        row.add(new KeyboardButton(ButtonNameEnum.BAR.getName()));
        row.add(new KeyboardButton(ButtonNameEnum.KITCHEN.getName()));

        final ReplyKeyboardMarkup res = new ReplyKeyboardMarkup();
        res.setKeyboard(Collections.singletonList(row));
        res.setSelective(true);
        res.setResizeKeyboard(true);
        res.setOneTimeKeyboard(false);
        return res;
    }
}
