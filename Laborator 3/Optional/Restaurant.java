package com.company;

import javafx.util.Pair;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;

public class Restaurant extends Location implements Visitable, Classifiable {
    private LocalTime openingHour;
    private LocalTime closingHour;
    private double rank;

    Restaurant(double rank, LocalTime openingHour,LocalTime closingHour, String name, String description) {
        setRank(rank);
        setOpeningHour(openingHour);
        setName(name);
        setClosingHour(closingHour);
        setDescription(description);

    }

    Restaurant(double rank, String name, String description) {
        setRank(rank);
        setOpeningHour(getOpeningHour2());
        setName(name);
        setClosingHour(getClosingHour2());
        setDescription(description);

    }

    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    @Override
    public double getRank() {
        return rank;
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
    public void setRequiredTimeToGoBetweenLocations(Map<Location, Integer> requiredTimeToGoBetweenLocations) {
        super.setRequiredTimeToGoBetweenLocations(requiredTimeToGoBetweenLocations);
    }

    @Override
    public Map<Location, Integer> getRequiredTimeToGoBetweenLocations() {
        return super.getRequiredTimeToGoBetweenLocations();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public Duration getVisitingDuration() {
        return Visitable.getVisitingDuration(openingHour,closingHour);
    }

    @Override
    public LocalTime getOpeningHour() {
        return openingHour;
    }

    @Override
    public LocalTime getClosingHour() {
        return closingHour;
    }
}
