package com.company;

import java.util.ArrayList;
import java.util.List;

public class TravelPlan {
    private City city;
    private List<Location> preferences = new ArrayList<>();

    public void setPreferences(List<Location> preferences) {
        this.preferences = preferences;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public List<Location> getPreferences() {
        return preferences;
    }

    public List<Location> shortestPathBetweenTwoLocations(Location startLocation, Location stopLocation, int[][] costMatrix, List<Location> locations) {
        List<Location> shortestPath = new ArrayList<>();
        int numberOfLocations = costMatrix.length;
        shortestPath.add(startLocation);
        Location provisoryLocation = new Location();
        int startPosition = locations.indexOf(startLocation);
        int stopPosition = locations.indexOf(stopLocation);
        int startMinimum;
        int totalCost = 0;
        boolean locationFound = true;
        startMinimum = costMatrix[startPosition][stopPosition];
        while (locationFound) {
            int partialCost = 0;
            locationFound = false;
            for (int i = 0; i < numberOfLocations; ++i) {
                if (startPosition != i && stopPosition != i && preferences.indexOf(startLocation) > preferences.indexOf(locations.get(i)) && (costMatrix[startPosition][i] + costMatrix[i][stopPosition] + totalCost) < startMinimum) {
                    startMinimum = costMatrix[startPosition][i] + costMatrix[i][stopPosition] + totalCost;
                    provisoryLocation = locations.get(i);
                    locationFound = true;
                    partialCost = costMatrix[startPosition][i];
                }
            }
            if (locationFound) {
                shortestPath.add(provisoryLocation);
                startLocation = provisoryLocation;
                startPosition = locations.indexOf(startLocation);
                totalCost = totalCost + partialCost;
            }
        }
        shortestPath.add(stopLocation);

        return shortestPath;
    }
}
