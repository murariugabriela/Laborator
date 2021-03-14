package com.company;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpeningHour();

    LocalTime getClosingHour();

    Duration getVisitingDuration();

    default LocalTime getOpeningHour2(){return LocalTime.of(9,30);}

    default LocalTime getClosingHour2(){return LocalTime.of(20,0);}

    static Duration getVisitingDuration(LocalTime openingHour,LocalTime closingHour){
        return Duration.between(openingHour,closingHour);
    }
}
