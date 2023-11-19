package com.gridnine.testing.service;

import com.gridnine.testing.model.Segment;

import java.util.List;

public interface FlightFilter {

    void filter();

    List<Segment> getFilteredResult();
}
