package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static com.gridnine.testing.constant.FlightConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FilterFlightDepartureBeforeCurrentTimeTest extends FilterFlightTest {

    @Test
    public void thereAreTwoSegmentsBeforeCurrentTime() {
        initFilter(TWO_SEGMENT_BEFORE_CURRENT_TIME);
        departureDateActual = formatter.format(flightFilter.filteredSegments.get(0).getDepartureDate());
        departureDateExpected = formatter.format(SEGMENT_2.getDepartureDate());
        arrivalDateActual = formatter.format(flightFilter.filteredSegments.get(0).getArrivalDate());
        arrivalDateExpected = formatter.format(SEGMENT_2.getArrivalDate());

        assertEquals(flightFilter.getFilteredResult().size(), 2);
        assertEquals(departureDateExpected, departureDateActual);
        assertEquals(arrivalDateExpected, arrivalDateActual);
        assertTrue(flightFilter.getFilteredResult().get(1).getDepartureDate().isBefore(LocalDateTime.now()));
    }

    @Test
    public void thereIsNoOneSegmentBeforeCurrentTime() {
        initFilter(NO_ONE_SEGMENT_BEFORE_CURRENT_TIME);

        assertTrue(flightFilter.getFilteredResult().isEmpty());
    }

    @Test
    public void emptyResultWithEmptyData() {
        initFilter(EMPTY_LIST);

        assertTrue(flightFilter.getFilteredResult().isEmpty());
    }

    private void initFilter(List<Flight> flights) {
        flightFilter = new FilterFlightDepartureBeforeCurrentTime(flights);
        flightFilter.filter();
    }

}