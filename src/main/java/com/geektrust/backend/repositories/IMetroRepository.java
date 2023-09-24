package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.*;

import java.util.List;
import java.util.Map;

public interface IMetroRepository {

    void saveMetro(Station station, Metro metro);

//    void saveMetroStation(Station station, MetroCard metroCard);

    void saveMetro(Station station, MetroCard metroCard);

    void addPassenger(Station fromStation, PassengerType passengerType);

    List<Metro> getMetrolist();

    MetroCard getMetroCardById(Station station, String cardId);

    JourneyType getJourneyType(Station station, String cardId);

    void setJourneyType(Station fromStation, String cardId);

    void addCollectedAmount(Station fromStation, Integer amount);

    void addDiscountAmount(Station fromStation, Integer amount);

    Map<PassengerType,Integer> getPassengers(Station station);

    MetroStation getMetroStation(Station station);

    Metro getMetro(Station station);

    Integer getTotalAmount(Station station);

    Integer getDiscountAmount(Station station);
}
