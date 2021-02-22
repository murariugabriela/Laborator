package com.company;

import java.util.Scanner;
/*
@Author: Murariu Gabriela
AnGrupa: 2B3
*/
class Source {
    private int capacity;
    private String name;
    Main.SourceType type;

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
                setType(Main.SourceType.valueOf(type));
                tipValid = 1;
            } catch (Exception e) {
                System.err.println("Tipul sursei " + this.name + " nu este valid. Tipurile valide sunt: " + Main.SourceType.WAREHOUSE.name() + ", " + Main.SourceType.FACTORY.name() + ". Incercati din nou.");
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
        System.out.println("Dati tipul sursei dintre " + Main.SourceType.FACTORY.name() + ", " + Main.SourceType.WAREHOUSE.name() + ":");
        int tipValid = 0;
        while (tipValid != 1) {
            try {
                setType(Main.SourceType.valueOf(console.next()));
                tipValid = 1;
            } catch (Exception e) {
                System.err.println("Tipul sursei nu este valid. Dati tipul sursei dintre:" + Main.SourceType.FACTORY.name() + ", " + Main.SourceType.WAREHOUSE.name() + ":");
            }
        }
        System.out.println(getName() + " " + getCapacity() + " " + getType());
    }

    public Main.SourceType getType() {
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

    public void setType(Main.SourceType type) {
        this.type = type;
    }
}

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

public class Main {

    public enum SourceType {
        WAREHOUSE, FACTORY;
    }

    public static void main(String[] args) {
        Source[] sursa = {new Source(30, "S1", "WAREHOUS"), new Source(5, "S2", "FACTORY"), new Source(0, "S3", "FACTORY"), new Source()};
        Destination[] destinatie = {new Destination(), new Destination(4, "D2"), new Destination()};
        int[][] cost = new int[sursa.length][destinatie.length];
        int i, j;
        int costTotal = 0;
        Scanner console = new Scanner(System.in);
        int numarSurse = sursa.length;
        int numarDestinatii = destinatie.length;
        int capacitateTotala = 0, comoditatiTotal = 0;
        for (i = 0; i < numarSurse; i++) {
            capacitateTotala += sursa[i].getCapacity();
        }
        for (i = 0; i < numarDestinatii; i++) {
            comoditatiTotal += destinatie[i].getCommodities();
        }
        if (capacitateTotala < comoditatiTotal) {
            System.out.println("Problema nu are solutie: capacitatile surselor nu pot efectua cererile de comoditati ale destinatiilor");
        } else {
            System.out.println("Dati costurile aferente surselor catre destinatii(" + numarDestinatii * numarSurse + "):");
            for (i = 0; i < numarSurse; i++) {
                for (j = 0; j < numarDestinatii; j++) {
                    cost[i][j] = console.nextInt();
                }
            }
            for (i = 0; i < numarSurse; i++) {
                for (j = 0; j < numarDestinatii; j++) {
                    System.out.print(cost[i][j] + " ");
                }
                System.out.println();
            }
            for (i = 0; i < numarSurse; i++) {
                if (sursa[i].getCapacity() != 0) {
                    for (j = 0; j < numarDestinatii; j++) {
                        if (sursa[i].getCapacity() != 0 && destinatie[j].getCommodities() != 0) {
                            if (destinatie[j].getCommodities() < sursa[i].getCapacity()) {
                                int trasnport = destinatie[j].getCommodities();
                                System.out.println(sursa[i].getName() + "->" + destinatie[j].getName() + ":" + trasnport + "unitati" + cost[i][j] + "cost");
                                sursa[i].setCapacity(sursa[i].getCapacity() - destinatie[j].getCommodities());
                                destinatie[j].setCommodities(0);
                                costTotal = trasnport * cost[i][j] + costTotal;

                            } else {
                                int trasnport = sursa[i].getCapacity();
                                System.out.println(sursa[i].getName() + "->" + destinatie[j].getName() + ":" + trasnport + "unitati" + cost[i][j] + "cost");
                                destinatie[j].setCommodities(destinatie[j].getCommodities() - sursa[i].getCapacity());
                                sursa[i].setCapacity(0);
                                costTotal = trasnport * cost[i][j] + costTotal;
                            }
                        }

                    }
                }
                System.out.println(sursa[i].toString());
            }
            System.out.println("Cost total: " + costTotal);
        }
    }
}
