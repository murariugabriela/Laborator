package com.company;

import java.time.LocalTime;
import java.util.*;

public class City {
    public List<Location> locations;
    public String name;

    City(List<Location> locations, String name) {
        setName(name);
        setLocations(locations);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void displayVisitableNotPayableLocations() {
        Map<Location, LocalTime> visitableNotPayableLocations = new HashMap<>();
        for (Location location : locations) {
            if ((location instanceof Visitable) && !(location instanceof Payable)) {
                visitableNotPayableLocations.put(location, ((Visitable) location).getOpeningHour());
            }
        }
        List<Map.Entry<Location,LocalTime>> locationsByOpeningTime = new ArrayList(visitableNotPayableLocations.entrySet());
        locationsByOpeningTime.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Location,LocalTime> location : locationsByOpeningTime) {
            System.out.print(location.getKey());
            System.out.println(location.getValue());
        }
    }

    public List<Location> getLocations() {
        return locations;
    }
}
