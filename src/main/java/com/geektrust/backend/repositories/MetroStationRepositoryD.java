//package com.geektrust.backend.repositories;
//
//import com.geektrust.backend.entites.MetroStation;
//import com.geektrust.backend.entites.PassengerType;
//import com.geektrust.backend.entites.Station;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class MetroStationRepositoryD implements IMetroStationRepository{
//
//    private Map<Station,MetroStation> metroStationMap;
//
//    public MetroStationRepositoryD() {
//        this.metroStationMap = new HashMap<>();
//    }
//    @Override
//    public void saveMetroStation(Station station){
//        if(!metroStationMap.containsKey(station)) {
//            MetroStation metroStation = new MetroStation(station);
//            this.metroStationMap.put(station, metroStation);
//        }
//    }
//    @Override
//    public void addPassenger(Station fromStation, PassengerType passengerType){
//        getMetroStation(fromStation).addPassenger(passengerType);
//    }
//
//    @Override
//    public void setJourneyType(Station fromStation, String cardId) {
//
//    }
////    @Override
////    public void setJourneyType(Station fromStation,String cardId){
////        getMetroStation(fromStation).setJourneyType(cardId);
////    }
//
//    @Override
//    public void addCollectedAmount(Station fromStation, Integer amount){
//        getMetroStation(fromStation).addAmount(amount);
//    }
//
//    @Override
//    public Map<PassengerType,Integer> getPassengers(Station station){
//        return getMetroStation(station).getPassengerMap();
//    }
//
//    @Override
//    public MetroStation getMetroStation(Station station) {
//        return metroStationMap.get(station);
//    }
//
//    @Override
//    public Integer getTotalAmount(Station station) {
//        return getMetroStation(station).getTotalAmountCollected();
//    }
//}
