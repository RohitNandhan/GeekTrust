package com.geektrust.backend.comparator;

import com.geektrust.backend.entites.PassengerType;

import java.util.Comparator;
import java.util.Map;

public class PassengerMapComparator implements Comparator<Map.Entry<PassengerType,Integer>>{

    @Override
    public int compare(Map.Entry<PassengerType, Integer> o1, Map.Entry<PassengerType, Integer> o2) {
        int valueComparison = o2.getValue().compareTo(o1.getValue());
        // If values are equal, compare by keys
        if (valueComparison == 0) {
            return o1.getKey().name().compareTo(o2.getKey().name());
        }
            return valueComparison;
    }
}
