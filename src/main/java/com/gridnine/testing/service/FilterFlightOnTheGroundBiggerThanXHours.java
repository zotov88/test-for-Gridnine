package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.ArrayList;
import java.util.List;

import static com.gridnine.testing.constant.FilterFlightConstant.Data.HOURS_AFTER_ARRIVAL;
import static com.gridnine.testing.constant.FilterFlightConstant.Other.DELIMITER;

public final class FilterFlightOnTheGroundBiggerThanXHours extends AbstractFlightFilter {

    private final List<List<Segment>> moreTwoHoursList = new ArrayList<>();

    public FilterFlightOnTheGroundBiggerThanXHours(List<Flight> flights) {
        super(flights);
    }

    @Override
    public void filtration() {
        for (Flight flight : flights) {
            checkSegments(flight);
        }
        showSegments();
    }

    private void checkSegments(Flight flight) {
        List<Segment> segments = flight.getSegments();
        for (int i = 0; segments.size() > 1 && i < segments.size() - 1; i++) {
            if (segments.get(i).getArrivalDate().plusHours(HOURS_AFTER_ARRIVAL).isBefore(segments.get(i + 1).getDepartureDate())) {
                moreTwoHoursList.add(List.of(segments.get(i), segments.get(i + 1)));
            }
        }
    }

    private void showSegments() {
        for (List<Segment> segments : moreTwoHoursList) {
            System.out.println(segments);
        }
        System.out.println(DELIMITER);
    }
}
