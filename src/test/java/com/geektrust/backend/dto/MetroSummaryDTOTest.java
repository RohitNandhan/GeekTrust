package com.geektrust.backend.dto;

import com.geektrust.backend.entites.PassengerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MetroSummaryDTOTest {
    MetroSummaryDTO metroSummaryDTO;
    Map<PassengerType, Integer> map;

    @BeforeEach
    void setUp(){
        map = new HashMap<PassengerType, Integer>() {{
            put(PassengerType.ADULT, 2);
            put(PassengerType.KID, 2);
            put(PassengerType.SENIOR_CITIZEN, 2);
        }};
        metroSummaryDTO=new MetroSummaryDTO("AIRPORT",703,100,map);

    }
    @Test
    void dtoTest(){
        metroSummaryDTO=new MetroSummaryDTO("AIRPORT",703,100,map);
        System.out.println(metroSummaryDTO);
    }

}