package com.company;

import javafx.util.Pair;

import java.util.Map;

public class Hotel extends Location implements Classifiable {
    private double rank;

    Hotel(double rank, String name, String description) {
        setRank(rank);
        setName(name);
        setDescription(description);
    }

    @Override
    public boolean isClassifiable() {
        return true;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public double getRank() {
        return rank;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    public void setRank(double rank) {
        this.rank = rank;
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
    public void setDescription(String description) {
        super.setDescription(description);
    }
}
