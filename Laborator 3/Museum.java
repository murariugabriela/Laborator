package com.company;

import java.time.LocalTime;
import java.util.Map;

public class Museum extends Location implements Visitable, Payable, Classifiable {
    private double ticketPrice;
    private LocalTime openingHour;
    private double rank;

    Museum(double ticketPrice, LocalTime openingHour, double rank, String description, String name) {
        setRank(rank);
        setOpeningHour(openingHour);
        setTicketPrice(ticketPrice);
        setName(name);
        setDescription(description);
    }

    @Override
    public void setRequiredTimeToGoBetweenLocations(Map<Location, Integer> requiredTimeToGoBetweenLocations) {
        super.setRequiredTimeToGoBetweenLocations(requiredTimeToGoBetweenLocations);
    }

    @Override
    public Map<Location, Integer> getRequiredTimeToGoBetweenLocations() {
        return super.getRequiredTimeToGoBetweenLocations();
    }

    @Override
    public boolean isPayable() {
        return true;
    }

    @Override
    public boolean isVisitable() {
        return true;
    }

    @Override
    public boolean isClassifiable() {
        return true;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    public double getRank() {
        return rank;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public LocalTime getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
