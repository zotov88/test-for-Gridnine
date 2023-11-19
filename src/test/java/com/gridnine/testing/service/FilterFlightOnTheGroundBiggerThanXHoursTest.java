package com.gridnine.testing.service;

import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;

import static com.gridnine.testing.constant.FlightConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FilterFlightOnTheGroundBiggerThanXHoursTest extends FilterFlightTest {

    @Test
    public void thereIsTwoIntervalsOnTheGroundBiggerTwoHours() {
        flightFilter = new FilterFlightOnTheGroundBiggerThanXHours(TWO_SEGMENTS_WHERE_ON_THE_GROUND_3_AND_4_HOURS);
        flightFilter.filter();
        departureDateActual = formatter.format(flightFilter.getFilteredResult().get(0).getArrivalDate());
        arrivalDateActual = formatter.format(flightFilter.getFilteredResult().get(1).getDepartureDate());
        departureDateExpected = formatter.format(SEGMENT_3.getArrivalDate());
        arrivalDateExpected = formatter.format(SEGMENT_4.getDepartureDate());

        long hoursBetweenActual = ChronoUnit.HOURS.between(
                flightFilter.getFilteredResult().get(0).getArrivalDate(),
                flightFilter.getFilteredResult().get(1).getDepartureDate());
        long hoursBetweenExpected = ChronoUnit.HOURS.between(
                SEGMENT_3.getArrivalDate(),
                SEGMENT_4.getDepartureDate());

        assertEquals(flightFilter.getFilteredResult().size(), 4);
        assertEquals(departureDateExpected, departureDateActual);
        assertEquals(arrivalDateExpected, arrivalDateActual);
        assertEquals(hoursBetweenActual, hoursBetweenExpected);
    }

    @Test
    public void thereIsOneIntervalOnTheGroundBiggerThreeHours() {
        flightFilter = new FilterFlightOnTheGroundBiggerThanXHours(TWO_SEGMENTS_WHERE_ON_THE_GROUND_3_AND_4_HOURS, 3);
        flightFilter.filter();
        departureDateActual = formatter.format(flightFilter.getFilteredResult().get(0).getDepartureDate());
        arrivalDateActual = formatter.format(flightFilter.getFilteredResult().get(1).getArrivalDate());
        departureDateExpected = formatter.format(SEGMENT_5.getDepartureDate());
        arrivalDateExpected = formatter.format(SEGMENT_6.getArrivalDate());

        long hoursBetweenActual = ChronoUnit.HOURS.between(
                flightFilter.getFilteredResult().get(0).getDepartureDate(),
                flightFilter.getFilteredResult().get(1).getArrivalDate()
        );
        long hoursBetweenExpected = ChronoUnit.HOURS.between(
                SEGMENT_5.getDepartureDate(), SEGMENT_6.getArrivalDate()
        );

        assertEquals(flightFilter.getFilteredResult().size(), 2);
        assertEquals(departureDateExpected, departureDateActual);
        assertEquals(arrivalDateExpected, arrivalDateActual);
        assertEquals(hoursBetweenActual, hoursBetweenExpected);
    }

    @Test
    public void thereIsNoOneIntervalOnTheGroundBiggerFourHours() {
        flightFilter = new FilterFlightOnTheGroundBiggerThanXHours(TWO_SEGMENTS_WHERE_ON_THE_GROUND_3_AND_4_HOURS, 4);
        flightFilter.filter();

        assertTrue(flightFilter.getFilteredResult().isEmpty());
    }

    @Test
    public void emptyResultWithEmptyData() {
        flightFilter = new FilterFlightOnTheGroundBiggerThanXHours(EMPTY_LIST, 1);
        flightFilter.filter();

        assertTrue(flightFilter.getFilteredResult().isEmpty());
    }
}