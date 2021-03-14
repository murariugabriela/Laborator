package com.company;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TravelPlan {
    private City city;
    private List<Location> Preferences = new ArrayList<>();

    public void setPreferences(List<Location> preferences) {
        Preferences = preferences;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public List<Location> getPreferences() {
        return Preferences;
    }

    /*public List<Location> shortestPathBetweenTwoLocations(Location startLocation1, Location stopLocation, Map<Location, Integer> requiredTimeToGoBetweenLocations)
    {
        List<Location> shortestPath = new ArrayList<>();
        List<Integer> visited= new ArrayList<>();
        int numberOfKeys=requiredTimeToGoBetweenLocations.keySet().size();
        System.out.println(numberOfKeys);

        return shortestPath;
    }*/
}
