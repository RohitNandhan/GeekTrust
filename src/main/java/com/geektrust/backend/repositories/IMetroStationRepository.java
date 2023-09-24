package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.MetroStation;
import com.geektrust.backend.entites.PassengerType;
import com.geektrust.backend.entites.Station;

import java.util.Map;

public interface IMetroStationRepository {
    MetroStation saveMetroStation(Station station);

    void addPassenger(Station fromStation, PassengerType passengerType);

    void setJourneyType(Station fromStation, String cardId);

    void addCollectedAmount(Station fromStation, Integer amount);

    Map<PassengerType,Integer> getPassengers(Station station);

    MetroStation getMetroStation(Station station);
    Integer getTotalAmount(Station station);
}
