package com.example.testbot.service.impl;

import com.example.testbot.bot.GoyraBot;
import com.example.testbot.bot.keyboard.ReplyKeyboardMaker;
import com.example.testbot.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@RequiredArgsConstructor
public class SendMessageServiceImpl implements SendMessageService {

    private final GoyraBot bot;
    private final ReplyKeyboardMaker replyKeyboardMaker;

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sm = new SendMessage();
        sm.setReplyMarkup(replyKeyboardMaker.getStartMenu());
        sm.setChatId(chatId);
        sm.enableHtml(true);
        sm.setText(message);

        try {
            bot.execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
