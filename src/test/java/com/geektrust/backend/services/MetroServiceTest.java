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
    private IMetroService metroService;
    private IMetroRepository metroRepository;


    @BeforeEach
    public void  setUp() {
        this.metroCardRepository = new MetroCardRepository();
        this.metroRepository=new MetroRepository();
        metroService=new MetroService(metroCardRepository,metroRepository);
    }
    @Test
    public void metroCheckInTest(){
        String fromStation="CENTRAL";
        String fromStation1="AIRPORT";

        String passenger="ADULT";
        String passenger2="SENIOR_CITIZEN";
        String passenger3="KID";

        metroCardRepository.addCard("1",600);
        metroCardRepository.addCard("2",500);
        metroCardRepository.addCard("3",50);
        metroCardRepository.addCard("4",50);
        metroCardRepository.addCard("5",200);
        metroService.checkInService("1",passenger,fromStation); //200
        metroService.checkInService("2",passenger2,fromStation); //100
        metroService.checkInService("1",passenger,fromStation1);//100
        metroService.checkInService("3",passenger3,fromStation1);//2005
        metroService.checkInService("4",passenger,fromStation1);//50
        metroService.checkInService("5",passenger3,fromStation1);//50

        List<MetroSummaryDTO> list=metroService.printSummary();
        list.forEach(metroSummaryDTO -> {
            System.out.print(metroSummaryDTO.toString());
        });
    }
    @Test
    public void metroCheckInTest2(){
        String fromStation="CENTRAL";
        String fromStation1="AIRPORT";

        String passenger="ADULT";
        String passenger2="SENIOR_CITIZEN";
        String passenger3="KID";

        metroCardRepository.addCard("1",400);
        metroCardRepository.addCard("2",100);
        metroCardRepository.addCard("3",50);
        metroCardRepository.addCard("4",50);
        metroCardRepository.addCard("5",200);
        metroService.checkInService("1",passenger2,fromStation1); //200
        metroService.checkInService("2",passenger3,fromStation1); //100
        metroService.checkInService("3",passenger,fromStation);//100
        metroService.checkInService("1",passenger2,fromStation);//2005
        metroService.checkInService("3",passenger,fromStation1);//50
        metroService.checkInService("3",passenger,fromStation);//50

        List<MetroSummaryDTO> list=metroService.printSummary();
        list.forEach(metroSummaryDTO -> {
            System.out.print(metroSummaryDTO.toString());
        });
    }




}