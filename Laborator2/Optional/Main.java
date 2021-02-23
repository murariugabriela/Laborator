package com.company;
//@author: Murariu Gabriela
// Grupa 2B3

import java.util.Scanner;

public class Main {
    /**
     * @param sources      contine toate obiectele de tipul sources instantiate
     * @param destinations contine toate obiectele de tipul destinations instantiate
     * @return returnez 1 daca exista o solutie pentru problema si 0 daca problema nu are nicio solutie, adica daca numarul de comoditati cerute este mai mare strict decat numarul total de comoditati posibile spre oferire
     */
    public static int verificareExistentaSolutie(Source[] sources, Destination[] destinations) {
        int i;
        int numarSurse = sources.length;
        int numarDestinatii = destinations.length;
        int capacitateTotala = 0, comoditatiTotal = 0;
        for (i = 0; i < numarSurse; i++) {
            capacitateTotala += sources[i].getCapacity();
        }
        for (i = 0; i < numarDestinatii; i++) {
            comoditatiTotal += destinations[i].getCommodities();
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
     * In functia main initializam vectorii cu surse si destinatii, de la tastatura sau direct din cod, dupa care verificam daca exista o solutie posibila pentru datele curente, iar daca exista continuam si pentru fiecare sources care are capacitatea diferita de 0, transportam comoditati pentru fiecare destinations, pe rand, calculand in acelasi timp costul total.
     * Programul parcurge sursele in ordinea declararii lor si pentru fiecare sources care are capacitatea nenula la momentul respectiv, parcurgem destinatiile care au comoditatile nenule si exploatam sursele la maxim, afisand la fiecare iesire din parcurgerea surselor capacitatea ramasa dupa atribuirea comoditatilor.
     * 
     */
    public static void main(String[] args) {
        Source[] sources = {new Factory(30, "S1"), new Factory(), new Warehouse(), new Warehouse(20, "S2")};
        Destination[] destinations = {new Destination(), new Destination(4, "D2"), new Destination()};
        int[][] cost;
        int i, j;
        int costTotal = 0;
        int numarSurse = sources.length;
        int numarDestinatii = destinations.length;
        if (verificareExistentaSolutie(sources, destinations) == 0) {
            System.out.println("Problema nu are solutie: capacitatile surselor nu pot efectua cererile de comoditati ale destinatiilor");
        } else {
            cost = initializareMatriceCosturi(numarSurse, numarDestinatii);
            for (i = 0; i < numarSurse; i++) {
                if (sources[i].getCapacity() != 0) {
                    for (j = 0; j < numarDestinatii; j++) {
                        if (sources[i].getCapacity() != 0 && destinations[j].getCommodities() != 0) {
                            //noinspection IfStatementWithIdenticalBranches
                            if (destinations[j].getCommodities() < sources[i].getCapacity()) {
                                int trasnport = destinations[j].getCommodities();
                                System.out.println(sources[i].getName() + "->" + destinations[j].getName() + ":" + trasnport + "unitati" + cost[i][j] + "cost");
                                sources[i].setCapacity(sources[i].getCapacity() - destinations[j].getCommodities());
                                destinations[j].setCommodities(0);
                                costTotal = trasnport * cost[i][j] + costTotal;

                            } else {
                                int trasnport = sources[i].getCapacity();
                                System.out.println(sources[i].getName() + "->" + destinations[j].getName() + ":" + trasnport + "unitati" + cost[i][j] + "cost");
                                destinations[j].setCommodities(destinations[j].getCommodities() - sources[i].getCapacity());
                                sources[i].setCapacity(0);
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
