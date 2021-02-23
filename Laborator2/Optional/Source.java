package com.company;

import java.util.Objects;

abstract class Source {
    private int capacity;
    private String name;
    private String type;
    static Source[] surseValabile = new Source[10];
    static int numarSurseValabile = -1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(name, source.name);
    }

    @Override
    public int hashCode() {
        int result;
        result = Objects.hash(name);
        return result;
    }

    @Override
    public String toString() {
        return getName() + " " + getCapacity() + " " + getType();
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
