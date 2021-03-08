package com.company;

import java.util.ArrayList;
import java.util.List;

public class School implements Comparable<School>{
    private String name;
    private int capacity;
    private List<Student> preferences = new ArrayList<>();

    public void setPreferences(List<Student> preferences) {
        this.preferences = preferences;
    }
    public void addPreferences(Student preference) {
        this.preferences.add(preference);
    }
    School(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(School o) {
        return this.getName().compareTo(o.getName());
    }

    public List<Student> getPreferences() {
        return preferences;
    }
}
