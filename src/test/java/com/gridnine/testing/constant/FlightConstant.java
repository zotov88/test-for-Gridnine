package com.gridnine.testing.constant;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightConstant {

    LocalDateTime NOW = LocalDateTime.now();

    List<Flight> ONE_SEGMENT_WHERE_ARRIVAL_BEFORE_DEPARTURE = List.of(
            new Flight(List.of(
                    new Segment(NOW, NOW.plusHours(9)),
                    new Segment(NOW.plusHours(10), NOW.plusHours(5)),
                    new Segment(NOW.plusHours(15), NOW.plusHours(19)))
            ),
            new Flight(List.of(
                    new Segment(NOW.minusDays(10), NOW.minusDays(9).minusHours(4)))
            ));

    Segment SEGMENT_1 = new Segment(NOW.plusHours(10), NOW.plusHours(5));

    List<Flight> EMPTY_LIST = List.of(new Flight(List.of()));

    List<Flight> NO_ONE_SEGMENT_WHERE_ARRIVAL_BEFORE_DEPARTURE = List.of(
            new Flight(List.of(
                    new Segment(NOW, NOW.plusHours(9)),
                    new Segment(NOW.plusHours(15), NOW.plusHours(19)))
            ),
            new Flight(List.of(
                    new Segment(NOW.minusDays(10), NOW.minusDays(9).minusHours(4)))
            ));

    List<Flight> TWO_SEGMENT_BEFORE_CURRENT_TIME = List.of(
            new Flight(List.of(
                    new Segment(NOW.minusDays(1), NOW.minusDays(1).plusHours(10)),
                    new Segment(NOW.minusDays(1).plusHours(12), NOW.minusDays(1).plusHours(14)),
                    new Segment(NOW.plusHours(1), NOW.plusHours(5)))
            ),
            new Flight(List.of(
                    new Segment(NOW.plusDays(3), NOW.plusDays(3).plusHours(6)))
            ));

    Segment SEGMENT_2 = new Segment(NOW.minusDays(1), NOW.minusDays(1).plusHours(10));

    List<Flight> NO_ONE_SEGMENT_BEFORE_CURRENT_TIME = List.of(
            new Flight(List.of(
                    new Segment(NOW.plusHours(1), NOW.plusHours(5)),
                    new Segment(NOW.plusHours(9), NOW.plusHours(14)))
            ),
            new Flight(List.of(
                    new Segment(NOW.plusDays(3), NOW.plusDays(3).plusHours(6)))
            ));

    List<Flight> TWO_SEGMENTS_WHERE_ON_THE_GROUND_3_AND_4_HOURS = List.of(
            new Flight(List.of(
                    new Segment(NOW, NOW.plusHours(2)),
                    new Segment(NOW.plusHours(5), NOW.plusHours(10)),
                    new Segment(NOW.plusHours(11), NOW.plusHours(13))
            )),
            new Flight(List.of(
                    new Segment(NOW, NOW.plusHours(2)),
                    new Segment(NOW.plusHours(3), NOW.plusHours(10)),
                    new Segment(NOW.plusHours(14), NOW.plusHours(16))
            ))
    );

    Segment SEGMENT_3 = TWO_SEGMENTS_WHERE_ON_THE_GROUND_3_AND_4_HOURS.get(0).getSegments().get(0);
    Segment SEGMENT_4 = TWO_SEGMENTS_WHERE_ON_THE_GROUND_3_AND_4_HOURS.get(0).getSegments().get(1);

    Segment SEGMENT_5 = TWO_SEGMENTS_WHERE_ON_THE_GROUND_3_AND_4_HOURS.get(1).getSegments().get(1);
    Segment SEGMENT_6 = TWO_SEGMENTS_WHERE_ON_THE_GROUND_3_AND_4_HOURS.get(1).getSegments().get(2);

}
