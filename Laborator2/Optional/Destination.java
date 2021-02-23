package com.company;

import java.util.Objects;
import java.util.Scanner;

class Destination {
    private int commodities;
    private String name;
    private static int numarDestinatiiValabile = -1;
    private static Destination[] destinatiiValabile = new Destination[10];

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Destination(int commodities, String name) {
        setCommodities(commodities);
        setName(name);
        int i;
        System.out.println(numarDestinatiiValabile);
        int gasitNume, numeValabil = 0;
        while (numeValabil == 0) {
            gasitNume = 0;
            for (i = 0; i <= numarDestinatiiValabile; i++) {
                if (destinatiiValabile[i].equals(this)) {
                    gasitNume = 1;
                }
            }
            if (gasitNume == 0)
                numeValabil = 1;
            else {
                Scanner console = new Scanner(System.in);
                System.out.println("Numele destinatiei este deja folosit. Dati numele destinatiei:");
                String nume = console.next();
                setName(nume);
            }
        }
        numarDestinatiiValabile++;
        destinatiiValabile[numarDestinatiiValabile] = this;
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
        int gasitNume, numeValabil = 0;
        while (numeValabil == 0) {
            gasitNume = 0;
            int i;
            for (i = 0; i <= numarDestinatiiValabile; i++) {
                if (destinatiiValabile[i].equals(this)) {
                    gasitNume = 1;
                }
            }
            if (gasitNume == 0)
                numeValabil = 1;
            else {
                System.out.println("Numele destinatiei este deja folosit. Dati numele destinatiei:");
                String nume = console.next();
                setName(nume);
            }
        }
        numarDestinatiiValabile++;
        destinatiiValabile[numarDestinatiiValabile] = this;
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
