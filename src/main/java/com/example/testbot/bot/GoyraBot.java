package com.example.testbot.bot;

import com.example.testbot.bot.keyboard.ReplyKeyboardMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@RequiredArgsConstructor
public class GoyraBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final ReplyKeyboardMaker replyKeyboardMaker;



    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().getText()!=null){
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();

            SendMessage sm = new SendMessage(chatId, message);
            sm.setReplyMarkup(replyKeyboardMaker.getStartMenu());
            try{
                execute(sm);
            }  catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }

    }
}
