package com.geektrust.backend.dto;

import com.geektrust.backend.comparator.PassengerMapComparator;
import com.geektrust.backend.entites.PassengerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MetroSummaryDTO {
       private String station;
        private  int totalAmt;
        private int discount;
        private Map<PassengerType,Integer> passengerTypemap;

        public MetroSummaryDTO(String station, int totalAmt, int discount, Map<PassengerType, Integer> passengerTypemap) {
                this.station = station;
                this.totalAmt = totalAmt;
                this.discount = discount;
                this.passengerTypemap = passengerTypemap;
        }

        public String getStation() {
                return station;
        }

        public int getTotalAmt() {
                return totalAmt;
        }

        public int getDiscount() {
                return discount;
        }

        public Map<PassengerType, Integer> getPassengerTypemap() {
                return passengerTypemap;
        }

        @Override
        public String toString() {
                StringBuilder summaryBuilder = new StringBuilder();

                summaryBuilder.append("TOTAL_COLLECTION ")
                        .append(station).append(" ")
                        .append(totalAmt).append(" ")
                        .append(discount).append("\n");

            List<Map.Entry<PassengerType, Integer>> sortPassengerTypes = new ArrayList<>(passengerTypemap.entrySet());
//            sortedPassengerTypes.sort((entry1, entry2) -> {
//                int countComparison = entry2.getValue().compareTo(entry1.getValue());
//                if (countComparison == 0) {
//                    // If counts are the same, sort by passenger type in ascending order
//
//                    return entry1.getKey().name().compareTo(entry2.getKey().name());
//                }
//                return countComparison;
//            });
            PassengerMapComparator passengerMapComparator=new PassengerMapComparator();
            Collections.sort(sortPassengerTypes,passengerMapComparator);

                for (Map.Entry<PassengerType, Integer> entry : sortPassengerTypes) {
                        summaryBuilder.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
                }

                return summaryBuilder.toString();
        }

}
