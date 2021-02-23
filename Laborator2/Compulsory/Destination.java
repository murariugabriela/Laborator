package com.company;

import java.util.Scanner;

class Destination {
    private int commodities;
    private String name;

    public Destination(int commodities, String name) {
        setCommodities(commodities);
        setName(name);
        System.out.println(getName() + " " + getCommodities());
    }

    @Override
    public String toString() {
        return getName() + " " + getCommodities();
    }

    public Destination() {
        System.out.println("Dati numele destinatiei:");
        Scanner console = new Scanner(System.in);
        setName(console.next());
        System.out.println("Dati numarul de comoditati ale destinatiei:");
        setCommodities(console.nextInt());
        System.out.println(getName() + " " + getCommodities());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCommodities() {
        return commodities;
    }

    public void setCommodities(int commodities) {
        this.commodities = commodities;
    }
}

