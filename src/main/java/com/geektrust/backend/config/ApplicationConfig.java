package com.geektrust.backend.config;


import com.geektrust.backend.commands.BalanceCommand;
import com.geektrust.backend.commands.CheckInCommand;
import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.commands.PrintSummaryCommand;
import com.geektrust.backend.repositories.IMetroCardRepository;
import com.geektrust.backend.repositories.IMetroRepository;
import com.geektrust.backend.repositories.MetroCardRepository;
import com.geektrust.backend.repositories.MetroRepository;
import com.geektrust.backend.services.IMetroCardService;
import com.geektrust.backend.services.IMetroService;
import com.geektrust.backend.services.MetroCardService;
import com.geektrust.backend.services.MetroService;

public class ApplicationConfig {

    private final IMetroCardRepository metroCardRepository=new MetroCardRepository();
    private final IMetroRepository metroRepository=new MetroRepository();

    private final IMetroCardService metroCardService=new MetroCardService(metroCardRepository);
    private final IMetroService metroService=new MetroService(metroCardRepository,metroRepository);

    private final BalanceCommand balanceCommand=new BalanceCommand(metroCardService);
    private final CheckInCommand checkInCommand=new CheckInCommand(metroService);
    private final PrintSummaryCommand printSummaryCommand=new PrintSummaryCommand(metroService);


    final CommandInvoker commandInvoker=new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("BALANCE",balanceCommand);
        commandInvoker.register("BALANCE",checkInCommand);
        commandInvoker.register("PRINT_SUMMARY",printSummaryCommand);
       return commandInvoker;
    }


}
