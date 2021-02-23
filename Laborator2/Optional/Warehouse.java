package com.company;

import java.util.Scanner;

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
