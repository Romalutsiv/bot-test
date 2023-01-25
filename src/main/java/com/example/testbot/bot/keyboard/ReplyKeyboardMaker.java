package com.example.testbot.bot.keyboard;

import com.example.testbot.constant.ButtonNameEnum;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ReplyKeyboardMaker {

    public ReplyKeyboardMarkup getStartMenu(){
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(ButtonNameEnum.BAR.getName()));
        row1.add(new KeyboardButton(ButtonNameEnum.KITCHEN.getName()));
        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton(ButtonNameEnum.HELP.getName()));
        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);

        final ReplyKeyboardMarkup res = new ReplyKeyboardMarkup();
        res.setKeyboard(rows);
        res.setSelective(true);
        res.setResizeKeyboard(true);
        res.setOneTimeKeyboard(false);
        return res;
    }
}
