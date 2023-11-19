package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.List;

import static com.gridnine.testing.constant.FilterFlightConstant.Data.DEFAULT_HOURS_AFTER_ARRIVAL;

/**
 * This class has a constructor that accepts the number of hours and performs calculations relative to this parameter.
 * Default time value is 2 hours
 */
public final class FilterFlightOnTheGroundBiggerThanXHours extends AbstractFlightFilter {

    private final int hours;

    public FilterFlightOnTheGroundBiggerThanXHours(List<Flight> flights) {
        super(flights);
        this.hours = DEFAULT_HOURS_AFTER_ARRIVAL;
    }

    public FilterFlightOnTheGroundBiggerThanXHours(List<Flight> flights, int hours) {
        super(flights);
        this.hours = hours > 0 ? hours : DEFAULT_HOURS_AFTER_ARRIVAL;
    }

    public void filterSegments(final Flight flight) {
        List<Segment> segments = flight.getSegments();
        for (int i = 0; segments.size() > 1 && i < segments.size() - 1; i++) {
            if (segments.get(i).getArrivalDate().plusHours(hours).isBefore(segments.get(i + 1).getDepartureDate())) {
                filteredSegments.add(segments.get(i));
                filteredSegments.add(segments.get(i + 1));
            }
        }
    }
}
