package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.*;

import java.util.*;
import java.util.stream.Collectors;

public class MetroRepository implements IMetroRepository{

    private Map<Station, Metro> metroMap;

    public MetroRepository() {
        this.metroMap = new HashMap<>();
    }
    @Override
    public void saveMetro(Station station, Metro metro){
        if(!metroMap.containsKey(station)) {
            this.metroMap.put(station, metro);
        }
    }

    @Override
    public void saveMetro(Station station, MetroCard metroCard) {
    if(metroMap.containsKey(station)){
            metroMap.get(station).addMetroCard(metroCard);
    }else {
        MetroStation metroStation=new MetroStation(station);
        this.metroMap.put(station,new Metro(metroStation, new ArrayList<>(Arrays.asList(metroCard))));
    }
    }
    @Override
    public void addPassenger(Station fromStation, PassengerType passengerType){
        getMetroStation(fromStation).addPassenger(passengerType);
    }
    @Override
    public List<Metro> getMetrolist(){
        return metroMap.values().stream().collect(Collectors.toList());
    }
//    @Override
//    public Station getStation(Station station){
//
//    }
    @Override
    public MetroCard getMetroCardById(Station station, String cardId){
        return getMetro(station).getCardById(cardId);
    }
    @Override
    public JourneyType getJourneyType(Station station, String cardId){
        return getMetroCardById(station,cardId).getJourneyType();
    }

    @Override
    public void setJourneyType(Station fromStation, String cardId) {
            getMetroCardById(fromStation,cardId).toggleJourneyType();
    }
//    @Override
//    public void setJourneyType(Station fromStation,String cardId){
//        getMetroStation(fromStation).setJourneyType(cardId);
//    }

    @Override
    public void addCollectedAmount(Station fromStation, Integer amount){

        getMetroStation(fromStation).addAmount(amount);
    }
    @Override
    public void addDiscountAmount(Station fromStation, Integer amount){

        getMetroStation(fromStation).addDiscountAmount(amount);
    }

    @Override
    public Map<PassengerType,Integer> getPassengers(Station station){
        return getMetroStation(station).getPassengerMap();
    }

    @Override
    public MetroStation getMetroStation(Station station) {
        return getMetro(station).getMetroStation();
    }
    @Override
    public Metro getMetro(Station station){
       return metroMap.get(station);
    }
    @Override
    public Integer getTotalAmount(Station station) {
        return getMetroStation(station).getTotalAmountCollected();
    }
    @Override
    public Integer getDiscountAmount(Station station){
        return getMetroStation(station).getTotalDiscountAmountCollected();
    }

}
