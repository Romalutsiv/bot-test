package com.example.testbot.command.impl;

import com.example.testbot.command.Command;
import com.example.testbot.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;
@RequiredArgsConstructor
public class KitchenCommand implements Command {
    private final SendMessageService sendMessageService;
    private final String MESSAGE_TEXT = "Вибрали кухню!";
    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), MESSAGE_TEXT);

    }
}
