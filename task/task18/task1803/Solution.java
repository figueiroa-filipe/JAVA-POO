package com.codegym.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Most frequent bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (FileInputStream input = new FileInputStream(reader.readLine())) {
                ArrayList<Integer> lista = new ArrayList<>();
                while (input.available() > 0) {
                    int tempValue = input.read();
                    lista.add(tempValue);
                }
                HashMap<Integer, Integer> map = new HashMap<>();
                for (Integer i : lista) {

                    map.putIfAbsent(i, 0);
                    map.put(i, map.get(i) + 1);
                }
                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                        .filter(e -> e.getValue() > 2)
                        .forEach(e -> System.out.print(e.getKey() + " "));
            }
        }
    }
}
