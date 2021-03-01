package com.company;

import javafx.util.Pair;

import java.util.Map;

public class Location {
    private String name;
    private String description;
    private Map<Location, Integer> requiredTimeToGoBetweenLocations;
    public void addLocationAndTimePairToMap(Location location,Integer time){
        if(location!=null&&time>0)
        requiredTimeToGoBetweenLocations.put(location,time);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setRequiredTimeToGoBetweenLocations(Map<Location, Integer> requiredTimeToGoBetweenLocations) {
        this.requiredTimeToGoBetweenLocations = requiredTimeToGoBetweenLocations;
    }

    public Map<Location, Integer> getRequiredTimeToGoBetweenLocations() {
        return requiredTimeToGoBetweenLocations;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
