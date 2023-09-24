package com.geektrust.backend.entites;

import java.util.List;
import java.util.Map;

public class Metro {
    private MetroStation metroStation;
    private List<MetroCard> metroCardList;
//    private Map<String,JourneyType> journeyTypeMap;

    public Metro(MetroStation metroStation, List<MetroCard> metroCardList) {
        this.metroStation = metroStation;
        this.metroCardList = metroCardList;
    }
    public void addMetroCard(MetroCard metroCard){
        metroCardList.add(metroCard);
    }

    public MetroStation getMetroStation() {
        return metroStation;
    }

    public List<MetroCard> getMetroCardList() {
        return metroCardList;
    }
    public boolean isCardExist(String cardId){
        return metroCardList.stream().anyMatch(c->cardId.equals(c.getCardId()));
    }
    public MetroCard getCardById(String cardId){
        if(isCardExist(cardId))
          return metroCardList.stream().filter(c->cardId.equals(c.getCardId())).findAny().get();
        return null;
    }
}
