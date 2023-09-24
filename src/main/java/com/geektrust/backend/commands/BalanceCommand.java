package com.geektrust.backend.commands;

import com.geektrust.backend.services.IMetroCardService;
import com.geektrust.backend.services.IMetroService;

import java.util.List;

public class BalanceCommand implements ICommand {
   private final IMetroCardService metroCardService ;

    public BalanceCommand(IMetroCardService metroCardService) {
        this.metroCardService = metroCardService;
    }

    @Override
    public void execute(List<String> tokensList) {
        String cardId=tokensList.get(1);
        Integer balance=Integer.valueOf(tokensList.get(2));

        metroCardService.updateCardBalance(cardId,balance);
    }
}
