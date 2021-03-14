package com.company;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;

public class Church extends Location implements Visitable {
    private LocalTime openingHour;
    private LocalTime closingHour;

    Church(LocalTime openingHour,LocalTime closingHour, String name, String description) {
        setDescription(description);
        setName(name);
        setClosingHour(closingHour);
        setOpeningHour(openingHour);
    }

    Church(String name, String description) {
        setDescription(description);
        setName(name);
        setOpeningHour(getOpeningHour2());
        setClosingHour(getClosingHour2());
    }

    @Override
    public void setRequiredTimeToGoBetweenLocations(Map<Location, Integer> requiredTimeToGoBetweenLocations) {
        super.setRequiredTimeToGoBetweenLocations(requiredTimeToGoBetweenLocations);
    }

    @Override
    public Map<Location, Integer> getRequiredTimeToGoBetweenLocations() {
        return super.getRequiredTimeToGoBetweenLocations();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    @Override
    public LocalTime getOpeningHour() {
        return openingHour;
    }

    public Duration getVisitingDuration() {
        return Visitable.getVisitingDuration(openingHour,closingHour);
    }

    @Override
    public LocalTime getClosingHour() {
        return closingHour;
    }
}
