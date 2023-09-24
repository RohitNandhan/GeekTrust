package com.geektrust.backend.commands;

import com.geektrust.backend.services.IMetroService;

import java.util.List;

public class CheckInCommand implements ICommand{
    private final IMetroService metroService;

    public CheckInCommand(IMetroService metroService) {
        this.metroService = metroService;
    }

    @Override
    public void execute(List<String> tokensList) {
        String cardId=tokensList.get(1);
        String passengerType=tokensList.get(2);
        String fromStation=tokensList.get(3);

        metroService.checkInService(cardId,passengerType,fromStation);
    }
}
