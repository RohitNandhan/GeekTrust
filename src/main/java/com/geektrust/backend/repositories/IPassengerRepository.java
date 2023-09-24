package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.Passenger;
import com.geektrust.backend.entites.PassengerType;
import com.geektrust.backend.entites.Station;

import java.util.List;

public interface IPassengerRepository {
    List<Integer> getAllPassengerByType(PassengerType passengerType);
    List getPassengerByStation(Station station);
    void addPassenger(PassengerType passengerType,Station station);

}
