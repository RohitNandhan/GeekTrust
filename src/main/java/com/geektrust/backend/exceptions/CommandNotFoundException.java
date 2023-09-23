package com.geektrust.backend.exceptions;

public class CommandNotFoundException extends Exception{
    public CommandNotFoundException(){}
    public CommandNotFoundException(String msg){
        super(msg);
    }
}
