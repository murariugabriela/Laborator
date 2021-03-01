package com.company;

import javafx.util.Pair;

import java.time.LocalTime;
import java.util.Map;

public class Restaurant extends Location implements Visitable, Classifiable {
    private LocalTime openingHour;
    private double rank;

    Restaurant(double rank, LocalTime openingHour, String name, String description) {
        setRank(rank);
        setOpeningHour(openingHour);
        setName(name);
        setDescription(description);

    }

    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public LocalTime getOpeningHour() {
        return openingHour;
    }

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

    @Override
    public boolean isVisitable() {
        return true;
    }

    @Override
    public boolean isClassifiable() {
        return true;
    }

}
