package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gridnine.testing.constant.FlightConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FilterFlightArrivalBeforeDepartureTest extends FilterFlightTest {

    @Test
    public void thereIsOneSegmentWhereArrivalBeforeDeparture() {
        initFilter(ONE_SEGMENT_WHERE_ARRIVAL_BEFORE_DEPARTURE);
        departureDateActual = formatter.format(flightFilter.filteredSegments.get(0).getDepartureDate());
        arrivalDateActual = formatter.format(flightFilter.filteredSegments.get(0).getArrivalDate());
        departureDateExpected = formatter.format(SEGMENT_1.getDepartureDate());
        arrivalDateExpected = formatter.format(SEGMENT_1.getArrivalDate());

        assertEquals(flightFilter.getFilteredResult().size(), 1);
        assertEquals(departureDateExpected, departureDateActual);
        assertEquals(arrivalDateExpected, arrivalDateActual);
    }

    @Test
    public void thereIsNoOneSegmentWhereArrivalBeforeDeparture() {
        initFilter(NO_ONE_SEGMENT_WHERE_ARRIVAL_BEFORE_DEPARTURE);

        assertTrue(flightFilter.getFilteredResult().isEmpty());
    }

    @Test
    public void emptyResultWithEmptyData() {
        initFilter(EMPTY_LIST);

        assertTrue(flightFilter.getFilteredResult().isEmpty());
    }

    private void initFilter(List<Flight> flights) {
        flightFilter = new FilterFlightArrivalBeforeDeparture(flights);
        flightFilter.filter();
    }
}