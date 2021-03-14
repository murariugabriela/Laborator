package com.company;

import java.util.HashMap;
import java.util.Map;

public class Location implements Comparable{
    private String name;
    private String description;
    private Map<Location, Integer> requiredTimeToGoBetweenLocations = new HashMap<>();

    public void addLocationAndTimePairToMap(Location location, Integer time) {
        if (location != null && time > 0)
            requiredTimeToGoBetweenLocations.put(location, time);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequiredTimeToGoBetweenLocations(Map<Location, Integer> requiredTimeToGoBetweenLocations) {
        this.requiredTimeToGoBetweenLocations = requiredTimeToGoBetweenLocations;
    }

    @Override
    public String toString() {
        return "Location: " +
                name +
                " ";
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

    @Override
    public int compareTo(Object o) {
        if(this instanceof Visitable && o instanceof Visitable)
        {
            return ((Visitable)this).getOpeningHour().compareTo(((Visitable)o).getOpeningHour());
        }
        return 0;
    }
}

