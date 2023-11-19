package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.List;

public final class FilterFlightDepartureBeforeCurrentTime extends AbstractFlightFilter {

    public FilterFlightDepartureBeforeCurrentTime(List<Flight> flights) {
        super(flights);
    }

    public void filterSegments(final Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                filteredSegments.add(segment);
            }
        }
    }

}
