package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.MetroCard;

import java.util.HashMap;
import java.util.Map;

public class MetroCardRepository implements IMetroCardRepository {

    private final Map<String, MetroCard> metroCardMap;

    public MetroCardRepository() {
        this.metroCardMap = new HashMap<>();
    }

    @Override
    public MetroCard getCardByCardId(String cardId) {
        return metroCardMap.get(cardId);
    }

    @Override
    public void deductCardBalance(String cardID, Integer amount) {
        getCardByCardId(cardID).deductBalance(amount);

    }

    @Override
    public void addCard(String cardId, Integer amt) {
        MetroCard metroCard = new MetroCard(cardId, amt);
        metroCardMap.put(cardId, metroCard);
    }
}
