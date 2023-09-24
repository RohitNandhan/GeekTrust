package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.MetroCard;

import java.util.HashMap;
import java.util.Map;

public class MetroCardRepository implements IMetroCardRepository{

    private final Map<String,MetroCard> metroCardMap;

    public MetroCardRepository() {
        this.metroCardMap = new HashMap<>();
    }

    @Override
    public void addCardBalance(String cardId, Integer amount) {
        getCardByCardId(cardId).addBalance(amount);
    }

    @Override
    public MetroCard getCardByCardId(String cardId){
        return metroCardMap.get(cardId);
    }

    @Override
    public void deductCardBalance(String cardID, Integer amount) {
            getCardByCardId(cardID).deductBalance(amount); ;
    }

    @Override
    public MetroCard addCard(MetroCard metroCard) {
        return metroCardMap.put(metroCard.getCardId(), metroCard);
    }
    @Override
    public void addCard(String cardId, Integer amt) {
        MetroCard metroCard=new MetroCard(cardId,amt);
        metroCardMap.put(cardId,metroCard);
    }

    @Override
    public MetroCard delecteCard(String cardId) {
        return metroCardMap.remove(cardId);
    }

    @Override
    public Integer getCardBalance(String cardId) {
            return getCardByCardId(cardId).getBalance();
    }
}
