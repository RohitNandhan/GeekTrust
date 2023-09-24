package com.geektrust.backend.comparator;

import com.geektrust.backend.dto.MetroSummaryDTO;

import java.util.Comparator;

public class SortMetroSummaryDTOByDSC implements Comparator<MetroSummaryDTO> {
    @Override
    public int compare(MetroSummaryDTO o1, MetroSummaryDTO o2) {
        return o2.getStation().compareTo(o1.getStation());
    }
}
