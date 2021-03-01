package com.company;

import java.time.LocalTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Location location1 = new Hotel(4.5, "Continental", "Descriere hotel 1");
        Location location2 = new Church(LocalTime.NOON, "Sfantul Lazar", "Are hramul in august pe 15");
        Location location3 = new Museum(12.5, LocalTime.NOON.minusHours(2), 3.9, "Descriere muzeu 1", "Muzeu1");
        Location location4 = new Restaurant(4.2, LocalTime.NOON.minusHours(3), "Mamma mia", "Descriere restaurant1");
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
        List<Location> locations = new ArrayList<>();
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        locations.add(location4);
        City city = new City(locations, "Iasi");

    }
}
