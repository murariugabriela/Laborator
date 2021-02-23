package com.company;

import java.util.Scanner;

class Source {
    private int capacity;
    private String name;
    SourceType type;

    @Override
    public String toString() {
        return getName() + " " + getCapacity() + " " + getType();
    }

    public Source(int capacity, String nume, String type) {
        setCapacity(capacity);
        setName(nume);
        int tipValid = 0;
        while (tipValid != 1) {
            try {
                setType(SourceType.valueOf(type));
                tipValid = 1;
            } catch (Exception e) {
                System.err.println("Tipul sursei " + this.name + " nu este valid. Tipurile valide sunt: " + SourceType.WAREHOUSE.name() + ", " + SourceType.FACTORY.name() + ". Incercati din nou.");
                Scanner console = new Scanner(System.in);
                type = console.next();
            }
        }
        System.out.println(getName() + " " + getCapacity() + " " + getType());
    }

    public Source() {
        System.out.println("Dati numele sursei:");
        Scanner console = new Scanner(System.in);
        setName(console.next());
        System.out.println("Dati capacitatea sursei:");
        setCapacity(console.nextInt());
        System.out.println("Dati tipul sursei dintre " + SourceType.FACTORY.name() + ", " + SourceType.WAREHOUSE.name() + ":");
        int tipValid = 0;
        while (tipValid != 1) {
            try {
                setType(SourceType.valueOf(console.next()));
                tipValid = 1;
            } catch (Exception e) {
                System.err.println("Tipul sursei nu este valid. Dati tipul sursei dintre:" + SourceType.FACTORY.name() + ", " + SourceType.WAREHOUSE.name() + ":");
            }
        }
        System.out.println(getName() + " " + getCapacity() + " " + getType());
    }

    public SourceType getType() {
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

    public void setType(SourceType type) {
        this.type = type;
    }
}