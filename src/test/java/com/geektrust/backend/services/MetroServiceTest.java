package com.geektrust.backend.services;

import com.geektrust.backend.dto.MetroSummaryDTO;
import com.geektrust.backend.entites.MetroCard;
import com.geektrust.backend.entites.PassengerType;
import com.geektrust.backend.entites.Station;
import com.geektrust.backend.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class MetroServiceTest {
    private IMetroCardRepository metroCardRepository;
    private IMetroStationRepository metroStationRepository;
    private IMetroService metroService;
    private IMetroRepository metroRepository;


    @BeforeEach
    public void  setUp() {
        this.metroCardRepository = new MetroCardRepository();
        this.metroRepository=new MetroRepository();
      MetroCard metroCard = metroCardRepository.addCard(new MetroCard("1",200));
//        MetroCard metroCard1 =   metroCardRepository.addCard(new MetroCard("2",500));
//        MetroCard metroCard2 =   metroCardRepository.addCard(new MetroCard("3",300));
//        MetroCard metroCard3 =  metroCardRepository.addCard(new MetroCard("4",50));
        metroCardRepository.addCard("1",600);
        metroCardRepository.addCard("2",500);
        metroCardRepository.addCard("3",50);
        metroCardRepository.addCard("4",50);
        metroCardRepository.addCard("5",200);
        metroService=new MetroService(metroCardRepository,metroRepository);
      //  metroRepository.saveMetro(Station.CENTRAL,metroCard);

       // metroRepository.saveMetroStation();
    }
    @Test
    public void metroCheckInTest(){
        String fromStation="CENTRAL";
        String fromStation1="AIRPORT";
        String passenger="ADULT";
        String passenger2="SENIOR_CITIZEN";
        String passenger4="ADULT";
        String passenger3="KID";
        metroService.checkInService("1",passenger,fromStation); //200
        metroService.checkInService("2",passenger2,fromStation); //100
        metroService.checkInService("1",passenger,fromStation1);//100
        metroService.checkInService("3",passenger3,fromStation1);//2005
        metroService.checkInService("4",passenger4,fromStation1);//50
        metroService.checkInService("5",passenger3,fromStation1);//50

//        System.out.println(metroRepository.getTotalAmount(Station.valueOf(fromStation)));
//        System.out.println(metroRepository.getTotalAmount(Station.valueOf(fromStation1)));
//        System.out.println(metroRepository.getPassengers(Station.valueOf(fromStation)));
//        System.out.println(metroRepository.getPassengers(Station.valueOf(fromStation1)));
//
        List<MetroSummaryDTO> list=metroService.printSummary();
        list.forEach(metroSummaryDTO -> {
            System.out.print(metroSummaryDTO.toString());
        });
    }

    @Test
    public void checkInServiceTest() {
        String fromStation="CENTRAL";
        String passenger="ADULT";
        PassengerType passengerType=PassengerType.valueOf(passenger);
        Station station=Station.valueOf(fromStation);
        metroStationRepository.saveMetroStation(station);
        metroStationRepository.addPassenger(Station.valueOf(fromStation),passengerType);
        metroStationRepository.addCollectedAmount(station,passengerType.getPrice());


        metroStationRepository.saveMetroStation(station);
        metroStationRepository.addPassenger(Station.valueOf(fromStation),PassengerType.KID);
        metroStationRepository.addCollectedAmount(station,PassengerType.KID.getPrice());

        metroStationRepository.saveMetroStation(station);
        metroStationRepository.addPassenger(Station.valueOf(fromStation),PassengerType.SENIOR_CITIZEN);
        metroStationRepository.addCollectedAmount(station,PassengerType.SENIOR_CITIZEN.getPrice());

        int total=metroStationRepository.getTotalAmount(station);
        Map<PassengerType,Integer> map =metroStationRepository.getPassengers(station);
        System.out.println(map);
        System.out.println(total);
    }


}