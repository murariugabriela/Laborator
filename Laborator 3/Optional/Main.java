package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Location location1 = new Hotel(4.5, "Continental", "Descriere hotel 1");
        Location location2 = new Church(LocalTime.of(7, 30), LocalTime.of(19, 30), "Sfantul Lazar", "Are hramul in august pe 15");
        Location location3 = new Museum(12.5, LocalTime.of(9, 0), LocalTime.of(17, 30), "Descriere muzeu 1", "Muzeu1");
        Restaurant location4 = new Restaurant(4.2, LocalTime.of(10, 30), LocalTime.of(22, 0), "Mamma mia", "Descriere restaurant1");
        Location location5 = new Restaurant(4.2, "Vivo", "Descriere restaurant2");
        Church location6 = new Church("Biserica2", "Descriere biserica2");
        Location location7 = new Church("Biserica3", "Descriere biserica3");

        location1.addLocationAndTimePairToMap(location2, 12);
        location1.addLocationAndTimePairToMap(location3, 20);
        location1.addLocationAndTimePairToMap(location4, 10);
        location2.addLocationAndTimePairToMap(location1, 16);
        location2.addLocationAndTimePairToMap(location3, 21);
        location2.addLocationAndTimePairToMap(location4, 11);
        location3.addLocationAndTimePairToMap(location2, 14);
        location3.addLocationAndTimePairToMap(location1, 20);
        location3.addLocationAndTimePairToMap(location4, 12);
        location4.addLocationAndTimePairToMap(location2, 13);
        location4.addLocationAndTimePairToMap(location3, 19);
        location4.addLocationAndTimePairToMap(location1, 17);

        List<Location> locations = new ArrayList<>(Arrays.asList(location1, location2, location3, location4, location5, location6, location7));
        System.out.print(location6);
        System.out.println(location6.getVisitingDuration());
        System.out.print(location4);
        System.out.println(location4.getVisitingDuration());

        City city = new City(locations, "Iasi");
        city.displayVisitableNotPayableLocations();

        TravelPlan travelPlan = new TravelPlan();
        travelPlan.setCity(city);
        travelPlan.setPreferences(Arrays.asList(location2, location5, location6, location3, location1, location4, location7));



    }
}
