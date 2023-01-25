package com.example.testbot.bot;

import com.example.testbot.Config;
import com.example.testbot.bot.keyboard.ReplyKeyboardMaker;
import com.example.testbot.command.CommandContainer;
import com.example.testbot.constant.Commands;
import com.example.testbot.service.impl.SendMessageServiceImpl;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class GoyraBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    private ReplyKeyboardMaker replyKeyboardMaker;
    private final Config config;
    private final CommandContainer commands;


    public GoyraBot(ReplyKeyboardMaker replyKeyboardMaker, Config config) {
        this.config = config;
        commands =new CommandContainer(new SendMessageServiceImpl(this, replyKeyboardMaker));
    }

    @Override
    public String getBotUsername() {
        return config.getUsername();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        Map<String, Commands> messagesAndCommands = new HashMap<>();
        messagesAndCommands.put("бар", Commands.BAR);
        messagesAndCommands.put("кухня", Commands.KITCHEN);
        messagesAndCommands.put("допомога", Commands.HELP);


        if (update.hasMessage() && update.getMessage().hasText()) {

            String message = update.getMessage().getText().trim();
            Commands command = messagesAndCommands.get(message.toLowerCase());

            if (command != null) {
                String commandIdentifier = command.getCommand();

                commands.retrieveCommand(commandIdentifier).execute(update);
            } else {
                System.out.println("error");

            }
        }

    }
}
