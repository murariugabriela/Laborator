package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Location location1 = new Hotel(4.5, "Continental", "Descriere hotel 1");
        Location location2 = new Church(LocalTime.of(7, 30), LocalTime.of(19, 30), "Sfantul Lazar", "Are hramul in august pe 15");
        Location location3 = new Museum(12.5, LocalTime.of(9, 0), LocalTime.of(17, 30), "Descriere muzeu 1", "Muzeu1");
        Restaurant location4 = new Restaurant(4.2, LocalTime.of(10, 30), LocalTime.of(22, 0), "Mamma mia", "Descriere restaurant1");
        Location location5 = new Restaurant(4.2, "Vivo", "Descriere restaurant2");
        Church location6 = new Church("Biserica2", "Descriere biserica2");
        int[][] costMatrix = new int[6][6];
        costMatrix[1][1]=costMatrix[2][2]=costMatrix[3][3]=costMatrix[4][4]=costMatrix[5][5]=costMatrix[0][0]=0;
        location1.addLocationAndTimePairToMap(location2, 12);
        costMatrix[0][1]=12;
        location1.addLocationAndTimePairToMap(location3, 20);
        costMatrix[0][2]=20;
        location1.addLocationAndTimePairToMap(location4, 32);
        costMatrix[0][3]=32;
        location1.addLocationAndTimePairToMap(location5, 13);
        costMatrix[0][4]=13;
        location1.addLocationAndTimePairToMap(location6, 9);
        costMatrix[0][5]=9;

        location2.addLocationAndTimePairToMap(location1, 36);
        costMatrix[1][0]=36;
        location2.addLocationAndTimePairToMap(location3, 21);
        costMatrix[1][2]=21;
        location2.addLocationAndTimePairToMap(location4, 11);
        costMatrix[1][3]=11;
        location2.addLocationAndTimePairToMap(location5, 24);
        costMatrix[1][4]=24;
        location2.addLocationAndTimePairToMap(location6, 14);
        costMatrix[1][5]=14;

        location3.addLocationAndTimePairToMap(location2, 14);
        costMatrix[2][1]=14;
        location3.addLocationAndTimePairToMap(location1, 30);
        costMatrix[2][0]=30;
        location3.addLocationAndTimePairToMap(location4, 12);
        costMatrix[2][3]=12;
        location3.addLocationAndTimePairToMap(location5, 21);
        costMatrix[2][4]=21;
        location3.addLocationAndTimePairToMap(location6, 13);
        costMatrix[2][5]=13;

        location4.addLocationAndTimePairToMap(location2, 13);
        costMatrix[3][1]=13;
        location4.addLocationAndTimePairToMap(location3, 19);
        costMatrix[3][2]=19;
        location4.addLocationAndTimePairToMap(location1, 27);
        costMatrix[3][0]=27;
        location4.addLocationAndTimePairToMap(location5, 32);
        costMatrix[3][4]=32;
        location4.addLocationAndTimePairToMap(location6, 10);
        costMatrix[3][5]=10;

        location5.addLocationAndTimePairToMap(location2, 11);
        costMatrix[4][1]=11;
        location5.addLocationAndTimePairToMap(location3, 28);
        costMatrix[4][2]=28;
        location5.addLocationAndTimePairToMap(location1, 13);
        costMatrix[4][0]=13;
        location5.addLocationAndTimePairToMap(location4, 42);
        costMatrix[4][3]=42;
        location5.addLocationAndTimePairToMap(location6, 9);
        costMatrix[4][5]=9;

        location6.addLocationAndTimePairToMap(location2, 10);
        costMatrix[5][1]=10;
        location6.addLocationAndTimePairToMap(location3, 45);
        costMatrix[5][2]=45;
        location6.addLocationAndTimePairToMap(location1, 11);
        costMatrix[5][0]=11;
        location6.addLocationAndTimePairToMap(location4, 21);
        costMatrix[5][3]=22;
        location6.addLocationAndTimePairToMap(location5, 36);
        costMatrix[5][4]=36;

        List<Location> locations = new ArrayList<>(Arrays.asList(location1, location2, location3, location4, location5, location6));
        System.out.print(location6);
        System.out.println(location6.getVisitingDuration());
        System.out.print(location4);
        System.out.println(location4.getVisitingDuration());

        City city = new City(locations, "Iasi");
        city.displayVisitableNotPayableLocations();

        TravelPlan travelPlan = new TravelPlan();
        travelPlan.setCity(city);
        travelPlan.setPreferences(Arrays.asList(location2, location5, location6, location3, location1, location4));
        System.out.println(travelPlan.shortestPathBetweenTwoLocations(location1,location4, costMatrix,locations));


    }
}
