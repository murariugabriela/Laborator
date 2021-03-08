package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student {
    private String name;
    private List<School> preferences = new ArrayList<>();

    public String getName() {
        return name;
    }


    Student(String name) {
        setName(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public void setPreferences(List<School> preferences) {
        this.preferences = preferences;
    }

    public List<School> getPreferences() {
        return preferences;
    }

    public void setName(String name) {
        this.name = name;
    }




}
