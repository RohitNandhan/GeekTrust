//package com.geektrust.backend.services;
//
//import com.geektrust.backend.dto.MetroSummaryDTO;
//import com.geektrust.backend.entites.*;
//import com.geektrust.backend.repositories.IMetroCardRepository;
//import com.geektrust.backend.repositories.IMetroRepository;
//import com.geektrust.backend.repositories.IMetroStationRepository;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class MetroServiceD implements IMetroService{
//
//    private final IMetroCardRepository metroCardRepository;
//    private final IMetroStationRepository metroStationRepository;
//    private final IMetroRepository metroRepository;
//
//    public MetroServiceD(IMetroCardRepository metroCardRepository, IMetroStationRepository metroStationRepository, IMetroRepository metroRepository) {
//        this.metroCardRepository = metroCardRepository;
//        this.metroStationRepository = metroStationRepository;
//        this.metroRepository = metroRepository;
//    }
//
////    @Override
////    public void checkInService(String cardId, String passenger, String fromStation) {
////            PassengerType passengerType=PassengerType.valueOf(passenger);
////            Station station=Station.valueOf(fromStation);
////            //metroRepository
////            metroStationRepository.saveMetroStation(station);
////            metroStationRepository.addPassenger(Station.valueOf(fromStation),passengerType);
////            metroStationRepository.setJourneyType(station,cardId);
////            metroStationRepository.addCollectedAmount(station,passengerType.getPrice());
////    }
//   // @Override
////    public void checkInServiceD(String cardId, String passenger, String fromStation) {
////        PassengerType passengerType = PassengerType.valueOf(passenger);
////        Station station = Station.valueOf(fromStation);
////        MetroCard metroCard = metroCardRepository.getCardByCardId(cardId);
////
////        //MetroStation metroStation=metroStationRepository.saveMetroStation(station);
////        metroRepository.saveMetro(station, metroCard);
////        metroRepository.addPassenger(Station.valueOf(fromStation), passengerType);
////        metroRepository.setJourneyType(station, cardId);
////        int amount;
////        if(metroRepository.getJourneyType(station, cardId).equals(JourneyType.RETURN)) amount= passengerType.getPrice()/2;
////        else amount= passengerType.getPrice();
////        //  int amount = (metroRepository.getJourneyType(station, cardId).equals(JourneyType.RETURN)) ? passengerType.getPrice() / 2 : passengerType.getPrice();
////       // metroRepository.getMetroStation(station).addDiscountAmount(passengerType.getPrice()-amount);
////        if (metroCard.getBalance() >= amount) {
////            metroRepository.addCollectedAmount(station, amount);
////            metroCardRepository.deductCardBalance(cardId, amount);
////        }else{
////            double interest=0.02;
////            int requiredAmount=amount-metroCard.getBalance();
////            amount+=(int)(requiredAmount*interest);
////            metroCard.addBalance(amount);
////            metroRepository.addCollectedAmount(station, amount);
////            metroCardRepository.deductCardBalance(cardId, amount);
////        }
////
////    }
//    @Override
//    public void checkInService(String cardId, String passenger, String fromStation) {
//        PassengerType passengerType = PassengerType.valueOf(passenger);
//        Station station = Station.valueOf(fromStation);
//        MetroCard metroCard = metroCardRepository.getCardByCardId(cardId);
//        metroRepository.saveMetro(station, metroCard);
//        JourneyType journeyType = metroRepository.getJourneyType(station, cardId);
//        metroRepository.saveMetro(station, metroCard);
//        int baseAmount = passengerType.getPrice();
//        if (journeyType.equals(JourneyType.RETURN)) {
//            baseAmount /= 2;
//            metroRepository.addDiscountAmount(station,baseAmount);
//        }
//
//        int totalAmount = calculateTotalAmount(metroCard, baseAmount);
//
//        if (metroCard.getBalance() < totalAmount) {
//            applyInterestAndAddBalance(metroCard, totalAmount);
//        }
//
//        metroRepository.addPassenger(station, passengerType);
//        metroRepository.setJourneyType(station, cardId);
//        metroRepository.addCollectedAmount(station, totalAmount);
//        metroCardRepository.deductCardBalance(cardId, totalAmount);
//    }
//
//    private int calculateTotalAmount(MetroCard metroCard, int baseAmount) {
//        if (metroCard.getBalance() >= baseAmount) {
//            return baseAmount;
//        } else {
//            double interestRate = 0.02;
//            int requiredAmount = baseAmount - metroCard.getBalance();
//            int additionalAmount = (int) (requiredAmount * interestRate);
//           // metroCard.addBalance(additionalAmount);
//            return baseAmount + additionalAmount;
//        }
//    }
//    private void applyInterestAndAddBalance(MetroCard metroCard, int totalAmount) {
//        //double interestRate = 0.02;
//        int requiredAmount = totalAmount - metroCard.getBalance();
//      //  int additionalAmount = (int) (requiredAmount * interestRate);
//        metroCard.addBalance(requiredAmount);
//    }
////   // @Override
////    public List<MetroSummaryDTO> printf(){
////        List<MetroSummaryDTO> metroSummaryDTOList=new ArrayList<>();
////        metroRepository.getMetrolist().stream().forEach(metro -> {
////            metroSummaryDTOList.add(new MetroSummaryDTO(
////                    getMetroStation(metro).getStation().toString(),
////                    getMetroStation(metro).getTotalAmountCollected(),
////                    getMetroStation(metro).getTotalDiscountAmountCollected(),
////                    getMetroStation(metro).getPassengerMap()
////                    ));
////        });
////        return sortListByStation(metroSummaryDTOList);
////    }
//
//    public MetroStation getMetroStation(Metro metro){
//        return metro.getMetroStation();
//    }
//
//    private List<MetroSummaryDTO> sortListByStation(List<MetroSummaryDTO> metroSummaryDTOList){
//     return metroSummaryDTOList.stream()
//             .sorted(((o1, o2) ->
//                     o2.getStation().compareTo(o1.getStation()))).collect(Collectors.toList());
//    }
//    @Override
//    public List<MetroSummaryDTO> print() {
//        List<MetroSummaryDTO> metroSummaryDTOList = metroRepository.getMetrolist()
//                .stream()
//                .map(metro -> createMetroSummaryDTO(metro))
//                .collect(Collectors.toList());
//
//        return sortListByStation(metroSummaryDTOList);
//    }
//
//    private MetroSummaryDTO createMetroSummaryDTO(Metro metro) {
//        MetroStation metroStation = getMetroStation(metro);
//        return new MetroSummaryDTO(
//                getStation(metroStation),
//                getTotalAmount(metroStation),
//                getTotalDiscount(metroStation),
//                getPassengerMap(metroStation)
//        );
//    }
//    private Integer getTotalDiscount(MetroStation metroStation){
//       return metroStation.getTotalDiscountAmountCollected();
//    }
//    private Integer getTotalAmount(MetroStation metroStation){
//        return metroStation.getTotalAmountCollected();
//    }
//    private String getStation(MetroStation metroStation){
//        return metroStation.getStation().toString();
//    }
//    private Map<PassengerType,Integer> getPassengerMap(MetroStation metroStation){
//        return metroStation.getPassengerMap();
//    }
//
//
////    private List<MetroSummaryDTO> sortListByStation(List<MetroSummaryDTO> summaryList) {
////        return summaryList.stream()
////                .sorted(Comparator.comparing(MetroSummaryDTO::getStation))
////                .collect(Collectors.toList());
////    }
//
//
//
////    private getJourneyCost()
//}
