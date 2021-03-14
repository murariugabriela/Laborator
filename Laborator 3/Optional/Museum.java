package com.company;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;

public class Museum extends Location implements Visitable, Payable {
    private double ticketPrice;
    private LocalTime openingHour;
    private LocalTime closingHour;

    Museum(double ticketPrice, LocalTime openingHour, LocalTime closingHour, String description, String name) {
        setOpeningHour(openingHour);
        setTicketPrice(ticketPrice);
        setName(name);
        setClosingHour(closingHour);
        setDescription(description);
    }

    @Override
    public LocalTime getOpeningHour() {
        return openingHour;
    }

    @Override
    public LocalTime getClosingHour() {
        return closingHour;
    }

    @Override
    public void setRequiredTimeToGoBetweenLocations(Map<Location, Integer> requiredTimeToGoBetweenLocations) {
        super.setRequiredTimeToGoBetweenLocations(requiredTimeToGoBetweenLocations);
    }

    @Override
    public Map<Location, Integer> getRequiredTimeToGoBetweenLocations() {
        return super.getRequiredTimeToGoBetweenLocations();
    }

    public Duration getVisitingDuration() {
        return Visitable.getVisitingDuration(openingHour,closingHour);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
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

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
