package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.ArrayList;
import java.util.List;

import static com.gridnine.testing.constant.FilterFlightConstant.Other.DELIMITER;

public final class FilterFlightArrivalBeforeDeparture extends AbstractFlightFilter {

    private final List<Segment> incorrectSegmentsList = new ArrayList<>();

    public FilterFlightArrivalBeforeDeparture(List<Flight> flights) {
        super(flights);
    }

    @Override
    public void filtration() {
        for (Flight flight : flights) {
            checkSegments(flight);
        }
        showIncorrectSegments();
    }

    private void checkSegments(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                incorrectSegmentsList.add(segment);
            }
        }
    }

    private void showIncorrectSegments() {
        for (Segment segment : incorrectSegmentsList) {
            System.out.println(segment);
        }
        System.out.println(DELIMITER);
    }
}
