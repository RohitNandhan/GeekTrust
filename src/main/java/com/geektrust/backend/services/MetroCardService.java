package com.geektrust.backend.services;

import com.geektrust.backend.repositories.IMetroCardRepository;

public class MetroCardService implements IMetroCardService{
    private IMetroCardRepository metroCardRepository;

    public MetroCardService(IMetroCardRepository metroCardRepository) {
        this.metroCardRepository = metroCardRepository;
    }

    @Override
    public void updateCardBalance(String cardId,Integer balance) {
        metroCardRepository.addCard(cardId,balance);
    }
}
