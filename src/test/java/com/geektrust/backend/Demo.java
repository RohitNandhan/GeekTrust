package com.geektrust.backend;

import com.geektrust.backend.entites.PassengerType;
import com.geektrust.backend.entites.Station;
import com.geektrust.backend.repositories.IMetroCardRepository;
import com.geektrust.backend.repositories.IMetroStationRepository;
import com.geektrust.backend.repositories.MetroCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Demo {
    private  IMetroCardRepository metroCardRepository;
    private  IMetroStationRepository metroStationRepository;

    public Demo() {
    }

    @BeforeEach
    public void  setUp() {
        this.metroCardRepository = new MetroCardRepository();
    }
}
