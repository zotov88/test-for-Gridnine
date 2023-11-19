package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.List;

public final class FilterFlightArrivalBeforeDeparture extends AbstractFlightFilter {

    public FilterFlightArrivalBeforeDeparture(List<Flight> flights) {
        super(flights);
    }

    public void filterSegments(final Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                filteredSegments.add(segment);
            }
        }
    }

}
