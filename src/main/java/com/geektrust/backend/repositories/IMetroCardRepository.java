package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.MetroCard;
import com.geektrust.backend.entites.PassengerType;

public interface IMetroCardRepository {

    MetroCard getCardByCardId(String cardId);

    void deductCardBalance(String cardID, Integer amount);

    void addCard(String cardId, Integer amt);

}
