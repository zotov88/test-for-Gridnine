package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.gridnine.testing.constant.FilterFlightConstant.Other.DELIMITER;

public final class FilterFlightDepartureBeforeCurrentTime extends AbstractFlightFilter {

    private final List<Segment> pastSegmentsList = new ArrayList<>();

    public FilterFlightDepartureBeforeCurrentTime(List<Flight> flights) {
        super(flights);
    }

    @Override
    public void filtration() {
        for (Flight flight : flights) {
            checkSegments(flight);
        }
        showPastSegments();
    }

    private void checkSegments(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                pastSegmentsList.add(segment);
            }
        }
    }

    private void showPastSegments() {
        for (Segment segment : pastSegmentsList) {
            System.out.println(segment);
        }
        System.out.println(DELIMITER);
    }
}
