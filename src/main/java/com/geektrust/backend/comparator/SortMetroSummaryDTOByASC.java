package com.geektrust.backend.comparator;

import com.geektrust.backend.dto.MetroSummaryDTO;

import java.util.Comparator;

public class SortMetroSummaryDTOByASC implements Comparator<MetroSummaryDTO> {
    @Override
    public int compare(MetroSummaryDTO o1, MetroSummaryDTO o2) {
        return o1.getStation().compareTo(o2.getStation());
    }
}
