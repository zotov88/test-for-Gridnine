package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;

public abstract class AbstractFlightFilter implements Filter {

    protected final List<Flight> flights;

    public AbstractFlightFilter(List<Flight> flights) {
        this.flights = flights;
    }

}
