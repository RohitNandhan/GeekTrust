package com.geektrust.backend.services;

import com.geektrust.backend.repositories.IMetroCardRepository;
import com.geektrust.backend.repositories.IMetroRepository;
import com.geektrust.backend.repositories.IMetroStationRepository;

public class PrintSummaryService {
    private final IMetroCardRepository metroCardRepository;
    private final IMetroStationRepository metroStationRepository;
    private final IMetroRepository metroRepository;

    public PrintSummaryService(IMetroCardRepository metroCardRepository, IMetroStationRepository metroStationRepository, IMetroRepository metroRepository) {
        this.metroCardRepository = metroCardRepository;
        this.metroStationRepository = metroStationRepository;
        this.metroRepository = metroRepository;
    }
//    public PrintSummaryDTO print(){
//
//    }

}
