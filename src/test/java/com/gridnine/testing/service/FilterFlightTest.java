package com.gridnine.testing.service;

import java.time.format.DateTimeFormatter;

public class FilterFlightTest {

    protected AbstractFlightFilter flightFilter;

    protected final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    protected String departureDateExpected;

    protected String arrivalDateExpected;

    protected String departureDateActual;

    protected String arrivalDateActual;

}
