package com.geektrust.backend.commands;

import com.geektrust.backend.exceptions.CommandNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandInvoker {
    private static final Map<String,ICommand> commandMap=new HashMap<>();
    public void register(String commandName, ICommand command) {
        commandMap.put(commandName,command);
    }

    private ICommand getCommand(String commandName){

        return commandMap.get(commandName);
    }

    public void executeCommand(String commandName, List<String> tokens)throws CommandNotFoundException {
        ICommand command=getCommand(commandName);
        if(command==null){
            throw new CommandNotFoundException();
        }
        command.execute(tokens);
    }


}
