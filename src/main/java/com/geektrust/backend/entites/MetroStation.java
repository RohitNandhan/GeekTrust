package com.geektrust.backend.entites;

import java.util.HashMap;
import java.util.Map;

public class MetroStation {
    private final Station station;
    private Integer totalAmountCollected=0;
    private Map<Station,Integer> amountcollectedMap;
    //private Map<String,JourneyType> journeyTypeMap;
    private Integer totalDiscount;
    private Map<PassengerType,Integer> passengerMap;

    public MetroStation(Station station) {
        this.station = station;
        this.passengerMap=new HashMap<>();
        this.totalAmountCollected=0;
        this.totalDiscount=0;
    }
    public void addDiscountAmount(Integer amount){
        this.totalDiscount+=amount;
    }
    public void addAmount(Integer amount){
        this.totalAmountCollected+=amount;
    }
    public void addPassenger(PassengerType passengerType){
        if(passengerMap.containsKey(passengerType)){
            passengerMap.put(passengerType,passengerMap.get(passengerType)+1);
        }else {
            passengerMap.put(passengerType,1);
        }
    }
    public Station getStation() {
        return station;
    }
    public Integer getTotalDiscountAmountCollected() {
        return totalDiscount;
    }

    public Integer getTotalAmountCollected() {
        return totalAmountCollected;
    }

    public Map<PassengerType, Integer> getPassengerMap() {
        return passengerMap;
    }

    @Override
    public String toString() {
        return "MetroStation{" +
                "station=" + station +
                ", totalAmountCollected=" + totalAmountCollected +
                ", passengerMap=" + passengerMap +
                '}';
    }
}
