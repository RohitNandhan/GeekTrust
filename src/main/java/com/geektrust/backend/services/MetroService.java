package com.geektrust.backend.services;

import com.geektrust.backend.comparator.SortMetroSummaryDTOByDSC;
import com.geektrust.backend.dto.MetroSummaryDTO;
import com.geektrust.backend.entites.*;
import com.geektrust.backend.repositories.IMetroCardRepository;
import com.geektrust.backend.repositories.IMetroRepository;

import java.util.*;
import java.util.stream.Collectors;

public class MetroService implements IMetroService{

    private final IMetroCardRepository metroCardRepository;
    private final IMetroRepository metroRepository;

    public MetroService(IMetroCardRepository metroCardRepository, IMetroRepository metroRepository) {
        this.metroCardRepository = metroCardRepository;
        this.metroRepository = metroRepository;
    }

    @Override
    public void checkInService(String cardId, String passenger, String fromStation) {
        PassengerType passengerType = PassengerType.valueOf(passenger);
        Station station = Station.valueOf(fromStation);
        MetroCard metroCard = metroCardRepository.getCardByCardId(cardId);

        metroRepository.saveMetro(station, metroCard);
        JourneyType journeyType = metroRepository.getJourneyType(station, cardId);

        int baseAmount = passengerType.getPrice();
        if (journeyType.equals(JourneyType.RETURN)) {
            baseAmount /= 2;
            metroRepository.addDiscountAmount(station,baseAmount);
        }

        int totalAmount = calculateTotalAmount(metroCard, baseAmount);

        metroRepository.addPassenger(station, passengerType);
        metroRepository.setJourneyType(station, cardId);
        metroRepository.addCollectedAmount(station, totalAmount);
        metroCardRepository.deductCardBalance(cardId, totalAmount);
    }

    private double getInterestRate(){
        double rate=2;
        return (rate/100);
    }

    private int calculateTotalAmount(MetroCard metroCard, int baseAmount) {
        int cardBalance=getCardBalance(metroCard);
        if (cardBalance >= baseAmount) {
            return baseAmount;
        } else {
            double interestRate = getInterestRate();
            int requiredAmount = baseAmount - cardBalance;
            int additionalAmount = (int) (requiredAmount * interestRate);
            int totalAmount=baseAmount + additionalAmount;

            applyInterestAndAddBalance(metroCard, totalAmount);
            return totalAmount;
        }
    }
    private void applyInterestAndAddBalance(MetroCard metroCard, int totalAmount) {
        int requiredAmount = totalAmount - getCardBalance(metroCard);
        metroCard.addBalance(requiredAmount);
    }

    private MetroStation getMetroStation(Metro metro){
        return metro.getMetroStation();
    }

    private List<MetroSummaryDTO> sortListByStation(List<MetroSummaryDTO> metroSummaryDTOList){
        SortMetroSummaryDTOByDSC sortMetroSummaryDTOByDSC = new SortMetroSummaryDTOByDSC();
        Collections.sort(metroSummaryDTOList,sortMetroSummaryDTOByDSC);
        return metroSummaryDTOList;
    }
    @Override
    public List<MetroSummaryDTO> printSummary() {
        List<MetroSummaryDTO> metroSummaryDTOList = metroRepository.getMetroList()
                .stream()
                .map(metro -> createMetroSummaryDTO(metro))
                .collect(Collectors.toList());

        return sortListByStation(metroSummaryDTOList);
    }

    private MetroSummaryDTO createMetroSummaryDTO(Metro metro) {
        MetroStation metroStation = getMetroStation(metro);
        return new MetroSummaryDTO(
                getStation(metroStation),
                getTotalAmount(metroStation),
                getTotalDiscount(metroStation),
                getPassengerMap(metroStation)
        );
    }
    private Integer getCardBalance(MetroCard metroCard){
       return metroCard.getBalance();
    }
    private Integer getTotalDiscount(MetroStation metroStation){
       return metroStation.getTotalDiscountAmountCollected();
    }
    private Integer getTotalAmount(MetroStation metroStation){
        return metroStation.getTotalAmountCollected();
    }
    private String getStation(MetroStation metroStation){
        return metroStation.getStation().toString();
    }
    private Map<PassengerType,Integer> getPassengerMap(MetroStation metroStation){
        return metroStation.getPassengerMap();
    }


}
