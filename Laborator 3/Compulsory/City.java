package com.company;

import java.util.List;

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

    public List<Location> getLocations() {
        return locations;
    }
}
