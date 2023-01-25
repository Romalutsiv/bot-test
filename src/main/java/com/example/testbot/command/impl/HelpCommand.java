package com.example.testbot.command.impl;

import com.example.testbot.command.Command;
import com.example.testbot.constant.Commands;
import com.example.testbot.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;
@RequiredArgsConstructor
public class HelpCommand implements Command {
    private final SendMessageService sendMessageService;
    private final String MESSAGE_TEXT = String.format("✨<b>Дотупные команды</b>✨\n\n"

                    + "<b>Начать\\закончить работу с ботом</b>\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"
                    + "%s - получить помощь в работе со мной\n",
            Commands.BAR.getCommand(), Commands.KITCHEN.getCommand(), Commands.HELP.getCommand());
    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), MESSAGE_TEXT);

    }
}
