package com.example.testbot.command;

import com.example.testbot.command.impl.BarCommand;
import com.example.testbot.command.impl.HelpCommand;
import com.example.testbot.command.impl.KitchenCommand;
import com.example.testbot.constant.Commands;
import com.example.testbot.service.SendMessageService;
import com.google.common.collect.ImmutableMap;

public class CommandContainer {

    private final ImmutableMap<String, Command> commands;

    public CommandContainer(SendMessageService sendMessageService) {
        commands = ImmutableMap.<String, Command>builder()
                .put(Commands.BAR.getCommand(), new BarCommand(sendMessageService))
                .put(Commands.KITCHEN.getCommand(), new KitchenCommand(sendMessageService))
                .put(Commands.HELP.getCommand(), new HelpCommand(sendMessageService))
                .build();
    }

    public Command retrieveCommand(String identifier){
        return commands.get(identifier);
    }
}
