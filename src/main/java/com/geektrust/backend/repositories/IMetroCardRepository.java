package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.MetroCard;
import com.geektrust.backend.entites.PassengerType;

public interface IMetroCardRepository {

   // public void deductCardBalance(PassengerType passengerType,Integer amount);

    void addCardBalance(String cardId, Integer amount);

    MetroCard getCardByCardId(String cardId);

    void deductCardBalance(String cardID, Integer amount);

    public MetroCard addCard(MetroCard metroCard);

    void addCard(String cardId, Integer amt);

    public MetroCard delecteCard(String cardId);
    public Integer getCardBalance(String cardId);

}
