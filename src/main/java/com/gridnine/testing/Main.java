package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FilterFlightArrivalBeforeDeparture;
import com.gridnine.testing.service.FilterFlightDepartureBeforeCurrentTime;
import com.gridnine.testing.service.FilterFlightOnTheGroundBiggerThanXHours;
import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.util.FilterDescription;
import com.gridnine.testing.util.FlightBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.gridnine.testing.constant.FilterFlightConstant.Data.DEFAULT_HOURS_AFTER_ARRIVAL;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        List<FlightFilter> filterFlightList = new ArrayList<>(List.of(
                new FilterFlightDepartureBeforeCurrentTime(flights),
                new FilterFlightArrivalBeforeDeparture(flights),
                new FilterFlightOnTheGroundBiggerThanXHours(flights, DEFAULT_HOURS_AFTER_ARRIVAL)
        ));

        FilterDescription description = FilterDescription.getInstance();

        for (FlightFilter filter : filterFlightList) {
            description.getDescription(filter.getClass());
            filter.filter();
            for (Segment segment : filter.getFilteredResult()) {
                System.out.println(segment);
            }
            System.out.println();
        }

    }
}
