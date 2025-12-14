package com.codegym.task.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Janitorial services

*/

public class Solution {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        // Write your implementation of Items 1-4 here
        apartments.forEach(ap -> {
            if (ap instanceof OneRoomApt) ((OneRoomApt) ap).clean1Room();
            else if (ap instanceof TwoRoomApt) ((TwoRoomApt) ap).clean2Rooms();
            else if (ap instanceof ThreeRoomApt) ((ThreeRoomApt) ap).clean3Rooms();
        });
    }

    static interface Apartment {
    }

    static class OneRoomApt implements Apartment {
        void clean1Room() {
            System.out.println("1 room has been cleaned");
        }
    }

    static class TwoRoomApt implements Apartment {
        void clean2Rooms() {
            System.out.println("2 rooms have been cleaned");
        }
    }

    static class ThreeRoomApt implements Apartment {
        void clean3Rooms() {
            System.out.println("3 rooms have been cleaned");
        }
    }
}
