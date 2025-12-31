package com.codegym.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Rarest bytes

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
                int min = Integer.MAX_VALUE;
                for(Map.Entry<Integer, Integer> e : map.entrySet()){
                    min = Math.min(min, e.getValue());
                }
                int finalMin = min;
                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.<Integer, Integer>comparingByValue())
                        .filter(e -> e.getValue() == finalMin)
                        .forEach(e -> System.out.print(e.getKey() + " "));
            }
        }
    }
}
