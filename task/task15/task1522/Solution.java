package com.codegym.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Reinforce the singleton pattern

*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    // Add static block here
    static
    {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // Implement step #5 here
        try{
          BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
          String value = reader.readLine();
          if (value.equals(Planet.EARTH)) thePlanet = thePlanet = Earth.getInstance();
          else if (value.equals(Planet.MOON)) thePlanet = Moon.getInstance();
          else if (value.equals(Planet.SUN)) thePlanet = Sun.getInstance();
          else thePlanet = null;
          reader.close();
        } catch (IOException e) {

        }
    }
}
