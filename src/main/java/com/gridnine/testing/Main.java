package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.Filter;
import com.gridnine.testing.service.FilterFlightArrivalBeforeDeparture;
import com.gridnine.testing.service.FilterFlightDepartureBeforeCurrentTime;
import com.gridnine.testing.service.FilterFlightOnTheGroundBiggerThanXHours;
import com.gridnine.testing.util.FilterDescription;
import com.gridnine.testing.util.FlightBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        List<Filter> filterFlightList = new ArrayList<>(List.of(
                new FilterFlightDepartureBeforeCurrentTime(flights),
                new FilterFlightArrivalBeforeDeparture(flights),
                new FilterFlightOnTheGroundBiggerThanXHours(flights)
        ));

        FilterDescription description = FilterDescription.getInstance();

        for (Filter filter : filterFlightList) {
            description.getDescription(filter.getClass());
            filter.filtration();
        }
    }
}
