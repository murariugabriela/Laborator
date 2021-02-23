package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Source[] sources = {new Source(30, "S1", "WAREHOUS"), new Source(5, "S2", "FACTORY"), new Source(0, "S3", "FACTORY"), new Source()};
        Destination[] destinations = {new Destination(), new Destination(4, "D2"), new Destination()};
        int[][] cost = new int[sources.length][destinations.length];
        int i, j;
        int costTotal = 0;
        Scanner console = new Scanner(System.in);
        int numarSurse = sources.length;
        int numarDestinatii = destinations.length;
        int capacitateTotala = 0, comoditatiTotal = 0;
        for (i = 0; i < numarSurse; i++) {
            capacitateTotala += sources[i].getCapacity();
        }
        for (i = 0; i < numarDestinatii; i++) {
            comoditatiTotal += destinations[i].getCommodities();
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
                if (sources[i].getCapacity() != 0) {
                    for (j = 0; j < numarDestinatii; j++) {
                        if (sources[i].getCapacity() != 0 && destinations[j].getCommodities() != 0) {
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
                System.out.println(sources[i].toString());
            }
            System.out.println("Cost total: " + costTotal);
        }
    }
}
