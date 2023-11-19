package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFlightFilter implements FlightFilter {

    protected final List<Flight> flights;
    protected final List<Segment> filteredSegments;

    public AbstractFlightFilter(List<Flight> flights) {
        this.flights = flights;
        filteredSegments = new ArrayList<>();
    }

    @Override
    public void filter() {
        for (Flight flight : flights) {
            filterSegments(flight);
        }
    }

    @Override
    public List<Segment> getFilteredResult() {
        return new ArrayList<>(filteredSegments);
    }

    public abstract void filterSegments(final Flight flight);

}
