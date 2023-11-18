package com.gridnine.testing.constant;

import static com.gridnine.testing.constant.FilterFlightConstant.Data.HOURS_AFTER_ARRIVAL;

public interface FilterFlightConstant {

    class Description {
        public final static String BEFORE_CURRENT = "Вылет до текущего момента времени:";
        public final static String ARRIVED_BEFORE_DEPARTURE = "Сегменты с датой прилета раньше даты вылета:";
        public final static String MORE_THAN_TWO_HOUR_ON_THE_GROUND =
                "Общее время, проведенное на земле, превышает " +  HOURS_AFTER_ARRIVAL + " часа:";
    }

    class Data {
        public final static Integer HOURS_AFTER_ARRIVAL = 2;
    }

    class Other {
        public final static String DELIMITER = "-------------------------------------------------------------";
    }


}
