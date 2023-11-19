package com.gridnine.testing.util;

import com.gridnine.testing.service.FilterFlightArrivalBeforeDeparture;
import com.gridnine.testing.service.FilterFlightDepartureBeforeCurrentTime;
import com.gridnine.testing.service.FilterFlightOnTheGroundBiggerThanXHours;
import com.gridnine.testing.service.FlightFilter;

import java.util.HashMap;
import java.util.Map;

import static com.gridnine.testing.constant.FilterFlightConstant.Description.*;

public final class FilterDescription {

    private static FilterDescription filterDescription;
    private static Map<Class<? extends FlightFilter>, String> descriptionMap;

    private FilterDescription() {
    }

    public static FilterDescription getInstance() {
        if (filterDescription == null) {
            filterDescription = new FilterDescription();
        }
        return filterDescription;
    }

    public void getDescription(Class<? extends FlightFilter> clazz) {
        if (descriptionMap == null) {
            init();
        }
        System.out.println(descriptionMap.get(clazz));
    }

    private static void init() {
        descriptionMap = new HashMap<>();
        descriptionMap.put(FilterFlightDepartureBeforeCurrentTime.class, BEFORE_CURRENT);
        descriptionMap.put(FilterFlightArrivalBeforeDeparture.class, ARRIVED_BEFORE_DEPARTURE);
        descriptionMap.put(FilterFlightOnTheGroundBiggerThanXHours.class, MORE_THAN_TWO_HOUR_ON_THE_GROUND);
    }
}
