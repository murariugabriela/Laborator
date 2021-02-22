package com.company;

import java.util.Objects;
import java.util.Scanner;
/*
@Author: Murariu Gabriela
AnGrupa: 2B3
*/
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

class Factory extends Source {
    public Factory() {
        System.out.println("Dati numele sursei:");
        Scanner console = new Scanner(System.in);
        String numeSursa = console.next();
        setName(numeSursa);
        System.out.println("Dati capacitatea sursei:");
        setCapacity(console.nextInt());
        setType("FACTORY");
        int i, gasitNume, numeValabil = 0;
        while (numeValabil == 0) {
            gasitNume = 0;
            for (i = 0; i <= numarSurseValabile; i++) {
                if (surseValabile[i].equals(this)) {
                    gasitNume = 1;
                }
            }
            if (gasitNume == 0)
                numeValabil = 1;
            else {
                System.out.println("Numele sursei este deja folosit. Dati numele sursei:");
                numeSursa = console.next();
                setName(numeSursa);
            }
        }
        numarSurseValabile++;
        surseValabile[numarSurseValabile] = this;
        System.out.println(getName() + " " + getCapacity() + " " + getType());
    }

    public Factory(int capacity, String nume) {
        setCapacity(capacity);
        setName(nume);
        setType("FACTORY");
        int i, gasitNume, numeValabil = 0;
        while (numeValabil == 0) {
            gasitNume = 0;
            for (i = 0; i <= numarSurseValabile; i++) {
                if (surseValabile[i].equals(this)) {
                    gasitNume = 1;
                }
            }
            if (gasitNume == 0)
                numeValabil = 1;
            else {
                Scanner console = new Scanner(System.in);
                System.out.println("Numele sursei este deja folosit. Dati numele sursei:");
                nume = console.next();
                setName(nume);
            }
        }
        numarSurseValabile++;
        surseValabile[numarSurseValabile] = this;
        System.out.println(getName() + " " + getCapacity() + " " + getType());
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setCapacity(int capacity) {
        super.setCapacity(capacity);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }
}

class Warehouse extends Source {
    public Warehouse() {
        int i;
        System.out.println("Dati numele sursei:");
        Scanner console = new Scanner(System.in);
        setName(console.next());
        System.out.println("Dati capacitatea sursei:");
        setCapacity(console.nextInt());
        setType("WAREHOUSE");
        int gasitNume, numeValabil = 0;
        while (numeValabil == 0) {
            gasitNume = 0;
            for (i = 0; i <= numarSurseValabile; i++) {
                if (surseValabile[i].equals(this)) {
                    gasitNume = 1;
                }
            }
            if (gasitNume == 0)
                numeValabil = 1;
            else {
                System.out.println("Numele sursei este deja folosit. Dati numele sursei:");
                String nume = console.next();
                setName(nume);
            }
        }
        numarSurseValabile++;
        surseValabile[numarSurseValabile] = this;
        System.out.println(getName() + " " + getCapacity() + " " + getType());
    }

    public Warehouse(int capacity, String nume) {
        setCapacity(capacity);
        setName(nume);
        setType("WAREHOUSE");
        int i, gasitNume, numeValabil = 0;
        while (numeValabil == 0) {
            gasitNume = 0;
            for (i = 0; i <= numarSurseValabile; i++) {
                if (surseValabile[i].equals(this)) {
                    gasitNume = 1;
                }
            }
            if (gasitNume == 0)
                numeValabil = 1;
            else {
                Scanner console = new Scanner(System.in);
                System.out.println("Numele sursei este deja folosit. Dati numele sursei:");
                nume = console.next();
                setName(nume);
            }
        }
        numarSurseValabile++;
        surseValabile[numarSurseValabile] = this;
        System.out.println(getName() + " " + getCapacity() + " " + getType());
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setCapacity(int capacity) {
        super.setCapacity(capacity);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }
}

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

public class Main {
    /**
     * @param sursa      contine toate obiectele de tipul sursa instantiate
     * @param destinatie contine toate obiectele de tipul destinatie instantiate
     * @return returnez 1 daca exista o solutie pentru problema si 0 daca problema nu are nicio solutie, adica daca numarul de comoditati cerute este mai mare strict decat numarul total de comoditati posibile spre oferire
     */
    public static int verificareExistentaSolutie(Source[] sursa, Destination[] destinatie) {
        int i;
        int numarSurse = sursa.length;
        int numarDestinatii = destinatie.length;
        int capacitateTotala = 0, comoditatiTotal = 0;
        for (i = 0; i < numarSurse; i++) {
            capacitateTotala += sursa[i].getCapacity();
        }
        for (i = 0; i < numarDestinatii; i++) {
            comoditatiTotal += destinatie[i].getCommodities();
        }
        if (comoditatiTotal > capacitateTotala)
            return 0;
        else
            return 1;
    }

    /**
     * @param numarSurse      reprezinta numarul total de surse
     * @param numarDestinatii reprezinta numarul total de destinatii
     * @return returneaza matricea corespunzatoare costurilor, cu valori introduse de la tastatura
     */
    public static int[][] initializareMatriceCosturi(int numarSurse, int numarDestinatii) {
        System.out.println("Dati costurile aferente surselor catre destinatii(" + numarDestinatii * numarSurse + "):");
        int[][] cost = new int[numarSurse][numarDestinatii];
        int i, j;
        Scanner console = new Scanner(System.in);
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
        return cost;
    }

    /**
     * In functia main initializam vectorii cu surse si destinatii, de la tastatura sau direct din cod, dupa care verificam daca exista o solutie posibila pentru datele curente, iar daca exista continuam si pentru fiecare sursa care are capacitatea diferita de 0, transportam comoditati pentru fiecare destinatie, pe rand, calculand in acelasi timp costul total.
     */
    public static void main(String[] args) {
        Source[] sursa = {new Factory(30, "S1"), new Factory(), new Warehouse(), new Warehouse(20, "S2")};
        Destination[] destinatie = {new Destination(), new Destination(4, "D2"), new Destination()};
        int[][] cost;
        int i, j;
        int costTotal = 0;
        int numarSurse = sursa.length;
        int numarDestinatii = destinatie.length;
        if (verificareExistentaSolutie(sursa, destinatie) == 0) {
            System.out.println("Problema nu are solutie: capacitatile surselor nu pot efectua cererile de comoditati ale destinatiilor");
        } else {
            cost = initializareMatriceCosturi(numarSurse, numarDestinatii);
            for (i = 0; i < numarSurse; i++) {
                if (sursa[i].getCapacity() != 0) {
                    for (j = 0; j < numarDestinatii; j++) {
                        if (sursa[i].getCapacity() != 0 && destinatie[j].getCommodities() != 0) {
                            //noinspection IfStatementWithIdenticalBranches
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
            }
            System.out.println("Cost total: " + costTotal);
        }
    }
}
