package com.gridnine.testing.constant;

public interface FilterFlightConstant {

    class Description {
        public final static String BEFORE_CURRENT = "Вылет до текущего момента времени:";
        public final static String ARRIVED_BEFORE_DEPARTURE = "Сегменты с датой прилета раньше даты вылета:";
        public final static String MORE_THAN_TWO_HOUR_ON_THE_GROUND = "Общее время на земле больше указанного:";
    }

    class Data {
        public final static Integer DEFAULT_HOURS_AFTER_ARRIVAL = 2;
    }
}
